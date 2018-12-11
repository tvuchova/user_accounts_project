import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { ErrorComponent } from './error/error.component';
import { ListAccountsComponent } from './list-accounts/list-accounts.component';
import { LogoutComponent } from './logout/logout.component';
import { RouteGuardService } from './service/route-guard.service';
import { AccountComponent } from './account/account.component';


const routes: Routes = [
  { path: '', component: LoginComponent },
  { path: 'login', component: LoginComponent },
  { path: 'welcome/:name', component: WelcomeComponent ,canActivate:[RouteGuardService]},
  { path: 'accounts', component:ListAccountsComponent ,canActivate:[RouteGuardService] },
  { path: 'logout', component:LogoutComponent,canActivate:[RouteGuardService]  },
  { path: 'accounts/:id', component:AccountComponent,canActivate:[RouteGuardService]  },
  { path: '**', component: ErrorComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
