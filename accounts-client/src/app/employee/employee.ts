import {User} from "../user/user";
import {Department} from "../department/department";

export class Employee extends User {
  department: Department;
}
