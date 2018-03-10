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
    return this.http.get<Corepeat>(`${this.configuration.getUrl()}/${this.corepeatsPath}/${id}`);
  }

  createCorepeat(corepeat: Corepeat) {
    this.http.post(`${this.configuration.getUrl()}/${this.corepeatsPath}`, corepeat);
  }

  getNearbyCorepeats(): Observable<Corepeat[]> {
    return this.http.get<Corepeat[]>(`${this.configuration.getUrl()}/${this.corepeatsPath}`);
  }
}
