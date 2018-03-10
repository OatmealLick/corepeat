import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {MessageComponent} from './message/message.component';
import {Observable} from "rxjs/Observable";

@Injectable()
export class TestService {

  private testUrl: string = "http://localhost:8080/test";

  constructor(private http: HttpClient) {
  }

  fetchMessage(): Observable<MessageComponent> {
    return this.http.get<MessageComponent>(this.testUrl);
  }
}
