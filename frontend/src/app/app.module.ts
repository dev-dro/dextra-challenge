import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { NgbActiveModal, NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { ClientsHomeComponent } from './clients-home/clients-home.component';
import { ConfirmOrderComponent } from './confirm-order/confirm-order.component';
import { CustomizeComponent } from './customize/customize.component';
import { ItemMenuComponent } from './item-menu/item-menu.component';
import { NavItemComponent } from './navbar/nav-item/nav-item.component';
import { NavbarComponent } from './navbar/navbar.component';
import { PageTitleComponent } from './page-title/page-title.component';

@NgModule({
  declarations: [
    AppComponent,
    ClientsHomeComponent,
    ItemMenuComponent,
    CustomizeComponent,
    NavbarComponent,
    NavItemComponent,
    PageTitleComponent,
    ConfirmOrderComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    BrowserAnimationsModule,
    NgbModule,
    FontAwesomeModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
