import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {HeroiListComponent} from './component/heroi-list/heroi-list';

@Component({
  selector: 'app-root',
  standalone: true ,
  imports: [HeroiListComponent,RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.css'
})
export class App {
  protected title = 'api-front';
}
