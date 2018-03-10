import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';


import {AppComponent} from './app.component';
import {TestComponent} from './test/test.component';
import {TestService} from "./test.service";
import {MessageComponent} from './message/message.component';
import { DumbComponent } from './dumb/dumb.component';
import {HttpClientModule} from "@angular/common/http";


@NgModule({
  declarations: [
    AppComponent,
    TestComponent,
    MessageComponent,
    DumbComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [TestService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
