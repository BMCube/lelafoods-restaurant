package edu.miu.lelafoods.restaurant.dao.impl;


import edu.miu.lelafoods.restaurant.dao.AddressDao;
import edu.miu.lelafoods.restaurant.domain.Address;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

@Repository
public class AddressDaoImpl extends GenericDaoImpl<Address> implements AddressDao {
    public AddressDaoImpl(){
        super.setDaoType(Address.class);
    }


    @Override
    public Address findByAddressCity(String city) {
        Query query = entityManager
                .createQuery("select a from Address a where a.city =:city");
        return (Address) query.setParameter("city", city);
    }
}
