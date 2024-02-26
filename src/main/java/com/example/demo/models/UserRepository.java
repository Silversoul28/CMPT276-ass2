package com.example.demo.models;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.transaction.Transactional;

public interface UserRepository extends JpaRepository<User, Integer> {//same type as uid
    List<User> findByUid(int uid);
    List<User> deleteByUid(int uid);

   // List<User> findByNameAndPassword(String name, String password);
    //    @Transactional
    //    void deleteUserByUid(int uid);

}