import { Component, OnInit } from '@angular/core';
import {User} from "../user";
import {UserService} from "../user.service";

@Component({
  selector: 'app-user-detailed',
  templateUrl: './user-detailed.component.html',
  styleUrls: ['./user-detailed.component.css']
})
export class UserDetailedComponent implements OnInit {

  user: User;

  constructor(private userService: UserService) { }

  ngOnInit() {
  }

}
