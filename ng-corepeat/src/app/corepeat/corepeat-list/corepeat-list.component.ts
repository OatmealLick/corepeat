import {Component, Input, OnInit} from '@angular/core';
import {Corepeat} from "../corepeat";
import {AuthService} from "../../auth.service";
import {UserService} from "../../user/user.service";
import {CorepeatService} from "../corepeat.service";
import {TimeSelector} from "./time-selector";

@Component({
  selector: 'app-corepeat-list',
  templateUrl: './corepeat-list.component.html',
  styleUrls: ['./corepeat-list.component.css']
})
export class CorepeatListComponent implements OnInit {

  @Input() timeSelector: TimeSelector;
  corepeats: Corepeat[] = [];

  constructor(private authService: AuthService,
              private userService: UserService,
              private corepeatService: CorepeatService) {
  }

  ngOnInit() {
    const userId = this.authService.getLoggedUserId();
    const currentDate = new Date();
    this.userService.getCorepeatsOfUser(userId).subscribe(corepeats => {
      if (this.timeSelector === TimeSelector.NO_SELECTION) {
        this.corepeats = corepeats;
      } else {
        for(let corepeat of corepeats) {
          // console.log(corepeat);
          // console.log(corepeat.date);
          // console.log(new Date(corepeat.date));

          console.log(this.timeSelector);
          switch (this.timeSelector) {
            case TimeSelector.AFTER_CURRENT:
              console.log('after');
              if (currentDate < new Date(corepeat.date)) { //nadchodzace corepeaty
                this.corepeats.push(corepeat);
              }
              break;
            case TimeSelector.BEFORE_CURRENT:
              console.log('before');
              if (currentDate > new Date(corepeat.date)) { //minione corepeaty
                this.corepeats.push(corepeat);
              }
              break;
          }
        }
      }
    });
    // console.log(this.corepeats);
  }
}
