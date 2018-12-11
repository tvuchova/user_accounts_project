import { Component, OnInit } from '@angular/core';
import { AccountDataService } from '../service/data/account-data.service';
import { Router } from '@angular/router';


export class Account {
  constructor(
    public id: number,
    public firstName: string,
    public lastName: string,
    public email: string,
    public birthDate: Date

  ) {

  }
}
@Component({
  selector: 'app-list-accounts',
  templateUrl: './list-accounts.component.html',
  styleUrls: ['./list-accounts.component.css']
})
export class ListAccountsComponent implements OnInit {

  //accounts=[
  //  new Account(1,'Ivan','Petrov','sss',new Date()),
  //  new Account(2,'Stoqn','Petrov','sss@aaa.com',new Date()),
  //  new Account(3,'Moni','Petrov','sss@aaa.com',new Date())
  //]

  accounts: Account[]
  message: string
  //sorting

  key: string = 'firstName'; //set default
  reverse: boolean = false;

  p: number = 1;


  constructor(
    private accountService: AccountDataService,
    private router: Router) { }

  ngOnInit() {
    this.refreshAccounts();
  }
  sort(key) {
    this.key = key;
    this.reverse = !this.reverse;
  }

  refreshAccounts() {
    this.accountService.retrieveAllAccounts().subscribe(
      response => {
        console.log(response);
        this.accounts = response;
      })
  }

  deleteAccount(id) {
    console.log(`delete account ${id}`)
    this.accountService.deleteAccount(id).subscribe(
      response => {
        console.log(response);
        this.message = `Delete of account ${id} Successful!`;
        this.refreshAccounts();
      }
    )
  }
  updateAccount(id) {
    console.log(`update ${id}`)
    this.router.navigate(['accounts', id])
  }
  addAccount(id) {
    this.router.navigate(['accounts', -1])
  }
}
