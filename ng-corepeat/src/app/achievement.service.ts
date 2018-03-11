import { Injectable } from '@angular/core';
import {ConfigurationService} from "./configuration.service";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {Achievements} from "./achievements";

@Injectable()
export class AchievementService {

  achievementsUrl: string = 'achievements';

  constructor(private configuration: ConfigurationService,
              private http: HttpClient) {
  }

  getAchievementsForUser(id: number): Observable<Achievements> {
    const url: string = `${this.configuration.getUrl()}/${this.achievementsUrl}/${id}`;
    return this.http.get<Achievements>(url);
  }

}
