package com.crud.demo.controller;


import com.crud.demo.dto.UserDto;
import com.crud.demo.model.User;
import com.crud.demo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

/*
* http://127.0.0.1:5500/ This Url will be FRONTEND URL
* */

@CrossOrigin(origins = "http://127.0.0.1:5500/")
@RestController
@RequestMapping(value = "/rest")
public class UserController {

    public static final String CREATE_USER = "/create/user";
    public static final String DELETE_USER = "/delete/user/{id}";
    private static final String GET_ALL_USER = "/getAllUser";
    private UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = CREATE_USER)
    @RolesAllowed("admin")
    public ResponseEntity<String> createUser(@RequestBody UserDto userDto) throws Exception {
        try {
            return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping(value = DELETE_USER)
    @RolesAllowed("admin")
    public ResponseEntity<Long> deleteUser(@PathVariable("id") Long id){
        return new ResponseEntity<>(userService.deleteUser(id),HttpStatus.OK);
    }

    @GetMapping(value =  GET_ALL_USER)
    @RolesAllowed("user")
    public ResponseEntity<List<User>> getAllUser(){
        return new ResponseEntity<>(userService.getAllUser(),HttpStatus.OK);
    }
}
