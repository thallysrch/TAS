import { Component, OnInit, ViewChild } from '@angular/core';
import { ConfirmationService, Message, LazyLoadEvent, MessageService } from 'primeng/api';
import { Table } from 'primeng/table';

import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Abastecimento } from '../abastecimento';
import { AbastecimentoService } from '../abastecimento.service';


@Component({
  selector: 'app-abastecimento',
  templateUrl: './abastecimento-list.component.html',
  styleUrls: ['./abastecimento-list.component.scss']
})
export class AbastecimentoListComponent implements OnInit {  

  @ViewChild('dt', { static: false }) dataTable: Table;

  abastecimentos: Abastecimento[];
  showDialog = false;

  form: FormGroup;

  constructor(
              private fb: FormBuilder,
              private abastecimentoService: AbastecimentoService,
              private confirmationService: ConfirmationService,
              private messageService: MessageService) { }

  ngOnInit() {
    this.findAll();

    this.form = this.fb.group(
      {
        id: [null],
        nota_fiscal: [null, Validators.required],
        litros: [null, Validators.required],
        odometro: [null, Validators.required],
        valor_litros: [null, Validators.required],
        nome_posto: [null, Validators.required],
        placa: [null, Validators.required]
      }
    )
  }

  findAll() {
    this.abastecimentoService.findAll().subscribe( e => this.abastecimentos = e);
  }

  newEntity() {
    this.form.reset();
    this.showDialog = true;
  }

  onSubmit() {
    const abastecimento = this.form.getRawValue();    
    this.abastecimentoService.save(abastecimento).subscribe(e => {
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

  edit(abastecimento: Abastecimento) {
    this.form.patchValue(abastecimento);
    this.showDialog = true;
  }

  cancel() {
    this.showDialog = false;
    this.form.reset();
  }

  delete(abastecimento: Abastecimento) {
    this.confirmationService.confirm({
      message: 'Esta ação não poderá ser desfeita!',
      header: 'Deseja remover o registro?',
      acceptLabel: 'Confirmar',
      rejectLabel: 'Cancelar',
      accept: () => {
        this.abastecimentoService.delete(abastecimento.id).subscribe(() => {
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
