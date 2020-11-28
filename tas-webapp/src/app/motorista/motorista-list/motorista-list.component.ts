import { Component, OnInit, ViewChild } from '@angular/core';
import { ConfirmationService, Message, LazyLoadEvent, MessageService } from 'primeng/api';
import { Table } from 'primeng/table';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Motorista } from '../motorista';
import { MotoristaService } from '../motorista.service';


@Component({
  selector: 'app-motorista',
  templateUrl: './motorista-list.component.html',
  styleUrls: ['./motorista-list.component.scss']
})
export class MotoristaListComponent implements OnInit {  

  @ViewChild('dt', { static: false }) dataTable: Table;

  motoristas: Motorista[];
  showDialog = false;

  form: FormGroup;

  constructor(
              private fb: FormBuilder,
              private motoristaService: MotoristaService,
              private confirmationService: ConfirmationService,
              private messageService: MessageService) { }

  ngOnInit() {
    this.findAll();

    this.form = this.fb.group(
      {
        id: [null],
        nome: [null, Validators.required],
        cpf: [null, Validators.required],
        cnh: [null, Validators.required],
        dt_adimissao: [null, Validators.required]
      }
    )
  }

  findAll() {
    this.motoristaService.findAll().subscribe( e => this.motoristas = e);
  }

  newEntity() {
    this.form.reset();
    this.showDialog = true;
  }

  onSubmit() {
    const motorista = this.form.getRawValue();    
    this.motoristaService.save(motorista).subscribe(e => {
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

  edit(motorista: Motorista) {
    this.form.patchValue(motorista);
    this.showDialog = true;
  }

  cancel() {
    this.showDialog = false;
    this.form.reset();
  }

  delete(motorista: Motorista) {
    this.confirmationService.confirm({
      message: 'Esta ação não poderá ser desfeita!',
      header: 'Deseja remover o registro?',
      acceptLabel: 'Confirmar',
      rejectLabel: 'Cancelar',
      accept: () => {
        this.motoristaService.delete(motorista.id).subscribe(() => {
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
