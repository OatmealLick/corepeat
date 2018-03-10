import { Component, OnInit } from '@angular/core';
import {Corepeat} from "../corepeat";
import {CorepeatService} from "../corepeat.service";
import {ActivatedRoute} from "@angular/router";
import {Location} from "@angular/common";

@Component({
  selector: 'app-corepeat-detailed',
  templateUrl: './corepeat-detailed.component.html',
  styleUrls: ['./corepeat-detailed.component.css']
})
export class CorepeatDetailedComponent implements OnInit {

  corepeat: Corepeat;

  constructor(private corepeatService: CorepeatService,
              private route: ActivatedRoute) { }

  ngOnInit() {
    this.getCorepeatDetails();
  }

  getCorepeatDetails() {
    const id: number = +this.route.snapshot.paramMap.get('id');
    this.corepeatService.getCorepeatDetails(id).subscribe(corepeat => this.corepeat = corepeat);
  }

}
