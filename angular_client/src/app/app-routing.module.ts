import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';


import { AboutComponentComponent } from './about-component/about-component.component';
import { NewRecipeComponent } from './new-recipe/new-recipe.component';
import { RecipeDetailComponent } from './recipe-detail/recipe-detail.component';
import { RecipesComponent } from './recipes/recipes.component';

const routes: Routes = [
  { path: '', component: RecipesComponent },
  { path: 'recipe/:id', component: RecipeDetailComponent },
  { path: 'new_recipe', component: NewRecipeComponent},
  { path: 'about', component: AboutComponentComponent}
];

@NgModule({
  imports: [CommonModule, RouterModule.forRoot(routes)],
  exports: [RouterModule]
})



export class AppRoutingModule { }
