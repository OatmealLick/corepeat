import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-message',
  templateUrl: './message.component.html',
  styleUrls: ['./message.component.css']
})
export class MessageComponent implements OnInit {

  message: string;

  constructor() {
    this.message = 'Nie moge dac nic fajnieszego';
  }

  ngOnInit() {
  }

}