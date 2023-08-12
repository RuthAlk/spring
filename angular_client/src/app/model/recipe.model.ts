export class Recipe {
  id: number | undefined;
  name: string| undefined;
  ingredients: Ingredient[] = []
}

export class Ingredient {
  id: number | undefined;
  name: string| undefined;
  amount: string | undefined;
  unit: string | undefined;
}
