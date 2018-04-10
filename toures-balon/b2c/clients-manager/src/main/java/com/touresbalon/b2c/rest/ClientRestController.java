package com.touresbalon.b2c.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
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
import com.touresbalon.entities.clients.Client;

@RestController
@RequestMapping("/client")
@PropertySources({@PropertySource("classpath:application.properties")})
public class ClientRestController extends ControllerBaseContract {
	
	@Autowired
	private CommonServiceContract<Client> clientService;
	
	
	@CrossOrigin
	@RequestMapping(value="/", method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<CommonResponse> create(@RequestBody Client client) {
		Client clientCreated=clientService.saveObject(client);
		return ResponseFactory.buildResponse(clientCreated);
	}
	
	@CrossOrigin(allowCredentials="true",origins= {"${cors.origins}"})
	@RequestMapping(value="/", method=RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<CommonResponse> update(@RequestBody Client client) {
		Client clientCreated=clientService.saveObject(client);
		return ResponseFactory.buildResponse(clientCreated);
	}
	
	@CrossOrigin(allowCredentials="true",origins="${cors.origins}")
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<CommonResponse> delete(@PathVariable Long id) {
		Boolean response=clientService.delete(id);
		return ResponseFactory.buildResponse(response);
	}
	
	@CrossOrigin(allowCredentials="true",origins="${cors.origins}")
	@RequestMapping(value="/{id}", method=RequestMethod.GET,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<CommonResponse> getOne(@PathVariable Long id) {
		Client response=clientService.findOne(id);
		return ResponseFactory.buildResponse(response);
	}
	
	@CrossOrigin(allowCredentials="true",origins="${cors.origins}")
	@RequestMapping(value="/email/", method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<CommonResponse> getOneByEmail(@RequestBody String email) {
		Client response=clientService.findByAttribute("email", email);
		return ResponseFactory.buildResponse(response);
	}
	
	@CrossOrigin
	@RequestMapping(value="/", method=RequestMethod.GET,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<CommonResponse> getAll() {
		List<Client> response=clientService.findAll();
		for (Client client : response) {
			client.setAddresses(null);
		}
		return ResponseFactory.buildResponse(response);
	}
}
