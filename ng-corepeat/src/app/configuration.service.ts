import { Injectable } from '@angular/core';

@Injectable()
export class ConfigurationService {

  constructor() { }

  getUrl(): string {
    return "http://localhost:8080";
  }
}
