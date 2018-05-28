import { Component, OnInit, Inject } from '@angular/core';
import { LOCAL_STORAGE, WebStorageService } from 'angular-webstorage-service';
import { Router } from '@angular/router';
import { Order } from '../utils/OrdersModels';
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
  productsMap;
  constructor(private notif: NotificationsService, private router: Router, @Inject(LOCAL_STORAGE) private storage: WebStorageService,private shoppingCartService:ShoppingCartService,private ordersService:OrdersService) { }

  ngOnInit() {
    var orderStored = this.storage.get("order");
    this.order = orderStored['order'];
    this.productsMap = orderStored['productsMap'];
    this.index = orderStored['index'];
  }

  goToOrders() {
    this.storage.remove("order");
    this.router.navigateByUrl("/orders")
  }

  cancelOrder() {
    
    if (confirm("¿Está seguro de cancelar esta orden?")) {
      const cancelInput:CancelInput={
        input:{
          idReservaPadre:this.order.idReserva,
          idReservaHospedaje:this.order.reservaHospedaje?this.order.reservaHospedaje.idReserva:null,
          idReservaEspectaculo :this.order.reservaEspectaculo?this.order.reservaEspectaculo.idReserva:null,
          idReservaTransporte:this.order.reservaTransporte?this.order.reservaTransporte.idReserva:null,
          idReservaVuelo:this.order.reservaVuelo?this.order.reservaVuelo.idReserva:null
        }
      }
      this.shoppingCartService.cancelReserve(cancelInput).subscribe(response=>{
        this.ordersService.updateState(this.order.id,"CANCELADA");
        this.notif.success(
          'Éxito',
          'Se ha enviado la cancelación a las respectivas empresas. Por favor verifique su correo en unos instantes para verificar el estado la operación',
          {
            timeOut: 3000,
            showProgressBar: true,
            pauseOnHover: false,
            clickToClose: true,
            maxLength: 50,
            position: ["top", "middle"]
          }
        );
        this.goToOrders();
      });
      
    }

  }

  calculatePrice(product:Producto){
    return product.lodging.lodgingCosto+product.transporte.transporteCosto+product.espectaculo.espectaculoId;    
  }

 
}
