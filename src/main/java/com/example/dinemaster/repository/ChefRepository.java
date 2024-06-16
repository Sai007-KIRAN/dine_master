package com.example.dinemaster.repository;

import java.util.ArrayList;
import org.springframework.stereotype.Repository;
import com.example.dinemaster.model.Chef;
import com.example.dinemaster.model.Restaurant;

// Write your code here
@Repository
public interface ChefRepository {
    ArrayList<Chef> allChef();

    Chef eachChef(int id);

    Chef addChef(Chef chef);

    Chef updateChef(int id, Chef chef);

    void deleteChef(int id);

    Restaurant getRestaurant(int id);
}