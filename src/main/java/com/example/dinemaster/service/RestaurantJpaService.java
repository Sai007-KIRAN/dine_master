package com.example.dinemaster.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

import com.example.dinemaster.model.Restaurant;
import com.example.dinemaster.repository.RestaurantRepository;
import com.example.dinemaster.repository.RestaurantJpaRepository;
// Write your code here

@Service
public class RestaurantJpaService implements RestaurantRepository {

    @Autowired
    private RestaurantJpaRepository rjr;

    @Override
    public ArrayList<Restaurant> allRestaurant() {
        List<Restaurant> allList = rjr.findAll();
        ArrayList<Restaurant> all = new ArrayList<>(allList);
        return all;
    }

    @Override
    public Restaurant each(int id) {
        try {
            Restaurant eachValue = rjr.findById(id).get();
            return eachValue;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Restaurant add(Restaurant restaurant) {
        rjr.save(restaurant);
        return restaurant;
    }

    @Override
    public Restaurant update(int id, Restaurant restaurant) {
        try {
            Restaurant updateR = rjr.findById(id).get();
            if (restaurant.getName() != null) {
                updateR.setName(restaurant.getName());
            }
            if (restaurant.getAddress() != null) {
                updateR.setAddress(restaurant.getAddress());
            }
            if (restaurant.getCuisineType() != null) {
                updateR.setCuisineType(restaurant.getCuisineType());
            }
            if (restaurant.getRating() >= 0) {
                updateR.setRating(restaurant.getRating());
            }
            rjr.save(updateR);
            return updateR;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void delete(int id) {
        try {
            rjr.deleteById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }
}