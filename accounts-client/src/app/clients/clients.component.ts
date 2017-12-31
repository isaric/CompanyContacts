import {Component, Input, OnInit} from '@angular/core';
import {User} from "../user/user";
import {CompanyService} from "../company.service";

@Component({
  selector: 'app-clients',
  templateUrl: './clients.component.html',
  styleUrls: ['./clients.component.css']
})
export class ClientsComponent implements OnInit {

  constructor(private companyService: CompanyService) {
    this.companyService.getClientsForCompany().subscribe(c => {
      this.clients = c;
    })
  }

  clients: User[];

  ngOnInit() {
  }

}
