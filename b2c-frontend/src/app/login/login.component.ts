import { Component, OnInit, Inject } from '@angular/core';
import { Router } from '@angular/router';
import { LOCAL_STORAGE, WebStorageService } from 'angular-webstorage-service';
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
  constructor(@Inject(LOCAL_STORAGE) private storage: WebStorageService,private router: Router, private loginService: LoginService,private clientService:ClientService) { }

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
    this.loginService.login(this.login.user, this.login.password).subscribe(data => {
      this.storage.set("user",data['payload']);
      window.location.reload();
      this.router.navigateByUrl("/");
    });
  }
  goToMain() {
    this.router.navigateByUrl("/");
  }

}
