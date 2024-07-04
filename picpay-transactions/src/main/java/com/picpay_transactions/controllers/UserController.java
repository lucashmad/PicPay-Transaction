package com.picpay_transactions.controllers;

import com.picpay_transactions.domain.user.User;
import com.picpay_transactions.dtos.UserDTO;
import com.picpay_transactions.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDTO userData){
        User userNew = userService.createUser(userData);
        return new ResponseEntity<>(userNew, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = this.userService.getAllUsers();
        return  ResponseEntity.ok().body(users);
    }
}
