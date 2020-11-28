import { Component, OnInit, ViewChild } from '@angular/core';
import { ConfirmationService, Message, LazyLoadEvent, MessageService } from 'primeng/api';
import { Table } from 'primeng/table';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Veiculos } from '../veiculos';
import { VeiculosService } from '../veiculos.service';


@Component({
  selector: 'app-veiculos',
  templateUrl: './veiculos-list.component.html',
  styleUrls: ['./veiculos-list.component.scss']
})
export class VeiculosListComponent implements OnInit {  

  @ViewChild('dt', { static: false }) dataTable: Table;

  veiculoss: Veiculos[];
  showDialog = false;

  form: FormGroup;

  constructor(
              private fb: FormBuilder,
              private veiculosService: VeiculosService,
              private confirmationService: ConfirmationService,
              private messageService: MessageService) { }

  ngOnInit() {
    this.findAll();

    this.form = this.fb.group(
      {
        id: [null],
        cod_veiculo: [null, Validators.required],
        km_veiculo: [null, Validators.required],
        placa: [null, Validators.required],
        chassi: [null, Validators.required],
        renavam: [null, Validators.required],
        marca: [null, Validators.required]
      }
    )
  }

  findAll() {
    this.veiculosService.findAll().subscribe( e => this.veiculoss = e);
  }

  newEntity() {
    this.form.reset();
    this.showDialog = true;
  }

  onSubmit() {
    const veiculos = this.form.getRawValue();    
    this.veiculosService.save(veiculos).subscribe(e => {
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

  edit(veiculos: Veiculos) {
    this.form.patchValue(veiculos);
    this.showDialog = true;
  }

  cancel() {
    this.showDialog = false;
    this.form.reset();
  }

  delete(veiculos: Veiculos) {
    this.confirmationService.confirm({
      message: 'Esta ação não poderá ser desfeita!',
      header: 'Deseja remover o registro?',
      acceptLabel: 'Confirmar',
      rejectLabel: 'Cancelar',
      accept: () => {
        this.veiculosService.delete(veiculos.id).subscribe(() => {
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
