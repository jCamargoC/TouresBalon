package com.touresbalon.b2c.shoppingCart.dao;

import javax.transaction.Transactional;

import com.touresbalon.common.spring.conf.hibernate.IBaseRepository;
import com.touresbalon.entities.shoppingCart.ShoppingCart;

@Transactional
public interface ShoppingCartRepository extends IBaseRepository<ShoppingCart, Long>{

	public ShoppingCart findByClient(Long clientId);
}
