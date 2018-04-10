package com.touresbalon.b2c.clients.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.touresbalon.entities.clients.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
