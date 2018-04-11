import { Component, OnInit, Inject } from '@angular/core';
import { LOCAL_STORAGE, WebStorageService } from 'angular-webstorage-service';
import { Router } from '@angular/router';
import { Order } from '../utils/OrdersModels';

@Component({
  selector: 'app-order-detail',
  templateUrl: './order-detail.component.html',
  styleUrls: ['./order-detail.component.scss']
})
export class OrderDetailComponent implements OnInit {
  order:Order=null;
  productsMap;
  constructor(private router: Router, @Inject(LOCAL_STORAGE) private storage: WebStorageService) { }

  ngOnInit() {
    var orderStored=this.storage.get("order");
    this.order=orderStored['order'];
    this.productsMap=orderStored['productsMap'];
  }

  goToOrders(){
    this.storage.remove("order");
    this.router.navigateByUrl("/orders")
  }
}
