import { Component } from '@angular/core';
import { ColaboradorService } from '../../services/colaborador.service';

@Component({
  selector: 'app-calculador-individual',
  templateUrl: './calculador-individual.component.html',
  styleUrls: ['./calculador-individual.component.css']
})
export class CalculadorIndividualComponent {
  codigoModular: string = '';
  resultados: any;
  mensajeError: string = '';

  constructor(private colaboradorService: ColaboradorService) {}

  buscar() {
    this.colaboradorService.buscarPorCodigoModular(this.codigoModular).subscribe(
      (data) => {
        if (data.length > 0) {
          this.resultados = data;
          this.mensajeError = '';
        } else {
          this.mensajeError = 'No se encontraron datos para este código modular.';
          this.resultados = null;
        }
      },
      (error) => {
        console.error('Error al buscar el colaborador:', error);
        this.mensajeError = 'Ocurrió un error al procesar la solicitud.';
      }
    );
  }
}
