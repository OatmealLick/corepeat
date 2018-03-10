import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CorepeatSummaryComponent } from './corepeat-summary.component';

describe('CorepeatSummaryComponent', () => {
  let component: CorepeatSummaryComponent;
  let fixture: ComponentFixture<CorepeatSummaryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CorepeatSummaryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CorepeatSummaryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
