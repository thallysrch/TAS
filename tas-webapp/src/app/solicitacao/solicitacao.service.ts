import { Injectable } from '@angular/core';
import { CrudService } from '../generic/crud.service';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Solicitacao } from './solicitacao';

@Injectable({
  providedIn: 'root'
})
export class SolicitacaoService extends CrudService<Solicitacao, number> {

  constructor(http: HttpClient) {
    super(environment.api + '/solicitacao', http);
  }
}
