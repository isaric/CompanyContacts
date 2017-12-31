import {Component, OnInit} from '@angular/core';
import {Department} from "../department/department";
import {DepartmentService} from "../department.service";

@Component({
  selector: 'app-departments',
  templateUrl: './departments.component.html',
  styleUrls: ['./departments.component.css']
})
export class DepartmentsComponent implements OnInit {

  constructor(private departmentService: DepartmentService) {
    this.departmentService.getAllDepartments().subscribe(d => this.departments = d);
  }

  departments: Department[];

  ngOnInit() {
  }

}
