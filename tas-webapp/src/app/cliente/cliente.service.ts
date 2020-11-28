import { Injectable } from '@angular/core';
import { CrudService } from '../generic/crud.service';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Cliente } from './cliente';

@Injectable({
  providedIn: 'root'
})
export class ClienteService extends CrudService<Cliente, number> {

  constructor(http: HttpClient) {
    super(environment.api + '/clientes', http);
  }
}
