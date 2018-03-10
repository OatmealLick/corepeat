import {Component, Input, OnInit} from '@angular/core';
import {Corepeat} from "../corepeat";
import {AuthService} from "../../auth.service";
import {UserService} from "../../user/user.service";

export enum TimeSelector {
  BEFORE_CURRENT, AFTER_CURRENT, NO_SELECTION
}

@Component({
  selector: 'app-corepeat-list',
  templateUrl: './corepeat-list.component.html',
  styleUrls: ['./corepeat-list.component.css']
})
export class CorepeatListComponent implements OnInit {

  @Input() timeSelector: TimeSelector;
  corepeats: Corepeat[] = [];

  constructor(private authService: AuthService,
              private userService: UserService) {
  }

  ngOnInit() {
    const userId = this.authService.getLoggedUserId();
    const currentDate = new Date();
    console.log(this.timeSelector);
    this.userService.getCorepeatsOfUser(userId).subscribe(corepeats => {
      if (this.timeSelector === TimeSelector.NO_SELECTION) {
        this.corepeats = corepeats;
      } else {
        console.log(corepeats[0].date);
        for(let corepeat of corepeats) {
          switch (this.timeSelector) {
            case TimeSelector.AFTER_CURRENT:
              console.log("after switch case 1");
              console.log(currentDate);
              console.log(new Date(corepeat.date));
              if (currentDate < new Date(corepeat.date)) { //nadchodzace corepeaty
                console.log("in if");
                this.corepeats.push(corepeat);
              }
              break;
            case TimeSelector.BEFORE_CURRENT:
              if (currentDate > new Date(corepeat.date)) { //minione corepeaty
                this.corepeats.push(corepeat);
              }
              break;
          }
        }
        console.log(this.corepeats);
      }
    });
  }
}
