import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AbastecimentoListComponent } from './abastecimento-list.component';

describe('AbastecimentoListComponent', () => {
  let component: AbastecimentoListComponent;
  let fixture: ComponentFixture<AbastecimentoListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AbastecimentoListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AbastecimentoListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
