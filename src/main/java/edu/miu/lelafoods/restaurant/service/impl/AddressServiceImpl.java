package edu.miu.lelafoods.restaurant.service.impl;

import edu.miu.lelafoods.restaurant.dao.AddressDao;
import edu.miu.lelafoods.restaurant.domain.Address;
import edu.miu.lelafoods.restaurant.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressDao addressDao;

    @Override
    public void save(Address address) {

        addressDao.save(address);

    }

    @Override
    public List<Address> findAll() {
        return addressDao.findAll();
    }

    @Override
    public void deleteById(Long id) {
        addressDao.deleteById(id);

    }

    @Override
    public Address findById(Long id) {
        return addressDao.findOne(id);

    }

    @Override
    public Address findByAddressCity(String city) {
        return addressDao.findByAddressCity(city);
    }
}
