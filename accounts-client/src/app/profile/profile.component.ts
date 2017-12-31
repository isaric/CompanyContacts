import {Component, OnInit} from '@angular/core';
import {SessionService} from "../session.service";
import {User} from "../user/user";

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  constructor(sessionService: SessionService) {
    this.user = sessionService.getSessionUser();
  }

  private user: User;

  ngOnInit() {
  }


}
