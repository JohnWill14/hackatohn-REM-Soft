import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CadastroComponent } from './pages/cadastro/cadastro.component';
import { CompradorComponent } from './pages/comprador/comprador.component';
import { FornecedorComponent } from './pages/fornecedor/fornecedor.component';
import { LoginComponent } from './pages/login/login.component';
import { NovaCotacaoComponent } from './pages/nova-cotacao/nova-cotacao.component';
import { RespostasFornecedoresComponent } from './pages/respostas-fornecedores/respostas-fornecedores.component';

const routes: Routes = [
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'cadastro',
    component: CadastroComponent
  },
  {
    path: 'comprador',
    component: CompradorComponent
  },
  {
    path: 'fornecedor',
    component: FornecedorComponent
  },
  {
    path: 'comprador/nova-cotacao',
    component: NovaCotacaoComponent
  },
  {
    path: 'comprador/respostas-fornecedores',
    component: RespostasFornecedoresComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
