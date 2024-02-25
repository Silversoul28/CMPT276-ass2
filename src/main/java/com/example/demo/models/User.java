package com.example.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;
    private String name;
    private int weight;
    private int height;
    private int gpa;
    private String colour;
    public User() { 
    }
    public User(String name, int weight, int height, int gpa, String colour) {
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.gpa = gpa;
        this.colour = colour;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    

    public void setWeight(int weight) {
        this.weight = weight;
    }
    public int getWeight() {
        return weight;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public int getHeight() {
        return height;
    }
    public int getGpa() {
        return gpa;
    }
    public void setGpa(int gpa) {
        this.gpa = gpa;
    }
    public String getColour() {
        return colour;
    }
    public void setColour(String colour) {
        this.colour = colour;
    }
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
    // public int getSize() {
    //     return size;
    // }

    // public void setSize(int size) {
    //     this.size = size;
    // }


    
}