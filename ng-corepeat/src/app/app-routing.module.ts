import { NgModule } from '@angular/core';
import {RouterModule, Routes} from "@angular/router";

const routes: Routes = [
  {path: 'users/:id', component: User}
];

@NgModule({
  exports: [
    RouterModule
  ],
  declarations: []
})
export class AppRoutingModule { }
