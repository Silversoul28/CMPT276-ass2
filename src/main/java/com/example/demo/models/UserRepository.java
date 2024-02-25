package com.example.demo.models;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {//same type as uid
    List<User> findByName(String name);
   // List<User> findByNameAndPassword(String name, String password);


}