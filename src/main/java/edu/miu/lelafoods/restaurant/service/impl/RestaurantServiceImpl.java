package edu.miu.lelafoods.restaurant.service.impl;

import edu.miu.lelafoods.restaurant.dao.RestaurantDao;
import edu.miu.lelafoods.restaurant.domain.Restaurant;
import edu.miu.lelafoods.restaurant.dto.CartDto;
import edu.miu.lelafoods.restaurant.service.RestaurantService;
import edu.miu.lelafoods.restaurant.utils.ApplicationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantDao restaurantDao;

    @Autowired
    ApplicationProperties applicationProperties;

    RestTemplate restTemplate = new RestTemplate();

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

    @Override
    public void getSavedCart() {
//Read from save query and process the cart
// and store on deliver queue
    }
}
