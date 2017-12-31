import {Component, Input, OnInit} from '@angular/core';
import {User} from "../user/user";
import {CompanyService} from "../company.service";
import {Employee} from "../employee/employee";

@Component({
  selector: 'app-employees',
  templateUrl: './employees.component.html',
  styleUrls: ['./employees.component.css']
})
export class EmployeesComponent implements OnInit {

  constructor(private companyService: CompanyService) {
    this.companyService.getEmployeesForCompany().subscribe(e => {
      this.employees = e;
    })
  }

  employees: Employee[];

  ngOnInit() {
  }

}
