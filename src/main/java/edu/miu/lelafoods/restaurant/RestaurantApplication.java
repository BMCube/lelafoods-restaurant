package edu.miu.lelafoods.restaurant;

import edu.miu.lelafoods.restaurant.domain.Food;
import edu.miu.lelafoods.restaurant.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RestaurantApplication implements CommandLineRunner {

    @Autowired
    FoodService foodService;

    public static void main(String[] args) {
        SpringApplication.run(RestaurantApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Food food = new Food();
        food.setName("Doro");
        food.setPrice(23.5);
        food.setDescription("Delicious Food");
        foodService.save(food);

    }
}
