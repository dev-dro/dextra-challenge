import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ItemOrder } from './item-order.model';

@Injectable({providedIn: 'root'})
export class ItemOrderService {

  constructor(private http: HttpClient) {}

  calculatePrice(itemOrder: ItemOrder) {
    return this.http.post<ItemOrder>('http://localhost:8080/api/order-item/calculate-price', itemOrder);
  }

  save(ItemOrder: ItemOrder) {
    return this.http.post<ItemOrder>('http://localhost:8080/api/order-item', ItemOrder);
  }
}
