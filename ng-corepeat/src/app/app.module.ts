import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';


import {AppComponent} from './app.component';
import {HttpClientModule} from "@angular/common/http";
import {UserDetailedComponent} from './user/user-detailed/user-detailed.component';
import {UserService} from "./user/user.service";
import {CorepeatDetailedComponent} from './corepeat/corepeat-detailed/corepeat-detailed.component';
import {AppRoutingModule} from './app-routing.module';
import {CorepeatService} from "./corepeat/corepeat.service";
import {ConfigurationService} from "./configuration.service";
import { NearbyCorepeatsComponent } from './views/nearby-corepeats/nearby-corepeats.component';
import { DashboardComponent } from './views/dashboard/dashboard.component';
import { CorepeatListComponent } from './corepeat/corepeat-list/corepeat-list.component';
import {AuthService} from "./auth.service";
import { ContactComponent } from './views/contact/contact.component';
import { CorepeatSummaryComponent } from './corepeat/corepeat-summary/corepeat-summary.component';


@NgModule({
  declarations: [
    AppComponent,
    UserDetailedComponent,
    CorepeatDetailedComponent,
    NearbyCorepeatsComponent,
    DashboardComponent,
    CorepeatListComponent,
    ContactComponent,
    CorepeatSummaryComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [
    CorepeatService,
    UserService,
    ConfigurationService,
    AuthService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
