package com.example.dinemaster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

import com.example.dinemaster.model.Restaurant;
import com.example.dinemaster.service.RestaurantJpaService;

// Write your code here
@RestController
public class RestaurantController {

    @Autowired
    private RestaurantJpaService rjs;

    @GetMapping("/restaurants")
    public ArrayList<Restaurant> allRestaurant() {
        return rjs.allRestaurant();
    }

    @GetMapping("/restaurants/{restaurantId}")
    public Restaurant each(@PathVariable("restaurantId") int id) {
        return rjs.each(id);
    }

    @PostMapping("/restaurants")
    public Restaurant add(@RequestBody Restaurant restaurant) {
        return rjs.add(restaurant);
    }

    @PutMapping("/restaurants/{restaurantId}")
    public Restaurant update(@PathVariable("restaurantId") int id, @RequestBody Restaurant restaurant) {
        return rjs.update(id, restaurant);
    }

    @DeleteMapping("/restaurants/{restaurantId}")
    public void delete(@PathVariable("restaurantId") int id) {
        rjs.delete(id);
    }
}