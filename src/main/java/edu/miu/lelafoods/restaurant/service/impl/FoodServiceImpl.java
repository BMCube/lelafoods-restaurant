package edu.miu.lelafoods.restaurant.service.impl;


import edu.miu.lelafoods.restaurant.dao.FoodDao;
import edu.miu.lelafoods.restaurant.domain.Food;
import edu.miu.lelafoods.restaurant.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class FoodServiceImpl implements FoodService {



    @Autowired
    private FoodDao foodDao;



    @Override
    public void save(Food food) {
        foodDao.save(food);

    }

    @Override
    public void update(Food food) {

        foodDao.update(food);

    }

    @Override
    public List<Food> findAll() {
        return foodDao.findAll();
    }

    @Override
    public void deleteById(Long id) {
        foodDao.deleteById(id);

    }

    @Override
    public Food findByFoodName(String name) {
        return foodDao.findByFoodName(name);
    }

    @Override
    public Food findById(Long id) {
        return foodDao.findOne(id);
    }
}
