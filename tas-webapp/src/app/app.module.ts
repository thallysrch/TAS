import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MenuComponent } from './menu/menu.component';
import { HomeComponent } from './home/home.component';
import { HttpClientModule } from '@angular/common/http';

import {TableModule} from 'primeng/table';
import {DialogModule} from 'primeng/dialog';
import {ToastModule} from 'primeng/toast';
import {TabViewModule} from 'primeng/tabview';
import {CalendarModule} from 'primeng/calendar';
import {DropdownModule} from 'primeng/dropdown';
import {AutoCompleteModule} from 'primeng/autocomplete';
import {PanelModule} from 'primeng/panel';
import {InputNumberModule} from 'primeng/inputnumber';
import {CheckboxModule} from 'primeng/checkbox';

import {ConfirmDialogModule} from 'primeng/confirmdialog';
import {ConfirmationService, MessageService} from 'primeng/api';

import { DisponibilidadeListComponent } from './disponibilidade/disponibilidade-list/disponibilidade-list.component';
import { MotoristaListComponent } from './motorista/motorista-list/motorista-list.component';
import { MultaListComponent } from './multa/multa-list/multa-list.component';
import { SolicitacaoListComponent } from './solicitacao/solicitacao-list/solicitacao-list.component';
import { UsuarioListComponent } from './usuario/usuario-list/usuario-list.component';
import { VeiculosListComponent } from './veiculos/veiculos-list/veiculos-list.component';
import { AbastecimentoListComponent } from './abastecimento/abastecimento-list/abastecimento-list.component';
import { ClienteListComponent } from './cliente/cliente-list/cliente-list.component';


@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    HomeComponent,
    AbastecimentoListComponent,
    DisponibilidadeListComponent,
    MotoristaListComponent,
    MultaListComponent,
    SolicitacaoListComponent,
    UsuarioListComponent,
    VeiculosListComponent,
    ClienteListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    ToastModule,
    DialogModule,
    ConfirmDialogModule,
    TableModule,
    TabViewModule,
    CalendarModule,
    DropdownModule,
    AutoCompleteModule,
    PanelModule,
    InputNumberModule,
    ReactiveFormsModule,
    CheckboxModule
  ],
  providers: [
    ConfirmationService,
    MessageService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
