import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ConfirmOrderComponent } from '../confirm-order/confirm-order.component';
import { Ingredient } from '../ingredient/ingredient.model';
import { IngredientService } from '../ingredient/ingredient.service';
import { ItemOrder } from './item-order.model';

@Component({
  selector: 'app-customize',
  templateUrl: './customize.component.html',
  styleUrls: ['./customize.component.css']
})
export class CustomizeComponent implements OnInit {

  ingredients: Ingredient[] = [];

  constructor(
    private ingredientService: IngredientService,
    private modalService: NgbModal,
  ) { }

  ngOnInit(): void {
    this.ingredientService.getIngredients()
      .subscribe(ingredients => {
        this.ingredients = ingredients;
        this.ingredients.forEach(item => item.quantity = 0);
      });
  }

  onOrder() {
    const modalRef = this.modalService.open(ConfirmOrderComponent);

    const itemOrder = new ItemOrder();
    itemOrder.ingredients = this.ingredients.filter(ingredient => ingredient.quantity > 0);
    modalRef.componentInstance.itemOrder = itemOrder;
  }
}
