import { Injectable } from '@angular/core';

@Injectable()
export class ConfigurationService {

  constructor() { }

  getUrl(): string {
    return this.getMockUrl();
  }

  private getAppUrl(): string {
    return "http://localhost:8080";
  }
}
