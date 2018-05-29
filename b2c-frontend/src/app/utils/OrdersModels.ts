export interface Order{
    id?:number;
    fecha?:string;
    valor:number;
    estado:string;
    idCliente:number;
    idProducto:number;
    idReserva:string;
    reservas?:Reserva[];
}

export interface Reserva{
    id?:number;
    empresa?:string;
    idReserva?:string;
    orderId?:number;
    tipoReserva?:string; 
}

export interface OrderResponse{
    messageGenerationTime:Date;
    payload:Order[];
}
