import { Ingredient } from '../ingredient/ingredient.model';

export class ItemOrder {
  constructor(
    public id?: number,
    public ingredients?: Ingredient[],
    public price?: number,
    public name?: string,
  ) {}
}
