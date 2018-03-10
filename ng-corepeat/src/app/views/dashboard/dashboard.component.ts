import { Component, OnInit } from '@angular/core';
import {UserService} from "../user/user.service";
import {CorepeatService} from "../corepeat/corepeat.service";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {



  constructor(private userService: UserService,
              private corepeatService: CorepeatService) { }

  ngOnInit() {
  }

}
