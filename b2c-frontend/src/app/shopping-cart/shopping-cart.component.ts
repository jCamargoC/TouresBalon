import { Component, OnInit, Inject } from '@angular/core';
import { LOCAL_STORAGE, WebStorageService } from 'angular-webstorage-service';
import { Router } from '@angular/router';
import { ProductService } from '../services/product.service';
import { ShoppingCartService } from '../services/shopping-cart.service';
import { Producto, Espectaculo } from '../utils/ProductsModels';
import { ShoppingCart, ShoppingCartResponse } from '../utils/ShoppingCartModels';
import { reservaInput,persona,boletas,hospedaje,transporte,vuelo } from '../utils/BPELCrearReservaModels';
@Component({
  selector: 'app-shopping-cart',
  providers: [ProductService, ShoppingCartService],
  templateUrl: './shopping-cart.component.html',
  styleUrls: ['./shopping-cart.component.scss']
})
export class ShoppingCartComponent implements OnInit {

  products: Producto[] = [];
  productMap = {};
  shoppingCart: ShoppingCart = this.storage.get("currentCart");
  isLoadingResults = false;
  client=this.storage.get("user");
  persona:persona;
  constructor(private productService: ProductService, private shoppingCartService: ShoppingCartService, @Inject(LOCAL_STORAGE) private storage: WebStorageService, private router: Router) { }

  ngOnInit() {
    if(this.client){
      this.persona={
        nombre:this.client.names,
        apellido:this.client.lastNames,
        idCliente:this.client.id,
        tipoDoc:"CC",
        nroDoc:"123456789",
        correo:this.client.email,
        tipoCliente:"DORADO"
      }
    }
    if (this.shoppingCart) {
      this.shoppingCartService.getShoppingCartById(this.shoppingCart.id).subscribe(data => {
        this.shoppingCart = data['payload'];
        this.storage.set("currentCart", this.shoppingCart);
        for (let i = 0; i < this.shoppingCart.items.length; i++) {
          const item = this.shoppingCart.items[i];
          this.productService.getOneProduct(item.productId).subscribe(data => {
            this.productMap[item.productId] = item.quantity;
            this.products.push(data);

          });
        }

      });

    } else {
      var user = this.storage.get("user");
      if (user) {
        this.shoppingCartService.getShoppingCartByClient(user.id).subscribe(data => {
          if (data['payload']) {
            this.shoppingCart = data['payload'];
            this.storage.set("currentCart", this.shoppingCart);
            for (let i = 0; i < this.shoppingCart.items.length; i++) {
              const item = this.shoppingCart.items[i];
              this.productService.getOneProduct(item.productId).subscribe(data => {
                this.productMap[item.productId] = item.quantity;
                this.products.push(data);

              });
            }
          }
        });
      }
    }
  }

  calculateCost(product: Producto) {
    var cost: number = 0;
    if (product.lodging) {
      cost += product.lodging.lodgingCosto;
    }
    if (product.transporte) {
      cost += product.transporte.transporteCosto;
    }
    if (product.espectaculo) {
      cost += product.espectaculo.espectaculoCosto;
    }
    return cost * this.productMap[product.productoId];
  }

  removeUnit(product: Producto) {
    this.isLoadingResults = true;
    var quantity = this.productMap[product.productoId];
    if (quantity === 1) {
      var itemId = this.removeShoppingCartItem(product.productoId);
      this.shoppingCartService.removeItem(this.shoppingCart, itemId).subscribe(data => {
        this.storage.set("currentCart", data['payload']);
        this.isLoadingResults = false;
        this.removeProduct(product.productoId);
      });
    } else {
      this.productMap[product.productoId]--;
      this.setQuantityFromShoppingCartItem(product.productoId, quantity - 1);
      var client = this.storage.get('user');
      this.shoppingCart.client = client ? client.id : null;
      this.shoppingCartService.updateShoppingCart(this.shoppingCart).subscribe(data => {
        this.storage.set("currentCart", data['payload']);
        this.isLoadingResults = false;
      });
    }

  }
  addUnit(product: Producto) {
    this.isLoadingResults = true;
    this.productMap[product.productoId] += 1;
    this.setQuantityFromShoppingCartItem(product.productoId, this.productMap[product.productoId]);
    this.shoppingCartService.updateShoppingCart(this.shoppingCart).subscribe(data => {
      this.storage.set("currentCart", data['payload']);
      this.isLoadingResults = false;
    });
  }

  setQuantityFromShoppingCartItem(productId: number, quantity: number) {
    for (let i = 0; i < this.shoppingCart.items.length; i++) {
      const item = this.shoppingCart.items[i];
      if (item.productId === productId) {
        this.shoppingCart.items[i].quantity = quantity
        break;
      }
    }
  }

  removeProduct(productId: number) {
    var idx = -1;
    for (let i = 0; i < this.products.length; i++) {
      const item = this.products[i];
      if (item.productoId === productId) {
        idx = i;
        break;
      }
    }
    if (idx !== -1) {
      this.products.splice(idx, 1);
    }
  }


  removeShoppingCartItem(productId: number) {
    var idx = -1;
    var id = 0;
    for (let i = 0; i < this.shoppingCart.items.length; i++) {
      const item = this.shoppingCart.items[i];
      if (item.productId === productId) {
        idx = i;
        id = item.id;
        break;
      }
    }
    if (idx !== -1) {
      this.shoppingCart.items.splice(idx, 1);
    }
    return id;
  }

  goBack() {
    this.router.navigateByUrl("/search");
  }

  calculateTotalCost() {
    var totalCost = 0;
    for (let i = 0; i < this.products.length; i++) {
      const item = this.products[i];
      totalCost += this.calculateCost(item);
    }
    return totalCost;
  }

  findProduct(id:number):Producto {
    var totalCost = 0;
    for (let i = 0; i < this.products.length; i++) {
      const item = this.products[i];
      if(item.productoId===id){
        return item;
      }
    }
    return null;
  }

  reserveOne(product:Producto,showMessage:boolean){
    const hospedaje:hospedaje={
      cantidadPersonas:1,
      empresa:"Hilton",
      fechaIngreso:"2018/07/02",
      fechaSalida:"2018/07/06",
      habitacion:"102",
      nroHabitaciones:1,
      tipoHabitacion:"PRESIDENCIAL"
    }
    const boletas:boletas={          
      empresa:"TuBoleta",
      fecha:"2018/07/03",
      fila:"a",
      grada:"12",
      hora:"12:00",
      lugar:product.espectaculo.espectaculoNombre,
      persona:this.persona,
      sector:"ORIENTAL",
      silla:"123",
      tipoEvento:product.espectaculo.espectaculoDescripcion,
      valor:product.espectaculo.espectaculoCosto
    }
    const vuelo:vuelo={
      destino:product.ciudadDestino.ciudadNombre,
      empresa:"Avianca",
      fechaInicio:product.productoDepartureDate.toString(),
      fechaFin:product.productoArrivalDate.toString(),
      nroVuelo:product.transporte.transporteNombre,
      origen:product.ciudadOrigen.ciudadNombre,
      grupo:"G1",
      puertaEmbarque:"GATE01",
      silla:"123"
    }
    const reserva:reservaInput={
      valorReserva:this.calculateCost(product),
      persona:this.persona,
      boletas:boletas,
      hospedaje:hospedaje,
      vuelo:vuelo          
    }
    this.shoppingCartService.reserve(reserva).subscribe(response=>{
      if(showMessage){
        var itemId = this.removeShoppingCartItem(product.productoId);
        this.shoppingCartService.removeItem(this.shoppingCart, itemId).subscribe(data => {
          this.storage.set("currentCart", data['payload']);
          this.isLoadingResults = false;
          this.removeProduct(product.productoId);
          
            alert("Se han enviado las peticiones de reserva a las compañías respectivas. Por favor revise su correo más tarde para verificar el estado de su reserva");
          
        });
      }
    });
  }
  reserve(){
    if(this.client){
      
      for(var i=0;i<this.shoppingCart.items.length;i++){
        
        var item=this.shoppingCart.items[i];
        const product:Producto=this.findProduct(item.productId);
        this.reserveOne(product,false)
        this.removeShoppingCartItem(item.productId);
        this.removeProduct(item.productId);
      }
      alert("Se han enviado las peticiones de reserva a las compañías respectivas. Por favor revise su correo más tarde para verificar el estado de su reserva");
    }    
    
    
  }
}
