import {Component, OnInit} from '@angular/core';
import {Corepeat} from "../corepeat";
import {AuthService} from "../../auth.service";
import {UserService} from "../../user/user.service";
import {CorepeatService} from "../corepeat.service";

@Component({
  selector: 'app-corepeat-list',
  templateUrl: './corepeat-list.component.html',
  styleUrls: ['./corepeat-list.component.css']
})
export class CorepeatListComponent implements OnInit {

  corepeats: Corepeat[];

  constructor(private authService: AuthService,
              private userService: UserService,
              private corepeatService: CorepeatService) {
  }

  ngOnInit() {
  }
}
