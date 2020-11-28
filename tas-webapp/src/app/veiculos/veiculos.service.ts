import { Injectable } from '@angular/core';
import { CrudService } from '../generic/crud.service';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Veiculos } from './veiculos';

@Injectable({
  providedIn: 'root'
})
export class VeiculosService extends CrudService<Veiculos, number> {

  constructor(http: HttpClient) {
    super(environment.api + '/veiculos', http);
  }
}
