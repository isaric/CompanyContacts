import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {Login} from "./login";
import {Observable} from "rxjs/Observable";
import {User} from "./user/user";
import {SessionService} from "./session.service";

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

const logoutOptions = {
  headers: new HttpHeaders()
};

@Injectable()
export class AuthenticationService {
  private loginUrl = '/api/login';
  private logoutUrl = '/api/logout';

  constructor(private http: HttpClient, private sessionService: SessionService) {
  }

  doLogin(login: Login): Observable<User> {
    return this.http.post<User>(this.loginUrl, login, httpOptions);
  }

  doLogout(): void {
    if (this.sessionService.getSessionUser() != null) {
      logoutOptions.headers.set('jsessionId', this.sessionService.getSessionUser().sessionId.toString());
      this.sessionService.setSessionUser(this.getAnonUser());
      this.http.post<User>(this.logoutUrl, logoutOptions);
    }
  }

  isUserAnonymous(): boolean {
    let user = this.sessionService.getSessionUser();
    return (user == null || user.role == null || user.role.toUpperCase() == 'ANONYMOUS')
  }

  isUserAdmin(): boolean {
    let user = this.sessionService.getSessionUser();
    return (!this.isUserAnonymous() && user.role.toUpperCase() == 'ADMIN')
  }

  isUserClient(): boolean {
    let user = this.sessionService.getSessionUser();
    return (!this.isUserAnonymous() && user.role.toUpperCase() == 'CLIENT')
  }

  isUserEmployee(): boolean {
    let user = this.sessionService.getSessionUser();
    return (!this.isUserAnonymous() && user.role.toUpperCase() == 'EMPLOYEE')
  }

  getAnonUser(): User {
    let anon = new User();
    anon.firstName = 'anonymous';
    anon.role = 'ANONYMOUS';
    return anon;
  }

}
