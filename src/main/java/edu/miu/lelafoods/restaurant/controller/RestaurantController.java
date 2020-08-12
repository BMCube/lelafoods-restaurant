package edu.miu.lelafoods.restaurant.controller;

import edu.miu.lelafoods.restaurant.domain.Restaurant;
import edu.miu.lelafoods.restaurant.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @GetMapping({""})
    public List<Restaurant> findAll(){
        List<Restaurant> restaurantList = restaurantService.findRestaurant();
        return restaurantList;
    }

    @GetMapping("{id}")
    public Restaurant findRestaurantById(@PathVariable("id") Long id){
        return restaurantService.findById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void addRestaurant(@RequestBody Restaurant restaurant){
        restaurantService.save(restaurant);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id")Long id){
        restaurantService.deleteById(id);
    }
}
