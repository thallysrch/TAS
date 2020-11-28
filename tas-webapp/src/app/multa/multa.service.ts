import { Injectable } from '@angular/core';
import { CrudService } from '../generic/crud.service';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Multa } from './multa';

@Injectable({
  providedIn: 'root'
})
export class MultaService extends CrudService<Multa, number> {

  constructor(http: HttpClient) {
    super(environment.api + '/multas', http);
  }
}
