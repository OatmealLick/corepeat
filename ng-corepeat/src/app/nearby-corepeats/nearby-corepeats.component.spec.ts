import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NearbyCorepeatsComponent } from './nearby-corepeats.component';

describe('NearbyCorepeatsComponent', () => {
  let component: NearbyCorepeatsComponent;
  let fixture: ComponentFixture<NearbyCorepeatsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NearbyCorepeatsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NearbyCorepeatsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
