import { NgModule } from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {UserDetailedComponent} from "./user/user-detailed/user-detailed.component";
import {CorepeatDetailedComponent} from "./corepeat/corepeat-detailed/corepeat-detailed.component";

const routes: Routes = [
  {path: 'users/:id', component: UserDetailedComponent},
  {path: 'corepeats/:id', component: CorepeatDetailedComponent}
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ],
  declarations: []
})
export class AppRoutingModule { }
