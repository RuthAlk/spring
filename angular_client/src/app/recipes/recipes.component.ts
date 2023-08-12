import { Component, OnInit } from '@angular/core';
import { RecipeService } from '../recipe.service';

@Component({
  selector: 'app-recipes',
  templateUrl: './recipes.component.html',
  styleUrls: ['./recipes.component.css']
})
export class RecipesComponent implements OnInit {
  items: any[] | undefined;
  constructor(private recipeService: RecipeService) {}

  ngOnInit(): void {
    this.recipeService.getItems().subscribe(data => {
      this.items = data;
    });
  }
}





