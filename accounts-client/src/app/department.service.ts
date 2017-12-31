import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {User} from "./user/user";
import {SessionService} from "./session.service";
import {Observable} from "rxjs/Observable";
import {Department} from "./department/department";

const httpOptions = {
  headers: new HttpHeaders()
};

@Injectable()
export class DepartmentService {

  constructor(private http: HttpClient, sessionService: SessionService) {
    this.user = sessionService.getSessionUser();
  }

  private user: User;

  private departmentsUrl = "/api/admin/departments";

  private createUrl = "/create";

  getAllDepartments(): Observable<Department[]> {
    this.appendSessionId();
    return this.http.get<Department[]>(this.departmentsUrl, httpOptions);
  }

  private appendSessionId(): void {
    httpOptions.headers.set('jsessionId', this.user.sessionId.toString());
  }

  private appendContentTypeJson(): void {
    httpOptions.headers.set('Content-Type', 'application/json');
  }

  getDepartment(uid: String): Observable<Department> {
    this.appendSessionId();
    return this.http.get<Department>(this.departmentsUrl + "/" + uid, httpOptions);
  }

  saveDepartment(department: Department): Observable<void> {
    this.appendSessionId();
    this.appendContentTypeJson();
    return this.http.post<void>(this.departmentsUrl + this.createUrl, department, httpOptions);
  }
}
