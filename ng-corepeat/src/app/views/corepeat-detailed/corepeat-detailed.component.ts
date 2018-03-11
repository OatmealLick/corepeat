import {Component, OnInit, ViewChild} from '@angular/core';
import {Corepeat} from "../../corepeat/corepeat";
import {CorepeatService} from "../../corepeat/corepeat.service";
import {ActivatedRoute} from "@angular/router";
import {} from '@types/googlemaps';

@Component({
  selector: 'app-corepeat-detailed',
  templateUrl: './corepeat-detailed.component.html',
  styleUrls: ['./corepeat-detailed.component.css', '../views.css']
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
  }

  getCorepeatDetails() {
    const id: number = +this.route.snapshot.paramMap.get('id');
    this.corepeatService.getCorepeatDetails(id).subscribe(corepeat => {
      this.corepeat = corepeat;
      let coordinates = corepeat.coordinates.split(';');
      let markerCenter = new google.maps.LatLng(+coordinates[0], +coordinates[1]);
      let mapProp = {
        center: markerCenter,
        zoom: 15,
        mapTypeId: google.maps.MapTypeId.ROADMAP
      };
      this.map = new google.maps.Map(this.gmapElement.nativeElement, mapProp);
      let marker = new google.maps.Marker({
        position: markerCenter,
        animation: google.maps.Animation.BOUNCE
      });
      marker.setMap(this.map);
    });
  }
}
