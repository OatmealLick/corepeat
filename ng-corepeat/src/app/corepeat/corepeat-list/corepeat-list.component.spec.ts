import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CorepeatListComponent } from './corepeat-list.component';

describe('CorepeatListComponent', () => {
  let component: CorepeatListComponent;
  let fixture: ComponentFixture<CorepeatListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CorepeatListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CorepeatListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
