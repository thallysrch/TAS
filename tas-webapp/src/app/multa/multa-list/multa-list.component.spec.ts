import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MultaListComponent } from './multa-list.component';

describe('MultaListComponent', () => {
  let component: MultaListComponent;
  let fixture: ComponentFixture<MultaListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MultaListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MultaListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
