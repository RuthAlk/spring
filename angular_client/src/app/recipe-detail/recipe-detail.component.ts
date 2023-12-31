import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { RecipeService } from '../recipe.service';
import { Recipe } from '../model/recipe.model';

@Component({
  selector: 'app-recipe-detail',
  templateUrl: './recipe-detail.component.html',
  styleUrls: ['./recipe-detail.component.css']
})

export class RecipeDetailComponent implements OnInit {
  constructor(private route: ActivatedRoute, private recipeService: RecipeService) { }
  item: Recipe | undefined;

  ngOnInit() {
    this.route.params.subscribe(params => {
      const itemId = params['id'];
      console.log("Got item nr " + itemId)
      this.recipeService.getItemById(itemId).subscribe(data => {
        this.item = data;
      });
    });
  }
}
