import { Ingredient } from '../ingredient/ingredient.model';

export class ItemMenu {
  constructor(
    public id?: number,
    public name?: string,
    public ingredients?: Ingredient[],
  ) {}
}
