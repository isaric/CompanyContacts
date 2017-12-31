import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {User} from "./user/user";
import {Company} from "./company/company";
import {Observable} from "rxjs/Observable";
import {SessionService} from "./session.service";
import {Employee} from "./employee/employee";

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable()
export class CompanyService {

  constructor(private http: HttpClient, sessionService: SessionService) {
    this.user = sessionService.getSessionUser();
  }

  private user: User;

  private companyUrl = "/api/companies";

  private clientUrl = "/clients";

  private contactPersonUrl = "/contactPersons";

  private allCompaniesUrl = "/api/admin/companies";

  getCompanyForUser(): Observable<Company> {
    this.appendSessionId();
    return this.http.get<Company>(this.companyUrl, httpOptions);
  }

  private appendSessionId(): void {
    httpOptions.headers.set('jsessionId', this.user.sessionId.toString());
  }

  getClientsForCompany(): Observable<User[]> {
    this.appendSessionId();
    return this.http.get<User[]>(this.companyUrl + this.clientUrl, httpOptions);
  }

  getEmployeesForCompany(): Observable<Employee[]> {
    this.appendSessionId();
    return this.http.get<Employee[]>(this.companyUrl + this.contactPersonUrl, httpOptions);
  }

  getAllCompanies(): Observable<Company[]> {
    this.appendSessionId();
    return this.http.get<Company[]>(this.allCompaniesUrl, httpOptions);
  }

}
