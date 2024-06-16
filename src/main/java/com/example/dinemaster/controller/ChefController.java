package com.example.dinemaster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

import com.example.dinemaster.model.Chef;
import com.example.dinemaster.model.Restaurant;
import com.example.dinemaster.service.ChefJpaService;
// Write your code here

@RestController
public class ChefController {
    @Autowired
    private ChefJpaService cjs;

    @GetMapping("/restaurants/chefs")
    public ArrayList<Chef> allChef() {
        return cjs.allChef();
    }

    @GetMapping("/restaurants/chefs/{chefId}")
    public Chef eachChef(@PathVariable("chefId") int id) {
        return cjs.eachChef(id);
    }

    @PostMapping("/restaurants/chefs")
    public Chef addChef(@RequestBody Chef chef) {
        return cjs.addChef(chef);
    }

    @PutMapping("/restaurants/chefs/{chefId}")
    public Chef updateChef(@PathVariable("chefId") int id, @RequestBody Chef chef) {
        return cjs.updateChef(id, chef);
    }

    @DeleteMapping("/restaurants/chefs/{chefId}")
    public void deleteChef(@PathVariable("chefId") int id) {
        cjs.deleteChef(id);
    }

    @GetMapping("/chefs/{chefId}/restaurant")
    public Restaurant getRestaurant(@PathVariable("chefId") int id) {
        return cjs.getRestaurant(id);
    }
}