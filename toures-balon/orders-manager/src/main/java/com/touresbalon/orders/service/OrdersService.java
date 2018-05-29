package com.touresbalon.orders.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.touresbalon.common.service.CommonServiceContract;
import com.touresbalon.entities.orders.Reserva;
import com.touresbalon.entities.orders.SaleOrder;
import com.touresbalon.orders.dao.ReservaRepository;

@Service
@Transactional("transactionManagerJPA")
public class OrdersService extends CommonServiceContract<SaleOrder> {

	@Autowired
	private ReservaRepository reservaRepository;

	@Override
	public SaleOrder postSave(SaleOrder object) {
		if (object != null) {
			for(Reserva reserva:object.getReservas()) {
				reserva.setOrden(object);
				reservaRepository.save(reserva);
			}			
		}
		return object;
	}

	@Override
	public Boolean validate(SaleOrder object) {
		return true;
	}

	@Override
	public boolean deleteAssociatedObjects(SaleOrder object) {
		if (object != null) {
			for(Reserva reserva:object.getReservas()) {
				reservaRepository.delete(reserva);
			}			
		}
		return Boolean.TRUE;
	}

	@Override
	public SaleOrder removeChild(SaleOrder object, Long idChild) {
		// TODO Auto-generated method stub
		return null;
	}

}
