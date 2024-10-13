import { Component, ViewChild } from '@angular/core';
import { MatCellDef, MatTableDataSource } from '@angular/material/table';
import { lastValueFrom } from 'rxjs';
import { AuthService } from 'src/app/public/login/auth.service';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { Pageable } from 'src/app/core/models/Pageable';
import { BoletaService } from '../services/boleta.service';


@Component({
  selector: 'app-boletas',
  templateUrl: './boletas.component.html',
  styleUrls: ['./boletas.component.scss']
})
export class BoletasComponent {

  displayedColumns = ['idBoleta', 'tipoPlanilla','mesAnio','codModular',  'nrRegistro', 'nombres', 'codConcepto' , 'concepto','montoBruto','informacion'];
  dataSource = new MatTableDataSource<any>();
  boletas:any[]=[]
  pageable: Pageable = {
    page: 0,
    size: 10,
    orderParameter: 'mesAnio',
    typeOrder: 'ASC',
  };
  @ViewChild(MatPaginator) paginator!: MatPaginator ;

  usuarioLogueado:any
  constructor(private boletaService:BoletaService,private authService:AuthService,  public dialog: MatDialog){
    this.usuarioLogueado = this.authService.obtenerToken()
    this.traerBoletas()

  }

  async traerBoletas(){
    const response = await lastValueFrom(this.boletaService.listarBoletas(this.pageable))
    this.boletas = response.content

    // this.boletas.sort((a:any, b:any) => {

    //   const comparacionFecha = a.boleta.fecha.localeCompare(b.boleta.fecha);
    //   if (comparacionFecha === 0) {
    //     return a.boleta.hora_cita - b.boleta.hora_cita;
    //   }
    //   return comparacionFecha;
    // });
    // this.citas = this.citas.filter((f) => f.cita.estado == 0|| f.cita.estado ==2)
    console.log(response)
    this.dataSource = new MatTableDataSource(this.boletas);
    this.dataSource.paginator = this.paginator;
  }
  estado= ["Pendiente","Terminado","Derivado","Cancelado"]



  infoBoleta(boleta:any){

  }
}
