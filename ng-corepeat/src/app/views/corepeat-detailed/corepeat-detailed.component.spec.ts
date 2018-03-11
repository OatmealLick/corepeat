import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CorepeatDetailedComponent } from './corepeat-detailed.component';

describe('CorepeatDetailedComponent', () => {
  let component: CorepeatDetailedComponent;
  let fixture: ComponentFixture<CorepeatDetailedComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CorepeatDetailedComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CorepeatDetailedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
