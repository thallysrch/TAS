import { Component, OnInit, ViewChild } from '@angular/core';
import { ConfirmationService, Message, LazyLoadEvent, MessageService } from 'primeng/api';
import { Table } from 'primeng/table';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Usuario } from '../usuario';
import { UsuarioService } from '../usuario.service';


@Component({
  selector: 'app-usuario',
  templateUrl: './usuario-list.component.html',
  styleUrls: ['./usuario-list.component.scss']
})
export class UsuarioListComponent implements OnInit {  

  @ViewChild('dt', { static: false }) dataTable: Table;

  usuarios: Usuario[];
  showDialog = false;

  form: FormGroup;

  constructor(
              private fb: FormBuilder,
              private usuarioService: UsuarioService,
              private confirmationService: ConfirmationService,
              private messageService: MessageService) { }

  ngOnInit() {
    this.findAll();

    this.form = this.fb.group(
      {
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
    this.usuarioService.findAll().subscribe( e => this.usuarios = e);
  }

  newEntity() {
    this.form.reset();
    this.showDialog = true;
  }

  onSubmit() {
    const usuario = this.form.getRawValue();    
    this.usuarioService.save(usuario).subscribe(e => {
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

  edit(usuario: Usuario) {
    this.form.patchValue(usuario);
    this.showDialog = true;
  }

  cancel() {
    this.showDialog = false;
    this.form.reset();
  }

  delete(usuario: Usuario) {
    this.confirmationService.confirm({
      message: 'Esta ação não poderá ser desfeita!',
      header: 'Deseja remover o registro?',
      acceptLabel: 'Confirmar',
      rejectLabel: 'Cancelar',
      accept: () => {
        this.usuarioService.delete(usuario.id).subscribe(() => {
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
