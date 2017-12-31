import {Address} from "../address/address";
import {User} from "../user/user";

export class Department {
  uid: String;
  name: String;
  address: Address;
  manager: User;
  employees: User[];
}
