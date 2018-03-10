import { Component, OnInit } from '@angular/core';
import {CorepeatService} from "../../corepeat/corepeat.service";
import {Corepeat} from "../../corepeat/corepeat";

@Component({
  selector: 'app-nearby-corepeats',
  templateUrl: './nearby-corepeats.component.html',
  styleUrls: ['./nearby-corepeats.component.css', '../views.css']
})
export class NearbyCorepeatsComponent implements OnInit {

  nearbyCorepeats: Corepeat[];

  constructor(private corepeatService: CorepeatService) { }

  ngOnInit() {
    this.getNearbyCorepeats();
  }

  getNearbyCorepeats(): void {
    this.corepeatService.getNearbyCorepeats().subscribe(corepeats => this.nearbyCorepeats = corepeats);
  }

}
