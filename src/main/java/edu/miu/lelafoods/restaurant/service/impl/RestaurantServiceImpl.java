package edu.miu.lelafoods.restaurant.service.impl;

import edu.miu.lelafoods.restaurant.dao.RestaurantDao;
import edu.miu.lelafoods.restaurant.domain.Restaurant;
import edu.miu.lelafoods.restaurant.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantDao restaurantDao;

    @Override
    public void save(Restaurant restaurant) {
        restaurantDao.save(restaurant);

    }

    @Override
    public List<Restaurant> findRestaurant() {
        return restaurantDao.findAll();
    }

    @Override
    public void deleteById(Long id) {
        restaurantDao.deleteById(id);

    }

    @Override
    public Restaurant findByRestaurantName(String name) {
        return restaurantDao.findByRestaurantName(name);
    }

    @Override
    public Restaurant findById(Long id) {
        return restaurantDao.findOne(id);
    }
}
