import { Injectable } from '@angular/core';
import { CrudService } from '../generic/crud.service';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Motorista } from './motorista';

@Injectable({
  providedIn: 'root'
})
export class MotoristaService extends CrudService<Motorista, number> {

  constructor(http: HttpClient) {
    super(environment.api + '/motorista', http);
  }
}
