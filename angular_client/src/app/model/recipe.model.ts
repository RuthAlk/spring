export class Recipe {
  addIngredient(ingredientName: string ) {
    // TODO try parse amount/unit etc
    this.ingredients.push(new Ingredient(ingredientName))

  }
  id: number | undefined;
  name: string| undefined;
  ingredients: Ingredient[] = []
}

export class Ingredient {
  constructor(public name:string) {

  }
  id: number | undefined;
  amount: string | undefined;
  unit: string | undefined;
}
