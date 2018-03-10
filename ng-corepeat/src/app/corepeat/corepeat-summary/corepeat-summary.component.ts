import {Component, Input, OnInit} from '@angular/core';
import {Corepeat} from "../corepeat";

@Component({
  selector: 'app-corepeat-summary',
  templateUrl: './corepeat-summary.component.html',
  styleUrls: ['./corepeat-summary.component.css']
})
export class CorepeatSummaryComponent implements OnInit {

  @Input()
  corepeat: Corepeat;

  constructor() { }

  ngOnInit() {
  }

}
