import { User } from './../model/user';
import { Injectable } from '@angular/core';

const TOKEN_KEY = 'auth-token';
const USER_KEY = 'auth-user';

@Injectable({
  providedIn: 'root'
})
export class TokenStorageService {

  constructor() { }

  singOut():void{
    window.sessionStorage.clear();
  }

  saveToken(token: string):void{
    window.sessionStorage.removeItem(TOKEN_KEY);
    window.sessionStorage.setItem(TOKEN_KEY, token);
  }

  getToken(): string{
    return sessionStorage.getItem(TOKEN_KEY)!;
  }

  saveUser(user: User): void {
    window.sessionStorage.removeItem(USER_KEY);
    window.sessionStorage.setItem(USER_KEY, JSON.stringify(user));
  }

  getUser(): any{
    return JSON.parse(sessionStorage.getItem(USER_KEY)!);
  }
}
