import {Injectable} from '@angular/core';
import {Observable} from "rxjs/Observable";
import {UserDetailedComponent} from "./user-detailed/user-detailed.component";
import {HttpClient} from "@angular/common/http";
import {ConfigurationService} from "../configuration.service";

@Injectable()
export class UserService {

  private userPath: string = "/user";

  constructor(private http: HttpClient,
              private configuration: ConfigurationService) {
  }

  getUser(id: number): Observable<UserDetailedComponent> {
    const url = this.configuration.getUrl() + this.userPath + `${id}`
    return this.http.get<UserDetailedComponent>(url);
  }
}
