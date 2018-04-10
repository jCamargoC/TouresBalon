import { Component, OnInit } from '@angular/core';
import { ClientService } from '../services/client.service';
import { Client, ClientResponse } from '../utils/ClientModels';
import { NotificationsService } from 'angular2-notifications';
import { Router } from '@angular/router';
import { FormGroup,FormControl,Validators } from '@angular/forms';


@Component({
  selector: 'app-register',
  providers: [ClientService],
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  client: Client = { id: null, creditCardNumber: null, email: null, creditCardType: null, names: null, lastNames: null, password: null, phoneNumber: null, status: null, addresses: [] };

  constructor(private clientService: ClientService, private notif: NotificationsService,private router:Router) { }
  registerForm:FormGroup;
  ngOnInit() {
    this.registerForm = new FormGroup({
      'names': new FormControl(this.client.names, [
        Validators.required
      ]),
      'lastNames': new FormControl(this.client.lastNames,Validators.required),
      'phoneNumber': new FormControl(this.client.phoneNumber),

    });
  }

  register() {
    this.client['status']='ACTIVE';
    this.clientService.createClient(this.client).subscribe(data => {
      this.notif.success(
        'Éxito',
        'Registro exitoso',
        {
          timeOut: 3000,
          showProgressBar: true,
          pauseOnHover: false,
          clickToClose: true,
          maxLength: 50,
          position:["top","middle"]
        }
      );
      this.router.navigateByUrl("/login")
    },
    error => {
      this.notif.error(
        'Error',
        error.error['message'],
        {
          timeOut: 3000,
          showProgressBar: true,
          pauseOnHover: false,
          clickToClose: true,
          maxLength: 50,
          position:["top","middle"]
        }
      );
    });
  }

  goToLogin(){
    this.router.navigateByUrl("/login");
  }

}
