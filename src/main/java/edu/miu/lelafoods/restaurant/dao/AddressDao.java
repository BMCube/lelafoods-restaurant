package edu.miu.lelafoods.restaurant.dao;

import edu.miu.lelafoods.restaurant.domain.Address;

public interface AddressDao extends GenericDao<Address>{

    public Address findByAddressCity(String city);
}
