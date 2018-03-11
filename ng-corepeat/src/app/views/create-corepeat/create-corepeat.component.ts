import { Component, OnInit } from '@angular/core';
import {Corepeat} from "../../corepeat/corepeat";
import {CorepeatService} from "../../corepeat/corepeat.service";

@Component({
  selector: 'app-create-corepeat',
  templateUrl: './create-corepeat.component.html',
  styleUrls: ['./create-corepeat.component.css', '../views.css']
})
export class CreateCorepeatComponent implements OnInit {

  createdCorepeat: Corepeat = new Corepeat();

  constructor(private corepeatService: CorepeatService) { }

  ngOnInit() {
  }

  submitCorepeat() {
    this.corepeatService.createCorepeat(this.createdCorepeat).subscribe(sent => {});
  }
}
