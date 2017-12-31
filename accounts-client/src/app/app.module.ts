import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';

import {AppComponent} from './app.component';
import {LoginComponent} from './login/login.component';
import {HttpClientModule} from "@angular/common/http";
import {AuthenticationService} from './authentication.service';
import {CompaniesComponent} from './companies/companies.component';
import {CompanyService} from "./company.service";
import {AppRoutingModule} from './/app-routing.module';
import {SessionService} from "./session.service";
import {LogoutComponent} from './logout/logout.component';
import {ProfileComponent} from './profile/profile.component';
import {UserService} from './user.service';
import {EmployeeDashboardComponent} from './employee-dashboard/employee-dashboard.component';
import {ClientDashboardComponent} from './client-dashboard/client-dashboard.component';
import {AdminDashboardComponent} from './admin-dashboard/admin-dashboard.component';
import {CompanyComponent} from './company/company.component';
import {ClientsComponent} from './clients/clients.component';
import {AddressComponent} from './address/address.component';
import {ClientComponent} from './client/client.component';
import {DepartmentComponent} from './department/department.component';
import {EmployeesComponent} from './employees/employees.component';
import {RouterModule} from "@angular/router";
import {DepartmentsComponent} from './departments/departments.component';
import {DepartmentService} from "./department.service";
import {AdminService} from './admin.service';
import {CreateDepartmentComponent} from './create-department/create-department.component';
import {AddressEditComponent} from './address-edit/address-edit.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    CompaniesComponent,
    LogoutComponent,
    ProfileComponent,
    EmployeeDashboardComponent,
    ClientDashboardComponent,
    AdminDashboardComponent,
    CompanyComponent,
    ClientsComponent,
    AddressComponent,
    ClientComponent,
    DepartmentComponent,
    EmployeesComponent,
    DepartmentsComponent,
    CreateDepartmentComponent,
    AddressEditComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
    RouterModule
  ],
  providers: [AuthenticationService, CompanyService, SessionService, UserService, DepartmentService, AdminService],
  bootstrap: [AppComponent]
})
export class AppModule { }
