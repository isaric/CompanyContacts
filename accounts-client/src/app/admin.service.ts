import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {SessionService} from "./session.service";
import {Observable} from "rxjs/Observable";
import {User} from "./user/user";

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable()
export class AdminService {

  constructor(private http: HttpClient, private sessionService: SessionService) {
  }

  private allEmployeesUrl = "/api/admin/employees"

  getAllEmployees(): Observable<User[]> {
    this.appendSessionId();
    return this.http.get<User[]>(this.allEmployeesUrl, httpOptions);
  }

  private appendSessionId(): void {
    httpOptions.headers.set('jsessionId', this.sessionService.getSessionUser().sessionId.toString());
  }

}
