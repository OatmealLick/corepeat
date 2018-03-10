import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';


import {AppComponent} from './app.component';
import {TestComponent} from './test/test.component';
import {TestService} from "./test.service";
import {MessageComponent} from './message/message.component';
import {HttpClientModule} from "@angular/common/http";
import {UserDetailedComponent} from './user/user-detailed/user-detailed.component';
import {UserService} from "./user/user.service";
import {CorepeatDetailedComponent} from './corepeat/corepeat-detailed/corepeat-detailed.component';
import {AppRoutingModule} from './/app-routing.module';
import {CorepeatService} from "./corepeat/corepeat.service";
import {ConfigurationService} from "./configuration.service";
import {HttpClientInMemoryWebApiModule, InMemoryDbService} from "angular-in-memory-web-api";
import {InMemoryDataService} from "./in-memory-data.service";


@NgModule({
  declarations: [
    AppComponent,
    TestComponent,
    MessageComponent,
    UserDetailedComponent,
    CorepeatDetailedComponent
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
    TestService,
    CorepeatService,
    UserService,
    ConfigurationService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
