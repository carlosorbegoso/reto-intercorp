import { Component } from '@angular/core';
import { Root } from '../../models/root';
import { RootService } from '../../services/root.service';
import { DatePipe } from '@angular/common';


@Component({
  selector: 'app-root-list',
  standalone: true,
  imports: [],
  templateUrl: './root-list.component.html',
  styleUrl: './root-list.component.css'
})
export class RootListComponent {
  roots: Root[] = [];
  lastUpdate: Date = new Date();
  formattedDate: string = this.lastUpdate.toLocaleString('es-ES', {
    weekday: 'long',
    hour: 'numeric',
    minute: 'numeric',
    second: 'numeric',
    hour12: false
  });


  constructor(private rootService: RootService) {}

  ngOnInit() {
   this.fetchData();
  }

  fetchData(){
    setTimeout(()=>{
      this.lastUpdate = new Date();
      this.getList();
    
    },1000);
  }
  
 
  getList(){
    this.rootService.getRootList()
    .subscribe({
       next: root => {this.roots = root;
    },
       
       error: err =>{
        console.log(err);
       }

    });
  }

}
