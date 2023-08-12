import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { RecipeService } from '../recipe.service';

@Component({
  selector: 'app-new-recipe',
  templateUrl: './new-recipe.component.html',
  styleUrls: ['./new-recipe.component.css']
})
export class NewRecipeComponent {
  constructor(private router:Router, private recipeService:RecipeService) {
  }

  onSubmit(form: any) {
    if (form.valid) {
      // Perform logic to create new item using form values
      console.log(form.value);
      // Reset the form after submission
      this.recipeService.createNew(form.value).subscribe(d => {console.log("item created?")});
      form.reset();
      // TODO Or show new recipe?
      this.router.navigate(['/']);
    }
  }
}
