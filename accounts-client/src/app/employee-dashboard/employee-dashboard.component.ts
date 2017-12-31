import {Component, OnInit} from '@angular/core';
import {User} from "../user/user";
import {SessionService} from "../session.service";
import {Company} from "../company/company";
import {CompanyService} from "../company.service";

@Component({
  selector: 'app-employee-dashboard',
  templateUrl: './employee-dashboard.component.html',
  styleUrls: ['./employee-dashboard.component.css']
})
export class EmployeeDashboardComponent implements OnInit {

  constructor(private sessionService: SessionService) {
    this.user = this.sessionService.getSessionUser();
  }

  user: User;

  clients: User[];

  ngOnInit() {
  }

}
