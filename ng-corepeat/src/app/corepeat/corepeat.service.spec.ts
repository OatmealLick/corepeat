import { TestBed, inject } from '@angular/core/testing';

import { CorepeatService } from './corepeat.service';

describe('CorepeatService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [CorepeatService]
    });
  });

  it('should be created', inject([CorepeatService], (service: CorepeatService) => {
    expect(service).toBeTruthy();
  }));
});
