
package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.User;
import com.example.demo.models.UserRepository;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class UsersController {  
    
    @Autowired
    private UserRepository userRepo;

    @GetMapping("/users/view")
    public String getAllUsers(Model model){
        System.out.println("Getting all users");
        // get all users from database
        List<User> users = userRepo.findAll();
        // end of database call
        model.addAttribute("us", users);
        return "users/Start";
    }

    @GetMapping("/users/{uid}")
    public String getUser(@PathVariable("uid") int uid, Model model){
        System.out.println("Getting user");
        // get all users from database
        List<User> users = userRepo.findByUid(uid);
        // end of database call
        model.addAttribute("uss", users);
        return "users/Users";
    }

    @Transactional
    @GetMapping("delete/{uid}")
    public String deleteUser(@PathVariable("uid") int uid){
       // List<User> user=userRepo.findByUid(uid);
        userRepo.deleteByUid(uid);

        return "redirect:/users/view";
    }

    @Transactional
    @GetMapping("edit/{uid}")
    public String editUser(@PathVariable("uid") int uid, Model model){
        List<User> users=userRepo.findByUid(uid);
        //userRepo.deleteByUid(uid);
     
        model.addAttribute("usss", users.get(0));
        return "/users/edit";
    }


    @PostMapping(value="/users/update/{uid}")
    public String updateUser(@PathVariable("uid") int uid, @RequestParam Map<String, String> user, HttpServletResponse response){
        List<User> users=userRepo.findByUid(uid);
        //userRepo.deleteByUid(uid);
        User userr = users.get(0);
        userr.setName(user.get("name"));
        userr.setWeight(Integer.parseInt(user.get("weight")));
        userr.setHeight(Integer.parseInt(user.get("height")));
        userr.setGpa(Integer.parseInt(user.get("gpa")));
        userr.setColour(user.get("colour"));

        userRepo.save(userr);
      //  model.addAttribute("user", userr);
        response.setStatus(201);
        return "redirect:/users/view";
    }

    @PostMapping("/users/add")
    public String addUser(@RequestParam Map<String, String> newuser, HttpServletResponse response){
        System.out.println("ADD user");
        String newName = newuser.get("name");
        int newWeight = Integer.parseInt(newuser.get("weight"));
        int newHeight = Integer.parseInt(newuser.get("height"));
        int newGpa = Integer.parseInt(newuser.get("gpa"));
        String newColour = newuser.get("colour");

        //userRepo.save(new User(newName,newPwd,3, 4, 2, "#000000"));
        userRepo.save(new User(newName,newWeight, newHeight, newGpa, newColour));
        response.setStatus(201);
        return "redirect:view";
    }
    
}