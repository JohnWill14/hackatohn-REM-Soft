import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './core/components/navbar/navbar.component';
import { LoginComponent } from './pages/login/login.component';
import { FornecedorComponent } from './pages/fornecedor/fornecedor.component';
import { CompradorComponent } from './pages/comprador/comprador.component';
import { CadastroComponent } from './pages/cadastro/cadastro.component';
import { NovaCotacaoComponent } from './pages/nova-cotacao/nova-cotacao.component';
import { RespostasFornecedoresComponent } from './pages/respostas-fornecedores/respostas-fornecedores.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    LoginComponent,
    FornecedorComponent,
    CompradorComponent,
    CadastroComponent,
    NovaCotacaoComponent,
    RespostasFornecedoresComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
