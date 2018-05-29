import { Component, OnInit, Inject } from '@angular/core';
import { LOCAL_STORAGE, WebStorageService } from 'angular-webstorage-service';
import { Router } from '@angular/router';
import { Order, Reserva } from '../utils/OrdersModels';
import { NotificationsService } from 'angular2-notifications';
import { Producto } from '../utils/ProductsModels';
import { CancelInput } from '../utils/BPELCrearReservaModels';
import { ShoppingCartService } from '../services/shopping-cart.service';
import { OrdersService } from '../services/orders.service';

@Component({
  providers:[ShoppingCartService,OrdersService],
  selector: 'app-order-detail',
  templateUrl: './order-detail.component.html',
  styleUrls: ['./order-detail.component.scss']
})
export class OrderDetailComponent implements OnInit {
  order: Order = null;
  index: number = -1;
  reservasMap={};
  productsMap;
  canceled=false;
  constructor(private notif: NotificationsService, private router: Router, @Inject(LOCAL_STORAGE) private storage: WebStorageService,private shoppingCartService:ShoppingCartService,private ordersService:OrdersService) { }

  ngOnInit() {
    var orderStored = this.storage.get("order");
    this.order = orderStored['order'];
    this.productsMap = orderStored['productsMap'];
    this.index = orderStored['index'];
    if(this.order){
      for(var i=0;i<this.order.reservas.length;i++){
        var reserva:Reserva=this.order.reservas[i];
        this.reservasMap[reserva.tipoReserva]=reserva;
      }
    }
  }

  goToOrders() {
    
    this.storage.remove("order");
    this.storage.remove("orders");
    this.router.navigateByUrl("/")
  }

  cancelOrder() {
    
    if (confirm("¿Está seguro de cancelar esta orden?")) {
      const cancelInput:CancelInput={
        input:{
          codigo:"c123",
          estado:"EN CANCELACION",
          respuesta:"Cancelando",          
          idReservaPadre:"R12344",
          idReservaHospedaje:this.reservasMap["HOSPEDAJE"]?this.reservasMap["HOSPEDAJE"].idReserva:null,
          idReservaEspectaculo :this.reservasMap["ESPECTACULO"]?this.reservasMap["ESPECTACULO"].idReserva:null,
          idReservaTransporte:this.reservasMap["TRANSPORTE"]?this.reservasMap["TRANSPORTE"].idReserva:null,
          idReservaVuelo:this.reservasMap["VUELO"]?this.reservasMap["VUELO"].idReserva:null
        }
      }
      this.shoppingCartService.cancelReserve(cancelInput).subscribe(response=>{
        this.order.estado="CANCELADA";
        this.ordersService.updateState(this.order).subscribe(response=>{
          
        });
        this.notif.success(
          'Éxito',
          'Se ha cancelado la orden exitosamente',
          {
            timeOut: 3000,
            showProgressBar: true,
            pauseOnHover: false,
            clickToClose: true,
            maxLength: 50,
            position: ["top", "middle"]
          }
        );
        this.canceled=true;
        this.goToOrders();
      });
      
    }

  }

  calculatePrice(product:Producto){
    return product.lodging.lodgingCosto+product.transporte.transporteCosto+product.espectaculo.espectaculoId;    
  }

 
}
