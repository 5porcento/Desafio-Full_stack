import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import {HeroiRequest, HeroiResponse, HeroiService, Superpoder} from '../../service/heroi.service';
import {FormsModule} from '@angular/forms';


@Component({
  selector: 'app-heroi-list',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule 
  ],
  templateUrl: './heroi-list.html',
  styleUrls: ['./heroi-list.css']
})
export class HeroiListComponent implements OnInit {
  herois: HeroiResponse[] = [];
  errorMessage: string | null = null;
  isLoading: boolean = false;
  selectedHeroi: HeroiResponse | null = null; 

  
  newHeroi: HeroiRequest = {
    nome: '',
    nomeHeroi: '',
    superpoderesid: [],
    dataNascimento: '',
    altura: 0,
    peso: 0
  };
  superpoderesInput: string = ''; 

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
        if (error.status === 404 && typeof error.error === 'string') {
          this.errorMessage = error.error;
        } else {
          this.errorMessage = 'Ocorreu um erro ao buscar os super-heróis. Tente novamente mais tarde.';
        }
        this.herois = [];
        this.isLoading = false;
      }
    });
  }

  
  buscarHeroiPorId(id: number): void {
    this.isLoading = true;
    this.errorMessage = null;
    this.selectedHeroi = null; 

    this.heroiService.getHeroiById(id).subscribe({
      next: (heroi) => {
        this.selectedHeroi = heroi;
        this.isLoading = false;
        console.log('Herói encontrado:', heroi);
      },
      error: (error) => {
        console.error(`Erro ao buscar herói com ID ${id}:`, error);
        this.errorMessage = error.status === 404 ? 'Herói não encontrado.' : 'Erro ao buscar herói.';
        this.isLoading = false;
      }
    });
  }

  
  editarHeroi(heroi: HeroiResponse): void {
    
    this.selectedHeroi = { ...heroi };
    this.newHeroi = {
      id: heroi.id,
      nome: heroi.nome,
      nomeHeroi: heroi.nomeHeroi,
      dataNascimento: heroi.dataNascimento,
      altura: heroi.altura,
      peso: heroi.peso,
      superpoderesid: heroi.superpoderes.map(sp => sp.id)
    };
    this.superpoderesInput = heroi.superpoderes.map(sp => sp.id).join(',');
  }

  salvarEdicaoHeroi(): void {
    if (!this.newHeroi.id) {
      this.errorMessage = 'ID do herói para atualização não encontrado.';
      return;
    }

    this.isLoading = true;
    this.errorMessage = null;

  
    this.newHeroi.superpoderesid = this.superpoderesInput
      .split(',')
      .map(id => parseInt(id.trim(), 10))
      .filter(id => !isNaN(id));

    this.heroiService.atualizarHeroi(this.newHeroi.id, this.newHeroi).subscribe({
      next: () => {
        console.log('Herói atualizado com sucesso!');
        this.carregarHerois(); // Recarrega a lista
        this.resetNewHeroiForm(); // Limpa o formulário
        this.selectedHeroi = null; // Limpa a seleção
        this.isLoading = false;
      },
      error: (error) => {
        console.error('Erro ao atualizar herói:', error);
        this.errorMessage = 'Erro ao atualizar herói.';
        this.isLoading = false;
      }
    });
  }

  // Deletar Herói
  deletarHeroi(id: number): void {
    if (confirm('Tem certeza que deseja deletar este herói?')) {
      this.isLoading = true;
      this.errorMessage = null;

      this.heroiService.deletarHeroi(id).subscribe({
        next: () => {
          console.log(`Herói com ID ${id} deletado.`);
          this.carregarHerois(); 
          this.isLoading = false;
        },
        error: (error) => {
          console.error(`Erro ao deletar herói com ID ${id}:`, error);
          this.errorMessage = `Erro ao deletar herói. ${error.status === 400 ? 'Herói não encontrado.' : ''}`;
          this.isLoading = false;
        }
      });
    }
  }

  resetNewHeroiForm(): void {
    this.newHeroi = {
      nome: '',
      nomeHeroi: '',
      superpoderesid: [],
      dataNascimento: '',
      altura: 0,
      peso: 0
    };
    this.superpoderesInput = '';
  }

  getSuperpoderesDisplay(superpoderes: Superpoder[]): string {
    return superpoderes.map(sp => `${sp.superpoder} (ID: ${sp.id})`).join(', ');
  }
}
