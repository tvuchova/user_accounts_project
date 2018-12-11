import { Component, OnInit } from '@angular/core';
import { AccountDataService } from '../service/data/account-data.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Account } from '../list-accounts/list-accounts.component';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent implements OnInit {
  id: number
  account: Account

  constructor(
    private accountService: AccountDataService,
    private route: ActivatedRoute, private router: Router

  ) { }

  ngOnInit() {
    this.id = this.route.snapshot.params['id'];
    this.account = new Account(this.id, '', '', '', new Date());
    if (this.id != -1) {
      this.accountService.retrieveAccount(this.id)
        .subscribe(
          data => this.account = data
        )
    }

  }
  saveAccount() {
    if (this.id === -1) {
      this.accountService.createAccount(this.account)
        .subscribe(
          data => {
            console.log(data)
            this.router.navigate(['accounts'])
          }
        )
    } else {

      this.accountService.updateAccount(this.id, this.account)
        .subscribe(
          data => {
            console.log(data)
            this.router.navigate(['accounts'])
          }
        )
    }

  }

}
