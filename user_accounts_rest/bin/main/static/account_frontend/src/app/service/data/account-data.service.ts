import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Account } from 'src/app/list-accounts/list-accounts.component';
import { API_URL } from 'src/app/app.constants';

@Injectable({
  providedIn: 'root'
})
export class AccountDataService {

  constructor(
    private http: HttpClient
  ) { }
  retrieveAllAccounts() {
    return this.http.get<Account[]>(`${API_URL}/accounts`);
  }
  deleteAccount(id) {
    return this.http.delete(`${API_URL}/accounts/${id}`);
  }
  retrieveAccount(id) {
    return this.http.get<Account>(`${API_URL}/accounts/${id}`);
  }
  updateAccount(id, account) {
    return this.http.put(
      `${API_URL}/accounts/${id}`, account);
  }
  createAccount(account) {
    return this.http.post(
      `${API_URL}/accounts`
      , account);
  }
}
