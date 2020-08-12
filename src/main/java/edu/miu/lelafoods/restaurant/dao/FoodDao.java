package edu.miu.lelafoods.restaurant.dao;

import edu.miu.lelafoods.restaurant.domain.Food;

public interface FoodDao extends GenericDao<Food>{
    public Food findByFoodName(String name);
}
