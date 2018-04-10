package com.touresbalon.b2c.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.touresbalon.b2c.shoppingCart.dao.ShoppingCartItemRepository;
import com.touresbalon.common.service.CommonServiceContract;
import com.touresbalon.entities.shoppingCart.ShoppingCart;
import com.touresbalon.entities.shoppingCart.ShoppingCartItem;

@Service
@Transactional("transactionManagerJPA")
public class ShoppingCartService extends CommonServiceContract<ShoppingCart> {

	@Autowired
	private ShoppingCartItemRepository shoppingCartItemRepository;

	@Override
	public ShoppingCart postSave(ShoppingCart object) {
		if(object.getItems()!=null && !object.getItems().isEmpty()) {
			for (ShoppingCartItem item : object.getItems()) {
				item.setShoppingCart(object);
				shoppingCartItemRepository.save(item);
			}
		}
		return object;
	}

	@Override
	public Boolean validate(ShoppingCart object) {
		if(object.getId()!=null) {
			if(object.getItems()!=null && !object.getItems().isEmpty()) {
				for (ShoppingCartItem item : object.getItems()) {
					item.setShoppingCart(object);
					shoppingCartItemRepository.save(item);
				}
			}
		}
		return Boolean.TRUE;
	}

	@Override
	public boolean deleteAssociatedObjects(ShoppingCart object) {		
		return Boolean.TRUE;
	}

	@Override
	public ShoppingCart removeChild(ShoppingCart object, Long idChild) {
		ShoppingCartItem cartItem=shoppingCartItemRepository.findById(idChild).get();
		object.getItems().remove(cartItem);
		shoppingCartItemRepository.delete(cartItem);
		
		return repository.save(object);
	}

}
