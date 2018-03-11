import {Component, OnInit, ViewChild} from '@angular/core';
import {Corepeat} from "../corepeat";
import {CorepeatService} from "../corepeat.service";
import {ActivatedRoute} from "@angular/router";
import {} from '@types/googlemaps';

@Component({
  selector: 'app-corepeat-detailed',
  templateUrl: './corepeat-detailed.component.html',
  styleUrls: ['./corepeat-detailed.component.css']
})
export class CorepeatDetailedComponent implements OnInit {

  @ViewChild('gmap') gmapElement: any;
  map: google.maps.Map;

  corepeat: Corepeat;

  constructor(private corepeatService: CorepeatService,
              private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.getCorepeatDetails();
    const coords = this.corepeat.coordinates.split(';');
    var mapProp = {
      center: new google.maps.LatLng(+coords[0], +coords[1]),
      zoom: 15,
      mapTypeId: google.maps.MapTypeId.ROADMAP
    };
    this.map = new google.maps.Map(this.gmapElement.nativeElement, mapProp);
  }

  getCorepeatDetails() {
    const id: number = +this.route.snapshot.paramMap.get('id');
    this.corepeatService.getCorepeatDetails(id).subscribe(corepeat => this.corepeat = corepeat);
  }
}
