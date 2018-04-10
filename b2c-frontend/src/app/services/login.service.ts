import { Injectable } from '@angular/core';
import { Constants } from '../utils/Constants';
import { Observable } from 'rxjs/Observable';
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { ClientResponse } from '../utils/ClientModels';

@Injectable()
export class LoginService {

  constructor(private http: HttpClient) { }

  login(username: string, password: string): Observable<HttpResponse<ClientResponse>> {
    const url = Constants.LOGIN_URL;
    var encoded = btoa(username + ":" + password);
    let headers = new HttpHeaders();
    headers = headers.append("Authorization", "Basic " + encoded);
    headers = headers.append("Content-Type", "application/json");
    const httpOptions = {
      headers: headers
    };
    console.log(httpOptions.headers.get("Authorization"));
    return this.http.post<ClientResponse>(url, username, {
      "headers": headers,
      observe: 'response'
    });
  }
}
