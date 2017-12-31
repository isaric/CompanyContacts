import {Component, OnInit} from '@angular/core';
import {Login} from "../login";
import {AuthenticationService} from "../authentication.service";
import {User} from "../user/user";
import {SessionService} from "../session.service";
import {Router} from "@angular/router";


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {


  constructor(private loginService: AuthenticationService, private sessionService: SessionService, private router: Router) {
  }

  login: Login = {
    uid: '',
    password: '',
  };

  user: User;

  message: String = 'Please login to continue!';

  ngOnInit() {
  }

  postLogin(): void {
    this.loginService.doLogin(this.login).subscribe(u => {
      if (u.role == null) {
        this.message = 'Login attempt failed. Please try again!';
      }
      else {
        this.sessionService.setSessionUser(u);
        if (this.loginService.isUserEmployee()) {
          this.router.navigate(['/employeeDashboard']);
        } else if (this.loginService.isUserClient()) {
          this.router.navigate(['/clientDashboard']);
        } else if (this.loginService.isUserAdmin()) {
          this.router.navigate(['/adminDashboard']);
        }
      }
    });
  }

}
