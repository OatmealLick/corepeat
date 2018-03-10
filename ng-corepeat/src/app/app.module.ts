import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';


import {AppComponent} from './app.component';
import {TestComponent} from './test/test.component';
import {TestService} from "./test.service";
import { MessageComponent } from './message/message.component';


@NgModule({
  declarations: [
    AppComponent,
    TestComponent,
    MessageComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [TestService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
