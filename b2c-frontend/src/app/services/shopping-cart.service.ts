import { Injectable } from '@angular/core';
import { ShoppingCart, ShoppingCartResponse, ReserveResponse } from '../utils/ShoppingCartModels'
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Constants } from '../utils/Constants';
import { reservaInput, CancelInput } from '../utils/BPELCrearReservaModels';

@Injectable()
export class ShoppingCartService {

  constructor(private http: HttpClient) { }

  createShoppingCart(shoppingCart: ShoppingCart) {
    const url = Constants.SHOPPING_CART_URL;

    return this.http.post<ShoppingCartResponse>(url, shoppingCart);
  }

  getShoppingCartById(id: number) {
    const url = Constants.SHOPPING_CART_URL + id;
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
      })
    };
    return this.http.get<ShoppingCartResponse>(url, httpOptions);
  }

  getShoppingCartByClient(id: number) {
    const url = Constants.SHOPPING_CART_URL + "client/"+id;
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
      })
    };
    return this.http.get<ShoppingCartResponse>(url, httpOptions);
  }

  updateShoppingCart(shoppingCart: ShoppingCart) {
    const url = Constants.SHOPPING_CART_URL;

    return this.http.put<ShoppingCartResponse>(url, shoppingCart);
  }

  removeItem(shoppingCart: ShoppingCart, itemId) {
    const url = Constants.SHOPPING_CART_URL + 'item/' + itemId;
    return this.http.put<ShoppingCartResponse>(url, shoppingCart);
  }

  reserve(reserva:reservaInput){
    const url=Constants.SHOPPING_CART_URL + 'bpel';
    const urlSoap=Constants.BPEL_CREAR_RESERVA_URL;
    
    const xmlPayload=this.objectToXml(reserva);
    const envelope="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns=\"http://xmlns.oracle.com/TouresBalon/TouresBalonProject/BPELCrearReserva\">"
    + "   <soapenv:Header/><soapenv:Body><ReservaInput>"+xmlPayload+"</ReservaInput></soapenv:Body></soapenv:Envelope>";
    console.log(envelope);
    return this.http.post<ReserveResponse>(url, {url:urlSoap,action:"process",payload:envelope});
  }

  cancelReserve(input:CancelInput){
    const url=Constants.SHOPPING_CART_URL + 'bpel';
    const urlSoap=Constants.BPEL_CANCELAR_RESERVA_URL;
    
    const xmlPayload=this.objectToXml(input);
    const envelope="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns=\"http://xmlns.oracle.com/TouresBalon/TouresBalonProject/BPELCancelarReserva\">"
    + "   <soapenv:Header/><soapenv:Body><ReservaInput>"+xmlPayload+"</ReservaInput></soapenv:Body></soapenv:Envelope>";
    console.log(envelope);
    return this.http.post<ReserveResponse>(url, {url:urlSoap,action:"cancel",payload:envelope});
  }

  objectToXml(obj) {
    var xml = '';

    for (var prop in obj) {
        if (!obj.hasOwnProperty(prop)) {
            continue;
        }

        if (obj[prop] == undefined)
            continue;

        xml += "<" + prop + ">";
        if (typeof obj[prop] == "object")
            xml += this.objectToXml(new Object(obj[prop]));
        else
            xml += obj[prop];

        xml+="</" + prop + ">";
        
    }

    return xml;
  }
}
