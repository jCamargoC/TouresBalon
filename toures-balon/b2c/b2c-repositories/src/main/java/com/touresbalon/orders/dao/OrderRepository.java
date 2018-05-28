package com.touresbalon.orders.dao;

import java.util.List;

import com.touresbalon.common.spring.conf.hibernate.IBaseRepository;
import com.touresbalon.entities.orders.SaleOrder;

public interface OrderRepository extends IBaseRepository<SaleOrder, Long> {

	public List<SaleOrder> finByIdCliente(Long idCliente);
}
