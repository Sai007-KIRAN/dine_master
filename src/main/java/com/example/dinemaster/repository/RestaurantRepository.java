package com.example.dinemaster.repository;

import java.util.ArrayList;
import com.example.dinemaster.model.Restaurant;
import org.springframework.stereotype.Repository;

// Write your code here
@Repository
public interface RestaurantRepository {
    ArrayList<Restaurant> allRestaurant();

    Restaurant each(int id);

    Restaurant add(Restaurant restaurant);

    Restaurant update(int id, Restaurant restaurant);

    void delete(int id);
}