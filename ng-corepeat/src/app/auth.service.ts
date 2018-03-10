import { Injectable } from '@angular/core';

@Injectable()
export class AuthService {

  constructor() { }

  getLoggedUserId(): number {
    return 1;
  }
}
