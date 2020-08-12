package edu.miu.lelafoods.restaurant.dao.impl;

import edu.miu.lelafoods.restaurant.dao.RestaurantDao;
import edu.miu.lelafoods.restaurant.domain.Restaurant;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

@Repository
public class RestaurantDaoImpl extends GenericDaoImpl<Restaurant> implements RestaurantDao {
    public RestaurantDaoImpl(){
        super.setDaoType(Restaurant.class);
    }
    @Override
    public Restaurant findByRestaurantName(String name) {
        Query query = entityManager.
                createQuery("select r from Restaurant r where r.name =:name");
        return (Restaurant)query.setParameter("name", name);
    }
}
