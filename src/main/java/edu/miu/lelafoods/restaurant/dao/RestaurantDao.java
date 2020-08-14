package edu.miu.lelafoods.restaurant.dao;

import edu.miu.lelafoods.restaurant.domain.Restaurant;

public interface RestaurantDao extends GenericDao<Restaurant> {

    public Restaurant findByRestaurantName(String name);
}
