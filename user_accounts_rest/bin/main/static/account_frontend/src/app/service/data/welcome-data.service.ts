import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { API_URL } from 'src/app/app.constants';

export class WelcomeBean {
  constructor(public message: string) { }
}
@Injectable({
  providedIn: 'root'
})
export class WelcomeDataService {

  constructor(
    private http: HttpClient
  ) { }
  executeHelloWorldBeanService() {
    return this.http.get<WelcomeBean>('http://localhost:8080/welcome-bean');
  }
  executeHelloWorldServiceWithPathVariable(name) {

    return this.http.get<WelcomeBean>(`${API_URL}/welcome/path-variable/${name}`,
      //{headers}
    );
  }


}
