import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateCorepeatComponent } from './create-corepeat.component';

describe('CreateCorepeatComponent', () => {
  let component: CreateCorepeatComponent;
  let fixture: ComponentFixture<CreateCorepeatComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateCorepeatComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateCorepeatComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
