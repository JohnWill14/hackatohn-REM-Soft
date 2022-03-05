import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-nova-cotacao',
  templateUrl: './nova-cotacao.component.html',
  styleUrls: ['./nova-cotacao.component.css']
})
export class NovaCotacaoComponent implements OnInit {

  constructor(
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  openRespostasFornecedores(): void {
    this.router.navigate(['comprador/respostas-fornecedores'])
  }

}
