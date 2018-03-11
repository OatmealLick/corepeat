import { Injectable } from '@angular/core';
import {Observable} from "rxjs/Observable";
import {Corepeat} from "./corepeat";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {ConfigurationService} from "../configuration.service";
import {environment} from "../../environments/environment";

@Injectable()
export class CorepeatService {

  private corepeatsPath = 'corepeats';

  constructor(private configuration: ConfigurationService,
              private http: HttpClient) { }

  getCorepeatDetails(id: number): Observable<Corepeat> {
    const url: string = `${this.configuration.getUrl()}/${this.corepeatsPath}/${id}`;
    console.log(`Fetching from ${url}`);
    return this.http.get<Corepeat>(url);
  }

  createCorepeat(corepeat: Corepeat) {
    const id = environment.loggedUserId;
    const url = `${this.configuration.getUrl()}/${this.corepeatsPath}/${id}`;
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    };
    console.log(`Submitting on ${url}`);
    return this.http.post<Corepeat>(url, corepeat, httpOptions);
  }

  getNearbyCorepeats(): Observable<Corepeat[]> {
    const url = `${this.configuration.getUrl()}/${this.corepeatsPath}`;
    return this.http.get<Corepeat[]>(url);
  }
}
