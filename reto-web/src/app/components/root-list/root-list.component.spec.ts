import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RootListComponent } from './root-list.component';

describe('RootListComponent', () => {
  let component: RootListComponent;
  let fixture: ComponentFixture<RootListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RootListComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(RootListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
