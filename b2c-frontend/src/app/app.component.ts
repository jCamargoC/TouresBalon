import { Component,Inject } from '@angular/core';
import {Router} from '@angular/router';
import {LOCAL_STORAGE, WebStorageService} from 'angular-webstorage-service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  searchText = null;
  showSearch=true;
  constructor(@Inject(LOCAL_STORAGE) private storage: WebStorageService,private router:Router) {
     
  }
  search(){
    this.storage.set("searchText",this.searchText);
    this.showSearch=false;
    this.router.navigateByUrl('/search');
  }

  goToCart(){
    this.router.navigateByUrl("/shoppingcart");
  }
  
  goToLogin(){
    this.router.navigateByUrl("/login");
  }
}
