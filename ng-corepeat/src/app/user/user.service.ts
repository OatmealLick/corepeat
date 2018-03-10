import {Injectable} from '@angular/core';
import {Observable} from "rxjs/Observable";
import {HttpClient} from "@angular/common/http";
import {ConfigurationService} from "../configuration.service";
import {User} from "./user";

@Injectable()
export class UserService {

  private userPath: string = "users";

  constructor(private configuration: ConfigurationService,
              private http: HttpClient) {
  }

  getUser(id: number): Observable<User> {
    const url = `${this.configuration.getUrl()}/${this.userPath}/${id}`;
    return this.http.get<User>(url);
  }

  createUser(user: User): {

  }
}
