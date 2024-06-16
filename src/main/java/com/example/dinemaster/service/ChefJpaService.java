package com.example.dinemaster.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.ArrayList;
import java.util.List;

import com.example.dinemaster.model.Chef;
import com.example.dinemaster.model.Restaurant;
import com.example.dinemaster.repository.RestaurantJpaRepository;
import com.example.dinemaster.repository.ChefJpaRepository;
import com.example.dinemaster.repository.ChefRepository;
// Write your code here

@Service
public class ChefJpaService implements ChefRepository {

    @Autowired
    private ChefJpaRepository cjr;

    @Autowired
    private RestaurantJpaRepository rjr;

    @Override
    public ArrayList<Chef> allChef() {
        List<Chef> all = cjr.findAll();
        ArrayList<Chef> allArray = new ArrayList<>(all);
        return allArray;
    }

    @Override
    public Chef eachChef(int id) {
        try {
            Chef chef = cjr.findById(id).get();
            return chef;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Chef addChef(Chef chef) {
        Restaurant rest = chef.getRestaurant();
        int pId = rest.getId();
        try {
            Restaurant complete = rjr.findById(pId).get();
            chef.setRestaurant(complete);
            cjr.save(chef);
            return chef;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Chef updateChef(int id, Chef chef) {
        try {
            Chef update = cjr.findById(id).get();
            if (chef.getFirstName() != null) {
                update.setFirstName(chef.getFirstName());
            }
            if (chef.getLastName() != null) {
                update.setLastName(chef.getLastName());
            }
            if (chef.getExpertise() != null) {
                update.setExpertise(chef.getExpertise());
            }
            if (chef.getExperienceYears() >= 0) {
                update.setExperienceYears(chef.getExperienceYears());
            }
            if (chef.getRestaurant() != null) {
                Restaurant rest = chef.getRestaurant();
                int pId = rest.getId();
                Restaurant complete = rjr.findById(pId).get();
                chef.setRestaurant(complete);
            }
            cjr.save(update);
            return update;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteChef(int id) {
        try {
            cjr.deleteById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }

    @Override
    public Restaurant getRestaurant(int id) {
        try {
            Chef view = cjr.findById(id).get();
            return view.getRestaurant();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}