import {ApplicationRef, Component, OnInit} from '@angular/core';
import {AuthenticationService} from "../authentication.service";

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private loginService: AuthenticationService, private applicationRef: ApplicationRef) {
    this.loginService.doLogout();
    this.applicationRef.tick();
  }

  ngOnInit() {
  }

}
