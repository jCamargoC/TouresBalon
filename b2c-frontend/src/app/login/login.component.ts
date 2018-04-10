import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { FormGroup, FormControl, Validators } from '@angular/forms';
import { LoginService } from '../services/login.service';
import { ClientService } from '../services/client.service';

@Component({
  selector: 'app-login',
  providers: [LoginService, ClientService],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  login = { user: null, password: null };
  emailFormControl = new FormControl('', [
    Validators.required,
    Validators.email,
  ]);
  constructor(private router: Router, private loginService: LoginService,private clientService:ClientService) { }

  ngOnInit() {
    this.loginForm = new FormGroup({
      'user': new FormControl(this.login.user, [
        Validators.required
      ]),
      'password': new FormControl(this.login.password, Validators.required),
    });
  }

  goToRegister() {
    this.router.navigateByUrl("/register");
  }

  doLogin() {
    this.loginService.login(this.login.user, this.login.password).subscribe(resp => {
      console.log(resp);
      const keys = resp.headers.keys();
      var headers = keys.map(key =>
        `${key}: ${resp.headers.get(key)}`);
        console.log(headers);
      this.clientService.getClientById(3).subscribe(data=>{
        console.log("tenga su servicio");
      });
    });
  }
  goToMain() {
    this.router.navigateByUrl("/");
  }

}
