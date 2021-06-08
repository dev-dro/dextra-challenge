import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Ingredient } from './ingredient.model';

@Injectable({providedIn: 'root'})
export class IngredientService {

  constructor(private http: HttpClient) {}

  getIngredients(): Observable<Ingredient[]> {
    return this.http.get<Ingredient[]>('http://localhost:8080/api/ingredient');
  }
}
