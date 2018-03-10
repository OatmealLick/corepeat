import { Injectable } from '@angular/core';
import {Observable} from "rxjs/Observable";
import {Corepeat} from "./corepeat";
import {HttpClient} from "@angular/common/http";

@Injectable()
export class CorepeatService {

  private corepeatsUrl = 'http://localhost:8080/corepeats';

  constructor(private http: HttpClient) { }

  getCorepeatDetails(id: number): Observable<Corepeat> {
    return this.http.get<Corepeat>(`${this.corepeatsUrl}/${id}`);
  }

}
