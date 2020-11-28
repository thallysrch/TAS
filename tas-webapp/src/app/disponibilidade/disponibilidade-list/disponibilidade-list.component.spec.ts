import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DisponibilidadeListComponent } from './disponibilidade-list.component';

describe('DisponibilidadeListComponent', () => {
  let component: DisponibilidadeListComponent;
  let fixture: ComponentFixture<DisponibilidadeListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DisponibilidadeListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DisponibilidadeListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
