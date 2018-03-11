import { Component, OnInit } from '@angular/core';
import {UserService} from "../../user/user.service";
import {CorepeatService} from "../../corepeat/corepeat.service";
import {CorepeatListComponent, TimeSelector} from "../../corepeat/corepeat-list/corepeat-list.component";
import {User} from "../../user/user";
import {environment} from "../../../environments/environment";
import {AchievementService} from "../../achievement.service";
import {Achievements} from "../../achievements";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css', '../views.css']
})
export class DashboardComponent implements OnInit {

  public timeSelectorType = TimeSelector;
  loggedUser: User = new User();
  achievements: Achievements = new Achievements();

  constructor(private userService: UserService,
              private achievementService: AchievementService,
              private corepeatService: CorepeatService) { }

  ngOnInit() {
    this.getLoggedUser()
  }

  getLoggedUser() {
    this.userService.getUser(environment.loggedUserId)
      .subscribe(user => this.loggedUser = user);
  }

  getUserAchievements() {
    this.achievementService.getAchievementsForUser(environment.loggedUserId)
      .subscribe(achievements => this.achievements = achievements);
  }

}
