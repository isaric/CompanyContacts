import {Component, Input, OnInit} from '@angular/core';
import {Company} from "./company";
import {CompanyService} from "../company.service";
import {SessionService} from "../session.service";

@Component({
  selector: 'app-company',
  templateUrl: './company.component.html',
  styleUrls: ['./company.component.css']
})
export class CompanyComponent implements OnInit {

  constructor(private companyService: CompanyService, private sessionService: SessionService) {
    this.companyService.getCompanyForUser().subscribe(c => this.company = c);
  }

  company: Company;

  ngOnInit() {
  }

}
