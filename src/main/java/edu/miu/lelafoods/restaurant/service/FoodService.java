package edu.miu.lelafoods.restaurant.service;

import edu.miu.lelafoods.restaurant.domain.Food;

import java.util.List;

public interface FoodService {

    public void save(Food food);
    //public void update(Food food);
    public List<Food> findAll();
    public void deleteById(Long id);
    public Food findByFoodName(String name);
    public Food findById(Long id);
}
