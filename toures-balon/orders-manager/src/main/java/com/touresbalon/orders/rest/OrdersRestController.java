package com.touresbalon.orders.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.touresbalon.common.CommonResponse;
import com.touresbalon.common.ControllerBaseContract;
import com.touresbalon.common.ResponseFactory;
import com.touresbalon.common.service.CommonServiceContract;
import com.touresbalon.entities.orders.SaleOrder;

@RestController
@RequestMapping("/orders")

public class OrdersRestController extends ControllerBaseContract {
	
	@Autowired
	private CommonServiceContract<SaleOrder> ordersService;
	
	
	@CrossOrigin
	@RequestMapping(value="/", method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<CommonResponse> create(@RequestBody SaleOrder order) {
		SaleOrder response=ordersService.saveObject(order);
		return ResponseFactory.buildResponse(response);
	}
	
	@CrossOrigin
	@RequestMapping(value="/", method=RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<CommonResponse> update(@RequestBody SaleOrder order) {
		SaleOrder response=ordersService.saveObject(order);
		return ResponseFactory.buildResponse(response);
	}
	
	
	
	@CrossOrigin
	@RequestMapping(value="client/{id}", method=RequestMethod.GET,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<CommonResponse> getByClient(@PathVariable Long id) {
		List<SaleOrder> response=ordersService.findByAttributeList("idCliente", id);
		return ResponseFactory.buildResponse(response);
	}
	
	@CrossOrigin
	@RequestMapping(value="{id}", method=RequestMethod.GET,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<CommonResponse> findOne(@PathVariable Long id) {
		SaleOrder response=ordersService.findOne(id);
		return ResponseFactory.buildResponse(response);
	}	
	
}
