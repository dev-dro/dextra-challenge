import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClientsHomeComponent } from './clients-home/clients-home.component';
import { CustomizeComponent } from './customize/customize.component';
import { ItemMenuComponent } from './item-menu/item-menu.component';

const routes: Routes = [
  { path: '', component: ClientsHomeComponent },
  { path: 'customize', component: CustomizeComponent },
  { path: 'menu', component: ItemMenuComponent },
  { path: '**', redirectTo: '', pathMatch: 'full'}
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {
}
