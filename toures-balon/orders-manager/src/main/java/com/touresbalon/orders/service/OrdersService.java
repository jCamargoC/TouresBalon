package com.touresbalon.orders.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.touresbalon.common.service.CommonServiceContract;
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
			if (object.getReservaEspectaculo() != null) {
				object.getReservaEspectaculo().setOrden(object);
				reservaRepository.save(object.getReservaEspectaculo());
			}
			if (object.getReservaHospedaje() != null) {
				object.getReservaHospedaje().setOrden(object);
				reservaRepository.save(object.getReservaHospedaje());
			}
			if (object.getReservaTransporte() != null) {
				object.getReservaTransporte().setOrden(object);
				reservaRepository.save(object.getReservaTransporte());
			}
			if (object.getReservaVuelo() != null) {
				object.getReservaVuelo().setOrden(object);
				reservaRepository.save(object.getReservaVuelo());
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
			if (object.getReservaEspectaculo() != null) {				
				reservaRepository.delete(object.getReservaEspectaculo());
			}
			if (object.getReservaHospedaje() != null) {				
				reservaRepository.delete(object.getReservaHospedaje());
			}
			if (object.getReservaTransporte() != null) {				
				reservaRepository.delete(object.getReservaTransporte());
			}
			if (object.getReservaVuelo() != null) {				
				reservaRepository.delete(object.getReservaVuelo());
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
