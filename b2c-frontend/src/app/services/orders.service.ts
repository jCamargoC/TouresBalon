import { Injectable } from '@angular/core';
import { Constants } from '../utils/Constants';
import { Order, OrderResponse } from '../utils/OrdersModels';

import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';

@Injectable()
export class OrdersService {

  constructor(private http: HttpClient) { }

  getOrders(clientId:number){
    const url=Constants.ORDERS_URL+"client/"+clientId; 
     var params:HttpHeaders=new HttpHeaders();
     params=params.append("Content-Type","application/json");
    return this.http.get<OrderResponse>(url,{headers:params});
  }

  createOrder(order:Order){
    const url=Constants.ORDERS_URL;     
    return this.http.post<Order>(url,order);
  }

  updateState(order:Order){
    const url=Constants.ORDERS_URL;     
    /*var params:HttpParams=new HttpParams();
    params=params.append("idOrden",orderId.toString()).append("estadoNuevo",state);*/
    return this.http.put<Order>(url,order);
  }
}
