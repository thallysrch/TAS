import { Component, OnInit, ViewChild } from '@angular/core';
import { ConfirmationService, Message, LazyLoadEvent, MessageService } from 'primeng/api';
import { Table } from 'primeng/table';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Disponibilidade } from '../disponibilidade';
import { DisponibilidadeService } from '../disponibilidade.service';


@Component({
  selector: 'app-disponibilidade',
  templateUrl: './disponibilidade-list.component.html',
  styleUrls: ['./disponibilidade-list.component.scss']
})
export class DisponibilidadeListComponent implements OnInit {  

  @ViewChild('dt', { static: false }) dataTable: Table;

  disponibilidades: Disponibilidade[];
  showDialog = false;

  form: FormGroup;

  constructor(
              private fb: FormBuilder,
              private disponibilidadeService: DisponibilidadeService,
              private confirmationService: ConfirmationService,
              private messageService: MessageService) { }

  ngOnInit() {
    this.findAll();

    this.form = this.fb.group(
      {
        id: [null],
        disponivel: [null, Validators.required],
        obs: [null]
      }
    )
  }

  findAll() {
    this.disponibilidadeService.findAll().subscribe( e => this.disponibilidades = e);
  }

  newEntity() {
    this.form.reset();
    this.showDialog = true;
  }

  onSubmit() {
    const disponibilidade = this.form.getRawValue();    
    this.disponibilidadeService.save(disponibilidade).subscribe(e => {
      this.form.reset();
      this.findAll();
      this.dataTable.reset();
      this.showDialog = false;
      this.messageService.add({severity: 'success', summary: 'Confirmado',
                    detail: 'Registro salvo com sucesso!'});
      },
      error => {
        this.messageService.add({severity: 'error', summary: 'Erro',
                    detail: 'Falha ao salvar o registro!'});
    });
  }

  edit(disponibilidade: Disponibilidade) {
    this.form.patchValue(disponibilidade);
    this.showDialog = true;
  }

  cancel() {
    this.showDialog = false;
    this.form.reset();
  }

  delete(disponibilidade: Disponibilidade) {
    this.confirmationService.confirm({
      message: 'Esta ação não poderá ser desfeita!',
      header: 'Deseja remover o registro?',
      acceptLabel: 'Confirmar',
      rejectLabel: 'Cancelar',
      accept: () => {
        this.disponibilidadeService.delete(disponibilidade.id).subscribe(() => {
          this.findAll();
          this.messageService.add({severity: 'success', summary: 'Confirmado',
                    detail: 'Registro removido com sucesso!'});
        }, error => {
          this.messageService.add({severity: 'error', summary: 'Erro',
                    detail: 'Falha ao remover o registro!'});
        });
      }
    });
  }  
}
