import {Component} from '@angular/core';
import {AuthenticationService} from "./authentication.service";


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  constructor(private loginService: AuthenticationService) {
  }

  title = 'Accounts Application';

  isAnon(): boolean {
    return this.loginService.isUserAnonymous()
  }

  isAdmin(): boolean {
    return this.loginService.isUserAdmin()
  }

  isEmployee(): boolean {
    return this.loginService.isUserEmployee();
  }

  isClient(): boolean {
    return this.loginService.isUserClient();
  }
}
