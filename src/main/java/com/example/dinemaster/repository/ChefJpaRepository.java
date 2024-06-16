package com.example.dinemaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.dinemaster.model.Chef;
// Write your code here

@Repository
public interface ChefJpaRepository extends JpaRepository<Chef, Integer> {

}