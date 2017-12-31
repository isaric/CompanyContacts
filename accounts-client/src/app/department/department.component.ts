import {Component, OnInit} from '@angular/core';
import {Department} from "./department";
import {ActivatedRoute} from "@angular/router";
import {DepartmentService} from "../department.service";
import {User} from "../user/user";
import {AdminService} from "../admin.service";
import {Employee} from "../employee/employee";
import {Address} from "../address/address";

@Component({
  selector: 'app-department',
  templateUrl: './department.component.html',
  styleUrls: ['./department.component.css']
})
export class DepartmentComponent implements OnInit {

  constructor(private route: ActivatedRoute, private departmentService: DepartmentService, private adminService: AdminService) {
    this.route.params.subscribe(p => {
      if (p['uid'] != null) {
        this.uid = p['uid'];
        departmentService.getDepartment(this.uid).subscribe(d => this.department = d);
      }
      adminService.getAllEmployees().subscribe(e => this.allEmployees = e);
    })
  }

  uid: String;
  department: Department;
  allEmployees: User[];

  ngOnInit() {
  }

  equals(o1: User, o2: User) {
    return o1.uid == o2.uid;
  }

  contains(array: User[], user: User) {
    return (array.find(u => user.uid == u.uid) != null)
  }

  postDepartment() {
    this.departmentService.saveDepartment(this.department).subscribe();
  }

  saveAddress(address: Address) {
    this.department.address = address;
  }

}
