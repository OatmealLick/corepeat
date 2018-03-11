import {NgModule} from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {UserDetailedComponent} from "./user/user-detailed/user-detailed.component";
import {CorepeatDetailedComponent} from "./corepeat/corepeat-detailed/corepeat-detailed.component";
import {NearbyCorepeatsComponent} from "./views/nearby-corepeats/nearby-corepeats.component";
import {DashboardComponent} from "./views/dashboard/dashboard.component";
import {ContactComponent} from "./views/contact/contact.component";
import {CreateCorepeatComponent} from "./views/create-corepeat/create-corepeat.component";

const routes: Routes = [
  {path: 'users/:id', component: UserDetailedComponent},
  {path: 'corepeats/:id', component: CorepeatDetailedComponent},
  {path: 'corepeats', component: NearbyCorepeatsComponent},
  {path: 'create', component: CreateCorepeatComponent},
  {path: 'dashboard', component: DashboardComponent},
  {path: 'contact', component: ContactComponent},
  {path: '**', component: NearbyCorepeatsComponent, pathMatch: 'full'}
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
export class AppRoutingModule {
}
