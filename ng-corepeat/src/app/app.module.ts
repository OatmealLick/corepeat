import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';


import {AppComponent} from './app.component';
import {TestComponent} from './test/test.component';
import {TestService} from "./test.service";
import {MessageComponent} from './message/message.component';
import {HttpClientModule} from "@angular/common/http";
import {UserDetailedComponent} from './user/user-detailed/user-detailed.component';
import {UserService} from "./user/user.service";


@NgModule({
  declarations: [
    AppComponent,
    TestComponent,
    MessageComponent,
    UserDetailedComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [TestService, UserService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
