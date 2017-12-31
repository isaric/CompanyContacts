import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Address} from "../address/address";

@Component({
  selector: 'app-address-edit',
  templateUrl: './address-edit.component.html',
  styleUrls: ['./address-edit.component.css']
})
export class AddressEditComponent implements OnInit {

  constructor() {
    this.addressData = new EventEmitter<Address>();
  }

  @Input("address") address: Address;

  @Output()("address") addressData: EventEmitter<Address>;

  ngOnInit() {
  }

  handleInput() {
    this.addressData.emit(this.address);
  }

}
