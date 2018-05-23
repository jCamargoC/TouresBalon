package com.touresbalon.orders.soap;

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

	@Autowired
	private OrdersService ordersService;
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "createOrderRequest")
	@ResponsePayload
	public CreateOrderResponse createOrder(@RequestPayload CreateOrderRequest request) {
		SaleOrder order = ordersService.saveObject(request.getSaleOrder());
		CreateOrderResponse response =new CreateOrderResponse(); 
		response.setSaleOrder(order);
		return response;
	}
}
