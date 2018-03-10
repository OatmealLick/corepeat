import {Injectable} from '@angular/core';
import {Observable} from "rxjs/Observable";
import {HttpClient} from "@angular/common/http";
import {ConfigurationService} from "../configuration.service";
import {User} from "./user";
import {Corepeat} from "../corepeat/corepeat";

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

  createUser(user: User) {
    const url = `${this.configuration.getUrl()}/${this.userPath}`;
    this.http.post(url, user);
  }

  removeUserFromCorepeat(userId: number, corepeatId: number) {
    const url = `${this.configuration.getUrl()}/${this.userPath}/${userId}/corepeats/${corepeatId}`;
    this.http.delete(url);
  }

  addUserToCorepeat(userId: number, corepeatId: number) {
    const url = `${this.configuration.getUrl()}/${this.userPath}/${userId}/corepeats/${corepeatId}`;
    this.http.put(url, null);
  }

  getCorepeatsOfUser(userId: number) {
    const url = `${this.configuration.getUrl()}/${this.userPath}/${userId}`;
    return this.http.get<Corepeat[]>(url);
  }
}
