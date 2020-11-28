import { Component, OnInit, ViewChild } from '@angular/core';
import { ConfirmationService, Message, LazyLoadEvent, MessageService } from 'primeng/api';
import { Table } from 'primeng/table';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Cliente } from '../cliente';
import { ClienteService } from '../cliente.service';


@Component({
  selector: 'app-cliente',
  templateUrl: './cliente-list.component.html',
  styleUrls: ['./cliente-list.component.scss']
})
export class ClienteListComponent implements OnInit {  

  @ViewChild('dt', { static: false }) dataTable: Table;

  clientes: Cliente[];
  showDialog = false;

  form: FormGroup;

  constructor(
              private fb: FormBuilder,
              private clienteService: ClienteService,
              private confirmationService: ConfirmationService,
              private messageService: MessageService) { }

  ngOnInit() {
    this.findAll();

    this.form = this.fb.group(
      {
        id: [null],
        nome: [null, Validators.required],
        email: [null, Validators.required],
        endereco: [null, Validators.required],
        cpf: [null, Validators.required],
        codigo:[null,Validators.required],
        ativo:[null]
      }
    )
  }

  findAll() {
    this.clienteService.findAll().subscribe( e => this.clientes = e);
  }

  newEntity() {
    this.form.reset();
    this.showDialog = true;
  }

  onSubmit() {
    const cliente = this.form.getRawValue();    
    this.clienteService.save(cliente).subscribe(e => {
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

  edit(cliente: Cliente) {
    this.form.patchValue(cliente);
    this.showDialog = true;
  }

  cancel() {
    this.showDialog = false;
    this.form.reset();
  }

  delete(cliente: Cliente) {
    this.confirmationService.confirm({
      message: 'Esta ação não poderá ser desfeita!',
      header: 'Deseja remover o registro?',
      acceptLabel: 'Confirmar',
      rejectLabel: 'Cancelar',
      accept: () => {
        this.clienteService.delete(cliente.id).subscribe(() => {
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
