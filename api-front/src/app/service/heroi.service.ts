import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

// Interface para um Superpoder, como recebido do backend
export interface Superpoder {
  id: number;
  superpoder: string;
  descricao: string;
}

// Interface para o que o backend ESPERA ao CADASTRAR/ATUALIZAR um herói (HeroiRequest DTO)
// Note que 'id' é opcional aqui, pois o backend o gera na criação.
export interface HeroiRequest {
  id?: number; // Opcional para criação, pode ser exigido para PUT
  nome: string;
  nomeHeroi: string;
  superpoderesid: number[]; // Backend espera uma lista de IDs de superpoderes aqui
  dataNascimento: string; // LocalDate no Spring é uma string (ISO 8601)
  altura: number;
  peso: number;
}

// Interface para o que o backend RETORNA ao buscar/salvar/atualizar um herói (HeroiResponse DTO)
export interface HeroiResponse {
  id: number;
  nome: string;
  nomeHeroi: string;
  dataNascimento: string;
  altura: number;
  peso: number;
  superpoderes: Superpoder[]; // Backend retorna objetos Superpoder completos aqui
}


@Injectable({
  providedIn: 'root'
})
export class HeroiService {

  private apiUrl = 'http://localhost:8080/heroi'; // **Verifique se esta é a URL base correta da sua API**

  constructor(private http: HttpClient) { }

  // --- Operações GET ---

  /**
   * Obtém a lista de todos os heróis da API.
   * Corresponde a sua @GetMapping findAll()
   */
  getHerois(): Observable<HeroiResponse[]> {
    return this.http.get<HeroiResponse[]>(this.apiUrl);
  }

  /**
   * Busca um herói por ID.
   * Corresponde a sua @GetMapping("/pegar/{id}")
   */
  getHeroiById(id: number): Observable<HeroiResponse> {
    return this.http.get<HeroiResponse>(`${this.apiUrl}/pegar/${id}`);
  }

  // --- Operações POST ---

  /**
   * Cadastra um novo herói.
   * Corresponde a sua @PostMapping save()
   * Recebe um HeroiRequest e espera um HeroiResponse.
   */
  criarHeroi(heroi: HeroiRequest): Observable<HeroiResponse> {
    return this.http.post<HeroiResponse>(this.apiUrl, heroi);
  }

  // --- Operações PUT ---

  /**
   * Atualiza um herói existente pelo ID.
   * Corresponde a sua @PutMapping("/{id}")
   * Recebe um HeroiRequest e espera um ResponseEntity.
   * Como o seu Spring retorna ResponseEntity<?> no PUT,
   * podemos tipar como `any` ou `Object` ou `void` se você não precisar do corpo da resposta.
   */
  atualizarHeroi(id: number, heroi: HeroiRequest): Observable<any> { // Ou Observable<void> se não houver corpo
    return this.http.put<any>(`${this.apiUrl}/${id}`, heroi);
  }

  // --- Operações DELETE ---

  /**
   * Deleta um herói pelo ID.
   * Corresponde a sua @DeleteMapping("/{id}")
   * Espera um ResponseEntity.
   */
  deletarHeroi(id: number): Observable<any> { // Ou Observable<void>
    return this.http.delete<any>(`${this.apiUrl}/${id}`);
  }
}
