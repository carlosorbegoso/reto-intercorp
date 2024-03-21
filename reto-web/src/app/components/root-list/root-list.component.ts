import { Component } from '@angular/core';
import { Root } from '../../models/root';
import { RootService } from '../../services/root.service';

@Component({
  selector: 'app-root-list',
  standalone: true,
  imports: [],
  templateUrl: './root-list.component.html',
  styleUrl: './root-list.component.css'
})
export class RootListComponent {
  roots: Root[] = [];

  constructor(private rootService: RootService) {}

  ngOnInit() {
   this.getList();
  }
  getList(){
    this.rootService.getRootList()
    .subscribe({
       next: root => this.roots = root,
       error: err => console.log(err)
    });
  }

}
