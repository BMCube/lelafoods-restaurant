package edu.miu.lelafoods.restaurant.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "food")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String name;

    @NotNull(message = "{Price.validation}")
    private Double price;

    @NotEmpty
    private String description;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Restaurant_food", joinColumns={@JoinColumn(name="Food_Id")},
            inverseJoinColumns={ @JoinColumn(name="Restaurant_Id")})
    List<Restaurant> restaurant;

    public Long getId() {
        return id;
    }

    public List<Restaurant> getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(List<Restaurant> restaurant) {
        this.restaurant = restaurant;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
