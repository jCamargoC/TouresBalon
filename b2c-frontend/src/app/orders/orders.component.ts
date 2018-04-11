import { Component, OnInit, Inject } from '@angular/core';
import { Order } from '../utils/OrdersModels';
import { OrdersService } from '../services/orders.service';
import { ProductService } from '../services/product.service';
import { Producto } from '../utils/ProductsModels';
import { Client } from '../utils/ClientModels';
import { LOCAL_STORAGE, WebStorageService } from 'angular-webstorage-service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-orders',
  providers: [OrdersService, ProductService],
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.scss']
})
export class OrdersComponent implements OnInit {

  orders: Order[];
  client: Client = this.storage.get("user");
  productsMap = {};
  constructor(private router:Router,private productService: ProductService, private ordersService: OrdersService, @Inject(LOCAL_STORAGE) private storage: WebStorageService) { }

  ngOnInit() {
    this.ordersService.getOrders(this.client.id).subscribe(data => {
      this.orders = data;
      for (let i = 0; i < this.orders.length; i++) {
        const order = this.orders[i];
        for (let j = 0; j < order.items.length; j++) {
          const item = order.items[j];
          if (!this.productsMap[item.product]) {
            this.productService.getOneProduct(item.product).subscribe(data => {
              this.productsMap[item.product] = data;
            });
          }
        }
      }
    });
  }

  goToOrder(order:Order){
    this.storage.set("order",{order:order,productsMap:this.productsMap});
    this.router.navigateByUrl("/orderdetail");
  }

  goToMain(){
    this.router.navigateByUrl("/");
  }
}
