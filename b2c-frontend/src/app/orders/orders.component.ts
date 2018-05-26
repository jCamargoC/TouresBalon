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
  constructor(private router: Router, private productService: ProductService, private ordersService: OrdersService, @Inject(LOCAL_STORAGE) private storage: WebStorageService) { }

  ngOnInit() {
    this.orders = this.storage.get("orders");
    if (this.orders) {
      for (let i = 0; i < this.orders.length; i++) {
        const order = this.orders[i];
        
         
          if (!this.productsMap[order.idProducto]) {
            this.productService.getOneProduct(order.idProducto).subscribe(data => {
              this.productsMap[order.idProducto] = data;
            });
          }
        }
      
    } else {
      this.ordersService.getOrders(this.client.id).subscribe(data => {
        this.orders = data;
        this.storage.set("orders",this.orders);
        for (let i = 0; i < this.orders.length; i++) {
          const order = this.orders[i];
        
            if (!this.productsMap[order.idProducto]) {
              this.productService.getOneProduct(order.idProducto).subscribe(data => {
                this.productsMap[order.idProducto] = data;
              });
            }
          
        }
      });
    }
  }

  goToOrder(order: Order,index:number) {
    this.storage.set("order", { order: order, productsMap: this.productsMap,index:index });
    this.router.navigateByUrl("/orderdetail");
  }

  goToMain() {
    this.storage.remove("orders");
    this.router.navigateByUrl("/");
  }
}
