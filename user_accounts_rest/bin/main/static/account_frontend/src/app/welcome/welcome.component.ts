import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { WelcomeDataService } from '../service/data/welcome-data.service';


@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {
 message='Some welcome message'
 welcomeMessageFromService:string
 name=''
  constructor(
       private route:ActivatedRoute,
       private service:WelcomeDataService) { }

  ngOnInit() {
    console.log(this.message)
    //console.log(this.route.snapshot.params['name'])
    this.name=this.route.snapshot.params['name']
  }
  getWelcomeMessage(){
     this.service.executeHelloWorldBeanService().subscribe(
       response=>this.handlingSuccessfulResponse(response),
       error=>this.handleErrorResponse(error)
     );
  }
  getWelcomeMessageWithParameter(){
    this.service.executeHelloWorldServiceWithPathVariable(this.name).subscribe(
      response=>this.handlingSuccessfulResponse(response),
      error=>this.handleErrorResponse(error)
    );
  }

  handlingSuccessfulResponse(response){
    this.welcomeMessageFromService=response.message
  }
  handleErrorResponse(error){
    this.welcomeMessageFromService=error.error.message
  }
}
