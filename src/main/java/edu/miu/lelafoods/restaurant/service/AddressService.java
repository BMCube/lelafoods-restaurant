package edu.miu.lelafoods.restaurant.service;

import edu.miu.lelafoods.restaurant.domain.Address;

import java.util.List;

public interface AddressService {

    public void save(Address address);
    public List<Address> findAll();
    public void deleteById(Long id);
    public Address findById(Long id);
    public Address findByAddressCity(String city);
    public void update(Address address);

}
