import {NgModule} from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {LoginComponent} from "./login/login.component";
import {CompaniesComponent} from "./companies/companies.component";
import {LogoutComponent} from "./logout/logout.component";
import {EmployeeDashboardComponent} from "./employee-dashboard/employee-dashboard.component";
import {ProfileComponent} from "./profile/profile.component";
import {ClientDashboardComponent} from "./client-dashboard/client-dashboard.component";
import {AdminDashboardComponent} from "./admin-dashboard/admin-dashboard.component";
import {DepartmentComponent} from "./department/department.component";
import {CompanyComponent} from "./company/company.component";
import {CreateDepartmentComponent} from "./create-department/create-department.component";

const routes: Routes = [
  {path: '', redirectTo: '/login', pathMatch: 'full'},
  {path: 'employeeDashboard', component: EmployeeDashboardComponent},
  {path: 'login', component: LoginComponent},
  {path: 'logout', component: LogoutComponent},
  {path: 'companies', component: CompaniesComponent},
  {path: 'user', component: ProfileComponent},
  {path: 'clientDashboard', component: ClientDashboardComponent},
  {path: 'adminDashboard', component: AdminDashboardComponent},
  {path: 'viewDepartment/:uid', component: DepartmentComponent},
  {path: 'createDepartment', component: CreateDepartmentComponent},
  {path: 'viewCompany/:uid', component: CompanyComponent}
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule],
  declarations: []
})
export class AppRoutingModule {
}
