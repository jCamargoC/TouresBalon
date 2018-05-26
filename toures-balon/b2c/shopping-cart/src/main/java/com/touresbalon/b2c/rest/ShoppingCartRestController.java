package com.touresbalon.b2c.rest;

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

import com.touresbalon.b2c.dto.ReserveDTO;
import com.touresbalon.common.CommonResponse;
import com.touresbalon.common.ControllerBaseContract;
import com.touresbalon.common.ResponseFactory;
import com.touresbalon.common.service.CommonServiceContract;
import com.touresbalon.entities.shoppingCart.ShoppingCart;
import com.touresbalon.utils.SOAPInvoker;

@RestController
@RequestMapping("/shoppingcart")
public class ShoppingCartRestController extends ControllerBaseContract {
	
	@Autowired
	private CommonServiceContract<ShoppingCart> shoppingCartService;
	
	@CrossOrigin
	@RequestMapping(value="/", method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<CommonResponse> create(@RequestBody ShoppingCart ShoppingCart) {
		ShoppingCart shoppingCartCreated=shoppingCartService.saveObject(ShoppingCart);
		return ResponseFactory.buildResponse(shoppingCartCreated);
	}
	
	@CrossOrigin
	@RequestMapping(value="/", method=RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<CommonResponse> update(@RequestBody ShoppingCart ShoppingCart) {
		ShoppingCart shoppingCartCreated=shoppingCartService.saveObject(ShoppingCart);
		return ResponseFactory.buildResponse(shoppingCartCreated);
	}
	
	@CrossOrigin
	@RequestMapping(value="/item/{id}", method=RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<CommonResponse> removeItem(@RequestBody ShoppingCart ShoppingCart,@PathVariable("id")Long itemId) {
		ShoppingCart shoppingCartCreated=shoppingCartService.removeChild(ShoppingCart,itemId);
		return ResponseFactory.buildResponse(shoppingCartCreated);
	}
	
	@CrossOrigin
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<CommonResponse> delete(@PathVariable Long id) {
		Boolean response=shoppingCartService.delete(id);
		return ResponseFactory.buildResponse(response);
	}
	
	@CrossOrigin
	@RequestMapping(value="/{id}", method=RequestMethod.GET,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<CommonResponse> getOne(@PathVariable("id") Long id) {
		ShoppingCart response=shoppingCartService.findOne(id);
		return ResponseFactory.buildResponse(response);
	}
	
	@CrossOrigin
	@RequestMapping(value="client/{id}", method=RequestMethod.GET,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<CommonResponse> getByClient(@PathVariable("id") Long id) {
		ShoppingCart response=shoppingCartService.findByAttribute("client", id);
		return ResponseFactory.buildResponse(response);
	}
	
	@CrossOrigin
	@RequestMapping(value="/", method=RequestMethod.GET,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<CommonResponse> getAll() {
		List<ShoppingCart> response=shoppingCartService.findAll();
		for (ShoppingCart ShoppingCart : response) {
			ShoppingCart.setItems(null);
		}
		return ResponseFactory.buildResponse(response);
	}
	
	@CrossOrigin
	@RequestMapping(value="/reserve", method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<CommonResponse> reserve(@RequestBody ReserveDTO request) {
		SOAPInvoker.callSoapWebService(request.getUrl(), request.getAction(), request.getPayload());
		return ResponseFactory.buildResponse(Boolean.TRUE);
	}
}
