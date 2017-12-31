import {Component, OnInit} from '@angular/core';
import {Company} from "../company/company";
import {CompanyService} from "../company.service";

@Component({
  selector: 'app-companies',
  templateUrl: './companies.component.html',
  styleUrls: ['./companies.component.css']
})
export class CompaniesComponent implements OnInit {

  constructor(private companyService: CompanyService) {
    this.companyService.getAllCompanies().subscribe(c => this.companies = c);
  }

  companies: Company[];

  ngOnInit() {
  }

}
