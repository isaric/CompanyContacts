import {Component, Input, OnInit} from '@angular/core';
import {Address} from "./address";
import {SessionService} from "../session.service";

@Component({
  selector: 'app-address',
  templateUrl: './address.component.html',
  styleUrls: ['./address.component.css']
})
export class AddressComponent implements OnInit {

  constructor() {
  }

  @Input() address: Address;

  ngOnInit() {
  }

}
