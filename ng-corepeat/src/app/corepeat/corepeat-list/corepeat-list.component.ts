import {Component, Input, OnInit} from '@angular/core';
import {Corepeat} from "../corepeat";
import {AuthService} from "../../auth.service";
import {UserService} from "../../user/user.service";
import {CorepeatService} from "../corepeat.service";

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
              private userService: UserService,
              private corepeatService: CorepeatService) {
  }

  ngOnInit() {
    const userId = this.authService.getLoggedUserId();
    const currentDate = new Date();

    if (this.timeSelector === TimeSelector.NO_SELECTION) {
      console.log('Fetching nearby corepeats');
      this.corepeatService.getNearbyCorepeats().subscribe(corepeats => this.corepeats = corepeats);
    }
    else {
      this.userService.getCorepeatsOfUser(userId).subscribe(corepeats => {
        for (let corepeat of corepeats) {
          switch (this.timeSelector) {
            case TimeSelector.AFTER_CURRENT:
              if (currentDate < new Date(corepeat.date)) { //nadchodzace corepeaty
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
      });
    }
  }
}
