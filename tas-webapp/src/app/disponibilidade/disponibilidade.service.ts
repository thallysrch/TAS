import { Injectable } from '@angular/core';
import { CrudService } from '../generic/crud.service';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Disponibilidade } from './disponibilidade';

@Injectable({
  providedIn: 'root'
})
export class DisponibilidadeService extends CrudService<Disponibilidade, number> {

  constructor(http: HttpClient) {
    super(environment.api + '/disponibilidade', http);
  }
}
