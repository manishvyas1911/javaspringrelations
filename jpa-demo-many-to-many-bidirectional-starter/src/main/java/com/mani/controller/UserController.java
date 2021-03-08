package com.mani.controller;

import com.mani.entity.User;
import com.mani.repository.UserRepository;
import com.mani.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
    UserService userService;

    @PostMapping("/create")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
    
    
    @GetMapping("/all")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }
    
    @GetMapping("/details/{id}")
    public User getUser(@PathVariable Long id) {
    	Optional<User> opUser = userService.getUserById(id);
    	
        if(opUser.isPresent()) {
            return opUser.get();
            }
        else {
        	return  null;
        	}
    }
    
  
    
    
    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(user, id);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }





}
