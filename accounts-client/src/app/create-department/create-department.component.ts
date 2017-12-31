import {Component, OnInit} from '@angular/core';
import {DepartmentService} from "../department.service";
import {AdminService} from "../admin.service";
import {User} from "../user/user";
import {Department} from "../department/department";
import {Address} from "../address/address";

@Component({
  selector: 'app-create-department',
  templateUrl: './create-department.component.html',
  styleUrls: ['./create-department.component.css']
})
export class CreateDepartmentComponent implements OnInit {

  constructor(private departmentService: DepartmentService, private adminService: AdminService) {
    this.adminService.getAllEmployees().subscribe(e => {
      this.allEmployees = e;
      this.department = new Department;
      this.department.address = new Address;
      this.department.manager = new User;
      this.department.employees = [];
    });
  }

  department: Department;
  allEmployees: User[];

  ngOnInit() {
  }

  postDepartment() {
    this.departmentService.saveDepartment(this.department).subscribe();
  }

  updateAddress(address: Address) {
    this.department.address = address;
  }

}
