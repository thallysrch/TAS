import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { MultaListComponent } from './multa/multa-list/multa-list.component';
import { MotoristaListComponent } from './motorista/motorista-list/motorista-list.component';
import { SolicitacaoListComponent } from './solicitacao/solicitacao-list/solicitacao-list.component';
import { UsuarioListComponent } from './usuario/usuario-list/usuario-list.component';
import { VeiculosListComponent } from './veiculos/veiculos-list/veiculos-list.component';
import { ClienteListComponent } from './cliente/cliente-list/cliente-list.component';
import { DisponibilidadeListComponent } from './disponibilidade/disponibilidade-list/disponibilidade-list.component';
import { AbastecimentoListComponent } from './abastecimento/abastecimento-list/abastecimento-list.component';

const routes: Routes = [{
  path: '', children: [
      { path: 'home', component: HomeComponent },
      { path: '', redirectTo: 'home', pathMatch: 'full' },
      { path: 'abastecimento', component: AbastecimentoListComponent },
      { path: 'multa', component: MultaListComponent },
      { path: 'motorista', component: MotoristaListComponent },
      { path: 'solicitacao', component: SolicitacaoListComponent },
      { path: 'usuario', component: UsuarioListComponent },
      { path: 'veiculos', component: VeiculosListComponent },
      { path: 'cliente', component: ClienteListComponent },
      { path: 'disponibilidade', component: DisponibilidadeListComponent }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
