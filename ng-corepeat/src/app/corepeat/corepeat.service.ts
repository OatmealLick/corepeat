import { Injectable } from '@angular/core';
import {Observable} from "rxjs/Observable";
import {Corepeat} from "./corepeat";
import {HttpClient} from "@angular/common/http";
import {ConfigurationService} from "../configuration.service";

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
    this.http.post(`${this.configuration.getUrl()}/${this.corepeatsPath}`, corepeat);
  }

  getNearbyCorepeats(): Observable<Corepeat[]> {
    const url = `${this.configuration.getUrl()}/${this.corepeatsPath}`;
    return this.http.get<Corepeat[]>(url);
  }
}
