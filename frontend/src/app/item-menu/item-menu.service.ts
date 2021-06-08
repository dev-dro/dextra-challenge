import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ItemMenu } from './item-menu.model';

@Injectable({ providedIn: 'root' })
export class ItemMenuService {

  constructor(private http: HttpClient) {}

  getMenuItems(): Observable<ItemMenu[]> {
    return this.http.get<ItemMenu[]>('http://localhost:8080/api/item-menu');
  }
}
