import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { ItemOrder } from '../customize/item-order.model';
import { ItemOrderService } from '../customize/item-order.service';

@Component({
  selector: 'app-confirm-order',
  templateUrl: './confirm-order.component.html',
  styleUrls: ['./confirm-order.component.css']
})
export class ConfirmOrderComponent implements OnInit {

  private _itemOrder: ItemOrder = new ItemOrder();

  get itemOrder(): ItemOrder {
    return this._itemOrder;
  }

  @Input()
  set itemOrder(itemOrder: ItemOrder) {
    itemOrder.ingredients.forEach(item => item.id = null);
    this.itemOrderService.calculatePrice(itemOrder)
      .subscribe(result => this._itemOrder = result);
  }

  constructor(
    private itemOrderService: ItemOrderService,
    private router: Router,
    private activeModal: NgbActiveModal,
  ) { }

  ngOnInit(): void {
  }

  onOrder() {
    this.itemOrderService.save(this._itemOrder).subscribe(itemOrder => {
      this.activeModal.close(itemOrder);
    });
  }

  close() {
    this.activeModal.dismiss();
  }
}
