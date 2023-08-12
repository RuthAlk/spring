import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Recipe } from './model/recipe.model';

@Injectable({
  providedIn: 'root'
})
export class RecipeService {
  private apiUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) {

  }

  getItems(): Observable<Recipe[]> {
    return this.http.get<Recipe[]>(`${this.apiUrl}/recipes`).pipe(
      catchError(error => {
        // Handle the error here
        console.error('An error occurred:', error);
        return of([]);
      })
    );
  }

  getItemById(id: number): Observable<Recipe> {
    const url = `${this.apiUrl}/recipes/${id}`;
    return this.http.get<Recipe>(url);
  }

  createNew(value: Recipe): Observable<Recipe> {
    return this.http.post<Recipe>(`${this.apiUrl}/recipes/create`, value);
  }

}
