package com.touresbalon.orders.soap;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.touresbalon.entities.orders.SaleOrder;
import com.touresbalon.orders.CreateOrderRequest;
import com.touresbalon.orders.CreateOrderResponse;
import com.touresbalon.orders.service.OrdersService;

@Endpoint
public class OrdersEndpoint {
	private static final String NAMESPACE_URI = "http://www.touresbalon.com/orders";

	private static Long id = 0L;
	private static Long idpro = 0L;
	
	@Autowired
	private OrdersService ordersService;
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "createOrderRequest")
	@ResponsePayload
	public CreateOrderResponse createOrder(@RequestPayload CreateOrderRequest request) {
//		SaleOrder order = ordersService.saveObject(request.getSaleOrder());
		CreateOrderResponse response =new CreateOrderResponse(); 
		SaleOrder order2 = new SaleOrder();
		order2.setEstado("aprobada");
		 SimpleDateFormat sm = new SimpleDateFormat("dd/MM/yyyy");
		order2.setFecha(sm.format(new Date()));
		order2.setId(id++);
		order2.setIdCliente(request.getSaleOrder().getIdCliente());
		order2.setIdProducto(idpro++);
		response.setSaleOrder(order2);
		return response;
	}
}
