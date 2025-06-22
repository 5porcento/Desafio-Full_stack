import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


export interface Superpoder {
  id: number;
  superpoder: string;
  descricao: string;
}

export interface HeroiRequest {
  id?: number; 
  nome: string;
  nomeHeroi: string;
  superpoderesid: number[]; 
  dataNascimento: string; 
  altura: number;
  peso: number;
}


export interface HeroiResponse {
  id: number;
  nome: string;
  nomeHeroi: string;
  dataNascimento: string;
  altura: number;
  peso: number;
  superpoderes: Superpoder[];
}


@Injectable({
  providedIn: 'root'
})
export class HeroiService {

  private apiUrl = 'http://localhost:8080/heroi'; // **Verifique se esta é a URL base correta da sua API**

  constructor(private http: HttpClient) { }


  getHerois(): Observable<HeroiResponse[]> {
    return this.http.get<HeroiResponse[]>(this.apiUrl);
  }

  
  getHeroiById(id: number): Observable<HeroiResponse> {
    return this.http.get<HeroiResponse>(`${this.apiUrl}/pegar/${id}`);
  }


  criarHeroi(heroi: HeroiRequest): Observable<HeroiResponse> {
    return this.http.post<HeroiResponse>(this.apiUrl, heroi);
  }


  atualizarHeroi(id: number, heroi: HeroiRequest): Observable<any> { // Ou Observable<void> se não houver corpo
    return this.http.put<any>(`${this.apiUrl}/${id}`, heroi);
  }

  
  deletarHeroi(id: number): Observable<any> { // Ou Observable<void>
    return this.http.delete<any>(`${this.apiUrl}/${id}`);
  }
}
