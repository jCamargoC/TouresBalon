export interface Order{
    id:number;
    fecha:string;
    valor:number;
    estado:string;
    idCliente:number;
    idProducto:number;
    idReserva:string;
    reservaEspectaculo?:Reserva;
    reservaHospedaje?:Reserva;
    reservaVuelo?:Reserva;
    reservaTransporte?:Reserva;
}

export interface Reserva{
    id:number;
    empresa:string;
    idReserva:string;
    orderId:number;
    tiporeserva:string; 
}