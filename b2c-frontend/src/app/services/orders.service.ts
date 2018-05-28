import { Injectable } from '@angular/core';
import { Constants } from '../utils/Constants';
import { Order } from '../utils/OrdersModels';

import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';

@Injectable()
export class OrdersService {

  constructor(private http: HttpClient) { }

  getOrders(clientId:number){
    const url=Constants.ORDERS_URL; 
     var params:HttpParams=new HttpParams();
     params=params.append("id","0").append("idCliente",clientId.toString());
    return this.http.get<Order[]>(url,{params:params});
  }

  createOrder(order:Order){
    const url=Constants.ORDERS_URL;     
    return this.http.post<string>(url,order);
  }

  updateState(orderId:number,state:string){
    const url=Constants.ORDERS_URL;     
    var params:HttpParams=new HttpParams();
    params=params.append("idOrden",orderId.toString()).append("estadoNuevo",state);
    return this.http.put<string>(url,undefined,{params:params});
  }
}
