import { Component, OnInit } from '@angular/core';
import { HardcodedAuthentificationService } from '../service/hardcoded-authentification.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {
  //isUserLoggedId:boolean=false;

  constructor(private hardcodedAuthentificationService: HardcodedAuthentificationService) { }

  ngOnInit() {
    //this.isUserLoggedId=this.hardcodedAuthentificationService.isUserLoggedIn();
  }

}
