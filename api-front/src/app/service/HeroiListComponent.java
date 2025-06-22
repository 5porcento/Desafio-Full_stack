import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common'; // Necessário para *ngIf e *ngFor
import { HeroiService, Heroi } from '../heroi.service'; // Importe seu serviço e interface

@Component({
  selector: 'app-heroi-list', // Seletor que você usará no HTML principal
  standalone: true, // Componente standalone
  imports: [
    CommonModule // Importa CommonModule para usar diretivas como *ngIf e *ngFor
  ],
  templateUrl: './heroi-list.component.html',
  styleUrls: ['./heroi-list.component.css']
})
export class HeroiListComponent implements OnInit {
  herois: Heroi[] = [];
  errorMessage: string | null = null;
  isLoading: boolean = false;

  constructor(private heroiService: HeroiService) { }

  ngOnInit(): void {
    this.carregarHerois();
  }

  carregarHerois(): void {
    this.isLoading = true;
    this.errorMessage = null;

    this.heroiService.getHerois().subscribe({
      next: (data) => {
        this.herois = data;
        this.isLoading = false;
      },
      error: (error) => {
        console.error('Erro ao carregar heróis:', error);
        // Sua API retorna uma string pura em caso de 404 (Nenhum super-herói cadastrado)
        if (error.status === 404 && typeof error.error === 'string') {
          this.errorMessage = error.error; // Captura a mensagem do backend
        } else {
          this.errorMessage = 'Ocorreu um erro ao buscar os super-heróis. Tente novamente mais tarde.';
        }
        this.herois = []; // Limpa a lista de heróis em caso de erro
        this.isLoading = false;
      }
    });
  }
}
