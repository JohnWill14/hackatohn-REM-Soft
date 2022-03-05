import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CompradorComponent } from './pages/comprador/comprador.component';
import { FornecedorComponent } from './pages/fornecedor/fornecedor.component';
import { LoginComponent } from './pages/login/login.component';

const routes: Routes = [
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'comprador',
    component: CompradorComponent
  },
  {
    path: 'fornecedor',
    component: FornecedorComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
