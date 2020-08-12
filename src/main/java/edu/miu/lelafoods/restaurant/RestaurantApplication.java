package edu.miu.lelafoods.restaurant;

import edu.miu.lelafoods.restaurant.domain.Address;
import edu.miu.lelafoods.restaurant.domain.Food;
import edu.miu.lelafoods.restaurant.domain.Restaurant;
import edu.miu.lelafoods.restaurant.service.AddressService;
import edu.miu.lelafoods.restaurant.service.FoodService;
import edu.miu.lelafoods.restaurant.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@SpringBootApplication
@EnableEurekaClient
public class RestaurantApplication implements CommandLineRunner {

    @Autowired
    FoodService foodService;

    @Autowired
    AddressService addressService;

    @Autowired
    RestaurantService restaurantService;

    public static void main(String[] args) {
        SpringApplication.run(RestaurantApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Food food = new Food();
        food.setName("Doro");
        food.setPrice(23.5);
        food.setDescription("Delicious Food");

        Address address = new Address();
        address.setCity("Fairfield");
        address.setStreet("1000 N");
        address.setPostalCode("52557");
        address.setCountry("USA");

        List<Food> foodList = new ArrayList<Food>();
        foodList.add(food);

        List<Address> addressList = new ArrayList<Address>();
        addressList.add(address);
        Restaurant restaurant = new Restaurant("Anbessa Restaurant", addressList,foodList);

        restaurantService.save(restaurant);

    }
}
