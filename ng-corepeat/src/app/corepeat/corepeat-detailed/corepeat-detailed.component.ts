import {Component, OnInit, ViewChild} from '@angular/core';
import {Corepeat} from "../corepeat";
import {CorepeatService} from "../corepeat.service";
import {ActivatedRoute} from "@angular/router";
import LatLng = google.maps.LatLng;
import MapTypeId = google.maps.MapTypeId;

@Component({
  selector: 'app-corepeat-detailed',
  templateUrl: './corepeat-detailed.component.html',
  styleUrls: ['./corepeat-detailed.component.css']
})
export class CorepeatDetailedComponent implements OnInit {

  @ViewChild('gmap') gmapElement: any;
  map: Map;

  corepeat: Corepeat;

  constructor(private corepeatService: CorepeatService,
              private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.getCorepeatDetails();
    // console.log(this.corepeat);
    // console.log(this.corepeatService.getCorepeatDetails(1));
    // const coords = this.corepeat.coordinates.split(';');
    var mapProp = {
      center: new LatLng(14, 14),
      // center: new google.maps.LatLng(+coords[0], +coords[1]),
      zoom: 15,
      mapTypeId: MapTypeId.ROADMAP
    };
    this.map = new Map(this.gmapElement.nativeElement, mapProp);
  }

  getCorepeatDetails() {
    const id: number = +this.route.snapshot.paramMap.get('id');
    this.corepeatService.getCorepeatDetails(id).subscribe(corepeat => {
      console.log("hej");
      console.log(corepeat);
      this.corepeat = corepeat});
    console.log(this.corepeat);
  }
}
