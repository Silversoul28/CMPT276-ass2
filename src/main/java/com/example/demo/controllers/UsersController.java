// package com.example.demo.controllers;

// //import java.util.ArrayList;
// import java.util.List;
// import java.util.Map;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;

// import com.example.demo.models.User;
// import com.example.demo.models.UserRepository;

// import jakarta.servlet.http.HttpServletResponse;


// //import org.springframework.web.bind.annotation.RequestBody;



// @Controller
// public class UsersController {

//     @Autowired
//     private UserRepository userRepo;

//     @GetMapping("/users/view")
//     public String getAllUsers(Model model){
//         System.out.println("Getting all users");
//         //TOD get all useres from database
//         //List<User> users = new ArrayList<>();
//         List<User> users = userRepo.findAll();
//         // users.add(new User("Brooklyn", "12345", 25));
//         // users.add(new User("aaa", "1111", 15));
//         // users.add(new User("bbb", "2222", 5));
//         // users.add(new User("ccc", "3333", 35));
//         //end of database call
//         model.addAttribute("us", users);
//         return "users/showAll";
//     }

//     @PostMapping("users/add")
//     public String addUser(@RequestParam Map<String, String> newUser, HttpServletResponse response) {
//         System.out.println("ADD user");
//         String newName = newUser.get("name");
//         String newPwd = newUser.get("password");
//         int newSize = Integer.parseInt(newUser.get("size"));
//         userRepo.save(new User(newName, newPwd, newSize));
//         response.setStatus(201);


//         // process POST request

//         return "users/addedUser";
//     }
    

// }

package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
        model.addAttribute("usss", users);
        return "redirect:/edit.html";
    }
    // @RequestMapping(value = "/users/{name}", method=RequestMethod.GET)
    // public String getUser(@RequestParam("name") String name, Model model){
    //     System.out.println("Getting user");
    //     // get all users from database
    //     List<User> users = userRepo.findByName(name);
    //     // end of database call
    //     model.addAttribute("us", users);
    //     return "users/Users";
    // }

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
    
    // @PostMapping("users/view")
    // public String redirect() {
    //     //TODO: process POST request
        
    //     return "users/Start";
    // }
    
}