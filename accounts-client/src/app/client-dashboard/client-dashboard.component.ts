import {Component, OnInit} from '@angular/core';
import {User} from "../user/user";
import {SessionService} from "../session.service";

@Component({
  selector: 'app-client-dashboard',
  templateUrl: './client-dashboard.component.html',
  styleUrls: ['./client-dashboard.component.css']
})
export class ClientDashboardComponent implements OnInit {

  constructor(private sessionService: SessionService) {
    this.user = sessionService.getSessionUser();
  }

  ngOnInit() {
  }

  user: User;

}
