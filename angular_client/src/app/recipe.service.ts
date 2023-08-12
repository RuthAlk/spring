import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { catchError } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class RecipeService {
  private apiUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) {

  }

  getItems(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/recipes`).pipe(
      catchError(error => {
        // Handle the error here
        console.error('An error occurred:', error);
        return of([]);
      })
    );
  }

  getItemById(id: number): Observable<any> {
    const url = `${this.apiUrl}/recipes/${id}`;
    return this.http.get(url);
  }

  createNew(value: any): Observable<Object> {
    return this.http.post(`${this.apiUrl}/recipes/create`, value);
  }

}
