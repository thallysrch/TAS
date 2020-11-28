import { Component, OnInit, ViewChild } from '@angular/core';
import { ConfirmationService, Message, LazyLoadEvent, MessageService } from 'primeng/api';
import { Table } from 'primeng/table';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Multa } from '../multa';
import { MultaService } from '../multa.service';


@Component({
  selector: 'app-multa',
  templateUrl: './multa-list.component.html',
  styleUrls: ['./multa-list.component.scss']
})
export class MultaListComponent implements OnInit {  

  @ViewChild('dt', { static: false }) dataTable: Table;

  multas: Multa[];
  showDialog = false;

  form: FormGroup;

  constructor(
              private fb: FormBuilder,
              private multaService: MultaService,
              private confirmationService: ConfirmationService,
              private messageService: MessageService) { }

  ngOnInit() {
    this.findAll();

    this.form = this.fb.group(
      {
        id: [null],
        cod_multa: [null, Validators.required],
        nro_infracao: [null, Validators.required],
        placa: [null, Validators.required],
        id_motorista: [null, Validators.required],
        valor: [null, Validators.required],
        data_multa: [null, Validators.required],
        hora_multa: [null, Validators.required],
        local_multa: [null, Validators.required]
      }
    )
  }

  findAll() {
    this.multaService.findAll().subscribe( e => this.multas = e);
  }

  newEntity() {
    this.form.reset();
    this.showDialog = true;
  }

  onSubmit() {
    const multa = this.form.getRawValue();    
    this.multaService.save(multa).subscribe(e => {
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

  edit(multa: Multa) {
    this.form.patchValue(multa);
    this.showDialog = true;
  }

  cancel() {
    this.showDialog = false;
    this.form.reset();
  }

  delete(multa: Multa) {
    this.confirmationService.confirm({
      message: 'Esta ação não poderá ser desfeita!',
      header: 'Deseja remover o registro?',
      acceptLabel: 'Confirmar',
      rejectLabel: 'Cancelar',
      accept: () => {
        this.multaService.delete(multa.id).subscribe(() => {
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
