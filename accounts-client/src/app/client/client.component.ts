import {Component, Input, OnInit} from '@angular/core';
import {User} from "../user/user";

@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.css']
})
export class ClientComponent implements OnInit {

  constructor() {
  }

  @Input() client: User;

  ngOnInit() {
  }

}
