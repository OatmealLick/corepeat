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
    console.log(this.corepeat);
    var mapProp = {
      center: new google.maps.LatLng(this.corepeat.latitude, this.corepeat.longtitude),
      zoom: 15,
      mapTypeId: google.maps.MapTypeId.ROADMAP
    };
    this.map = new google.maps.Map(this.gmapElement.nativeElement, mapProp);
  }

  getCorepeatDetails() {
    const id: number = +this.route.snapshot.paramMap.get('id');
    console.log(id);
    this.corepeatService.getCorepeatDetails(id).subscribe(corepeat => this.corepeat = corepeat);
    console.log(this.corepeat);
  }
}
