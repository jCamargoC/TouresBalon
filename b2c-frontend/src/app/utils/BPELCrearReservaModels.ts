
export interface reservaInput{
    idReserva?:number;
    valorReserva?:number;
    fechaReserva?:string;
    estadoReserva?:string;
    persona?:persona;
    vuelo?:vuelo;
    boletas?:boletas;
    hospedaje?:hospedaje;
    transporte?:transporte
}

export interface persona{
    nombre?:string;
    apellido?:string;
    tipoDoc?:string;
    nroDoc?:string;
    correo?:string;
    genero?:string;
    titular?:boolean;
    nroTelefono?:string;
    tarjeta?:tarjeta;
    tipoCliente?:string;
    idCliente?:string;
}

export interface vuelo{
    idReserva?:number;
    silla?:string;
    nroVuelo?: string;
    origen?:string;
    destino?:string;
    fechaInicio?:string;
    fechaFin?:string;
    puertaEmbarque?:string;
    grupo?:string;
    hayVuelo?:boolean;
    empresa?:string;    
}

export interface boletas{
    tipoEvento?:string;
    lugar?: string;
    sector?:string;
    fila?: string;
    silla?: string;
    grada?: string;
    idBoleta?: number;
    fecha?:string;
    hora?:string;
    valor?:number;
    hayEvento?:boolean;
    empresa?:string;
    persona?:persona;
}

export interface hospedaje{
    idReserva?: number;
    habitacion?:string;
    hotel?: string;
    tipoHabitacion?: string;
    estadoReserva?: string;
    fechaReserva?: string;
    fechaIngreso?: string;
    fechaSalida?:string;
    nroHabitaciones?:number;
    cantidadPersonas?:number;
    hayHospedaje?:boolean;
    empresa?:string;
}

export interface transporte{
    idReserva: number;
    fechaInicio: string;
    fechaFin:string;
    origen: string;
    destino: string;
    puestos: string;
    hayTransporte:boolean;
    empresa: string;
}

export interface tarjeta{
    franquicia: string;
    nroTarjeta: string;
    fechaVencimiento: Date;
    membresia: string;
    codigoSeguridad: string;
}

export interface ReservaOutput{
    response:reservas;
}

export interface reservas{
    respuesta:string;
    estado:string;
    codigo:string;
    idReservaPadre?:reserva;
    idReservaHospedaje?:reserva;
    idReservaTransporte?:reserva;
    idReservaEspectaculo?:reserva;
    idReservaVuelo?:reserva;
}

export interface reserva{
    idReserva:string;
    empresa:string;
}

export interface CancelInput{
    input:input;
}

export interface input{
    respuesta?:string;
    estado?:string;
    codigo?:string;
    idReservaPadre?:string;
    idReservaHospedaje?:string;
    idReservaTransporte?:string;
    idReservaEspectaculo?:string;
    idReservaVuelo?:string;
}

export interface BpelCrearOrderResponse{
    messageGenerationTime:Date,
    payload:ReservaOutput;
}