import {Injectable} from '@angular/core';
import {Session} from "./session";
import {User} from "./user/user";

const sessionUser: String = 'sessionUser';

@Injectable()
export class SessionService {

  constructor() {
    this.session = new Session;
  }

  private session: Session;

  setSessionUser(user: User): void {
    this.session.set(sessionUser, user);
  }

  getSessionUser(): User {
    return <User> this.session.get(sessionUser);
  }

  setValue(key: string, value: Object): void {
    this.session.set(key, value);
  }

  getValue(key: string): Object {
    return this.session.get(key);
  }
}
