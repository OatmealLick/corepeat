import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';


import {AppComponent} from './app.component';
import {TestComponent} from './test/test.component';
import {TestService} from "./test.service";
import {MessageComponent} from './message/message.component';
import {HttpClientModule} from "@angular/common/http";
import { CorepeatDetailedComponent } from './corepeat/corepeat-detailed/corepeat-detailed.component';
import { AppRoutingModule } from './/app-routing.module';


@NgModule({
  declarations: [
    AppComponent,
    TestComponent,
    MessageComponent,
    CorepeatDetailedComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [TestService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
