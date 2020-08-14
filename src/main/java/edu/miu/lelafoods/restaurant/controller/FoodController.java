package edu.miu.lelafoods.restaurant.controller;

import edu.miu.lelafoods.restaurant.domain.Food;
import edu.miu.lelafoods.restaurant.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foods")
public class FoodController {

    @Autowired
    FoodService foodService;

    @GetMapping({""})
    public List<Food> findAll(){
        List<Food> foodList =  foodService.findAll();
        return foodList;
    }

    @GetMapping("{id}")
    public Food findFoodById(@PathVariable("id")Long id){
        return foodService.findById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void  addFood(@RequestBody Food food){
        foodService.save(food);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Food> updateFood(@PathVariable("id") Long foodId, @RequestBody Food food){
        Food isExist = foodService.findById(foodId);
        if (isExist == null) {
            return new ResponseEntity<Food>(HttpStatus.NOT_FOUND);
        } else if (food == null) {
            return new ResponseEntity<Food>(HttpStatus.BAD_REQUEST);
        }
        foodService.update(food);

        return new ResponseEntity<Food>(food, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id){
        foodService.deleteById(id);
    }
}
