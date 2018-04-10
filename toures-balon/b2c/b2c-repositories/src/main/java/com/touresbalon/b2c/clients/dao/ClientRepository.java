package com.touresbalon.b2c.clients.dao;

import com.touresbalon.common.spring.conf.hibernate.IBaseRepository;
import com.touresbalon.entities.clients.Client;


public interface ClientRepository extends IBaseRepository<Client, Long>{
	public Client findByEmail(String email);
}
