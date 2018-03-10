import { Component, OnInit } from '@angular/core';
import {UserService} from "../../user/user.service";
import {CorepeatService} from "../../corepeat/corepeat.service";
import {CorepeatListComponent, TimeSelector} from "../../corepeat/corepeat-list/corepeat-list.component";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css', '../views.css']
})
export class DashboardComponent implements OnInit {

  public timeSelectorType = TimeSelector;

  constructor(private userService: UserService,
              private corepeatService: CorepeatService) { }

  ngOnInit() {
  }

}
