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
import {HttpClientInMemoryWebApiModule, InMemoryDbService} from "angular-in-memory-web-api";
import {InMemoryDataService} from "./in-memory-data.service";
import { ContentHeaderComponent } from './content-header/content-header.component';
import { NearbyCorepeatComponent } from './nearby-corepeat/nearby-corepeat.component';
import { NearbyCorepeatsComponent } from './nearby-corepeats/nearby-corepeats.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { CorepeatListComponent } from './corepeat/corepeat-list/corepeat-list.component';
import {AuthService} from "./auth.service";


@NgModule({
  declarations: [
    AppComponent,
    UserDetailedComponent,
    CorepeatDetailedComponent,
    NearbyCorepeatsComponent
    CorepeatDetailedComponent,
    DashboardComponent,
    CorepeatListComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    HttpClientInMemoryWebApiModule.forRoot(
      InMemoryDataService, {dataEncapsulation: false}
    )
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
