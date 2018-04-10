package com.touresbalon.b2c.services;

import java.util.List;

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
		List<Address> list = object.getAddresses();
		if (list != null && !list.isEmpty()) {
			for (int i=0;i<list.size();i++) {
				Address address =list.get(i);
				address.setClient(object);
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
		}else if(object.getId() != null) {
			List<Address> list = object.getAddresses();
			if (list != null && !list.isEmpty()) {
				for (Address address : list) {
					addressRepository.save(address);
				}
			}
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
