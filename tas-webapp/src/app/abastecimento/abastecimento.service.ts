import { Injectable } from '@angular/core';
import { CrudService } from '../generic/crud.service';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Abastecimento } from './abastecimento';

@Injectable({
  providedIn: 'root'
})
export class AbastecimentoService extends CrudService<Abastecimento, number> {

  constructor(http: HttpClient) {
    super(environment.api + '/abastecimento', http);
  }
}
