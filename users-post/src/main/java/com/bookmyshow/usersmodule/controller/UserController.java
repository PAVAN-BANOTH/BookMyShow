package com.bookmyshow.usersmodule.controller;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bookmyshow.usersmodule.entity.User;
import com.bookmyshow.usersmodule.service.UserService;



@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> getAllUserRegistrations() {
        return userService.getAllUserRegistrations();
    }

    @GetMapping("/{id}")
    public User getUserRegistrationById(@PathVariable Long id) {
        return userService.getUserRegistrationById(id);
    }

    @PostMapping("/create-user")
    public User createUserRegistration(@RequestBody User user) {
        return userService.createUserRegistration(user);
    }
    @GetMapping("/sorting/{field}")
    public List<User> getUserWithSorting(@PathVariable String field) {
        return userService.findUserWithSorting(field);
    }
   @GetMapping("/pagination/{pageNo}/{recordCount}")
    public List<User> getAllUser(@PathVariable int pageNo,@PathVariable int recordCount) {
        return userService.getAllUser(pageNo, recordCount); 
    }
   @GetMapping("/getbyemail/{email}/{pageNo}/{recordCount}")
    public List<User> getByEmail(@PathVariable String email,@PathVariable int pageNo,@PathVariable int recordCount) {
        return userService.getByEmail(email, pageNo, recordCount);
    }
}   
