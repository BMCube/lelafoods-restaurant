package edu.miu.lelafoods.restaurant.service;

import edu.miu.lelafoods.restaurant.domain.Restaurant;
import edu.miu.lelafoods.restaurant.dto.CartDto;

import java.util.List;

public interface RestaurantService {

    public void save(Restaurant restaurant);
    public List<Restaurant> findRestaurant();
    public void deleteById(Long id);
    public Restaurant findByRestaurantName(String name);
    public Restaurant findById(Long id);
    public void getSavedCart();
}
