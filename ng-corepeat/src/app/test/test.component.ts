import {Component, OnInit} from '@angular/core';
import {TestService} from "../test.service";
import {MessageComponent} from "../message/message.component";

@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.css']
})
export class TestComponent implements OnInit {

  message: MessageComponent = new MessageComponent();

  constructor(private testService: TestService) {
  }

  getMessage(): void {
    this.testService.fetchMessage().subscribe(message => this.message = message);
  }

  ngOnInit() {
    this.getMessage();
  }

}
