package org.cts.dao;

import org.cts.domain.Address;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AddressDaoImpl implements AddressDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void saveAddress(Address address) {
		sessionFactory.getCurrentSession().save(address);
	}

}
