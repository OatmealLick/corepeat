import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  sidebarVisible: boolean = true;

  toggleSidebar() {
    this.sidebarVisible = !this.sidebarVisible;
  }
}
