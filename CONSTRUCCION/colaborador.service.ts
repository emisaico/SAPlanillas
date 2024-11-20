import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ColaboradorService {
  private apiUrl = 'http://localhost:3000/api/colaboradores';

  constructor(private http: HttpClient) {}

  // Método para buscar colaborador por código modular
  buscarPorCodigoModular(codigoModular: string): Observable<any> {
    return this.http.get(`${this.apiUrl}/${codigoModular}`);
  }
}
