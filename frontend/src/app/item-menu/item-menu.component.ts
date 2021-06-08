import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ConfirmOrderComponent } from '../confirm-order/confirm-order.component';
import { ItemOrder } from '../customize/item-order.model';
import { Ingredient } from '../ingredient/ingredient.model';
import { ItemMenu } from './item-menu.model';
import { ItemMenuService } from './item-menu.service';

@Component({
  selector: 'app-menu',
  templateUrl: './item-menu.component.html',
  styleUrls: [ './item-menu.component.css' ]
})
export class ItemMenuComponent implements OnInit {

  menuItems: ItemMenu[] = [];
  showAlert: boolean = false;

  constructor(
    private menuService: ItemMenuService,
    private modalService: NgbModal,
  ) {}

  ngOnInit(): void {
    this.loadMenuItems();
  }

  loadMenuItems() {
    this.menuItems = [];
    this.menuService.getMenuItems()
      .subscribe(menuItems => this.menuItems = menuItems);
  }

  concatIngredients(ingredients: Ingredient[] | undefined): string {
    return ingredients && ingredients.length > 0 ? ingredients
      .map(ingredient => ingredient && ingredient.name)
      .reduce((total, name) => total + ', ' + name) + '.' : '';
  }

  onSelectMenuItem(item: ItemMenu) {
    const modalRef = this.modalService.open(ConfirmOrderComponent);

    const itemOrder = new ItemOrder();
    itemOrder.ingredients = item.ingredients;
    itemOrder.name = item.name;

    modalRef.componentInstance.itemOrder = itemOrder;
    modalRef.result.then(() => {
      this.showAlert = true;
      this.loadMenuItems()
    });
  }
}
