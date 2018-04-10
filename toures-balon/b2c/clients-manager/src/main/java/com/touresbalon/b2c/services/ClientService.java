package com.touresbalon.b2c.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.touresbalon.b2c.clients.dao.AddressRepository;
import com.touresbalon.common.BusinessException;
import com.touresbalon.common.ErrorsEnum;
import com.touresbalon.common.service.CommonServiceContract;
import com.touresbalon.entities.clients.Address;
import com.touresbalon.entities.clients.Client;

@Service
@Transactional("transactionManagerJPA")
public class ClientService extends CommonServiceContract<Client> {

	@Autowired
	private AddressRepository addressRepository;

	@Override
	public Client postSave(Client object) {
		if (object.getId() == null) {
			for (Address address : object.getAddresses()) {
				address.setClients(new ArrayList<Client>());
				address.getClients().add(object);
				addressRepository.save(address);
			}
		}
		return object;
	}

	@Override
	public Boolean validate(Client object) {
		Client existant = findByAttribute("email", object.getEmail());
		if (existant != null && object.getId() == null) {
			throw new BusinessException(ErrorsEnum.CLIENT_EXISTS);
		}
		return Boolean.TRUE;
	}

	@Override
	public boolean deleteAssociatedObjects(Client object) {
		return Boolean.TRUE;
	}

	@Override
	public Client removeChild(Client object, Long idChild) {
		// TODO Auto-generated method stub
		return null;
	}

}
