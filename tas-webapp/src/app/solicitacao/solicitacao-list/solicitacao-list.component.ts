import { Component, OnInit, ViewChild } from '@angular/core';
import { ConfirmationService, Message, LazyLoadEvent, MessageService } from 'primeng/api';
import { Table } from 'primeng/table';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Solicitacao } from '../solicitacao';
import { SolicitacaoService } from '../solicitacao.service';


@Component({
  selector: 'app-solicitacao',
  templateUrl: './solicitacao-list.component.html',
  styleUrls: ['./solicitacao-list.component.scss']
})
export class SolicitacaoListComponent implements OnInit {  

  @ViewChild('dt', { static: false }) dataTable: Table;

  solicitacaos: Solicitacao[];
  showDialog = false;

  form: FormGroup;

  constructor(
              private fb: FormBuilder,
              private solicitacaoService: SolicitacaoService,
              private confirmationService: ConfirmationService,
              private messageService: MessageService) { }

  ngOnInit() {
    this.findAll();

    this.form = this.fb.group(
      {
        id: [null],
        cod_solicitacao: [null, Validators.required],
        data_solicitacao: [null, Validators.required],
        destino_solicitacao: [null, Validators.required],
        hora_solicitacao: [null, Validators.required],
        cod_cliente: [null, Validators.required],
        km_inicial: [null, Validators.required],
        km_final: [null, Validators.required]
      }
    )
  }

  findAll() {
    this.solicitacaoService.findAll().subscribe( e => this.solicitacaos = e);
  }

  newEntity() {
    this.form.reset();
    this.showDialog = true;
  }

  onSubmit() {
    const solicitacao = this.form.getRawValue();    
    this.solicitacaoService.save(solicitacao).subscribe(e => {
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

  edit(solicitacao: Solicitacao) {
    this.form.patchValue(solicitacao);
    this.showDialog = true;
  }

  cancel() {
    this.showDialog = false;
    this.form.reset();
  }

  delete(solicitacao: Solicitacao) {
    this.confirmationService.confirm({
      message: 'Esta ação não poderá ser desfeita!',
      header: 'Deseja remover o registro?',
      acceptLabel: 'Confirmar',
      rejectLabel: 'Cancelar',
      accept: () => {
        this.solicitacaoService.delete(solicitacao.id).subscribe(() => {
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
