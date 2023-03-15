package com.crud.demo.controller;


import com.crud.demo.dto.UserDto;
import com.crud.demo.model.User;
import com.crud.demo.service.UserService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rest")
public class UserController {

    public static final String CREATE_USER = "/create/user";
    public static final String DELETE_USER = "/delete/user/{}";
    private static final String GET_ALL_USER = "/getAllUser";
    private UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = CREATE_USER)
    public ResponseEntity<String> createUser(@RequestBody UserDto userDto) throws Exception {
        try {
            return new ResponseEntity<>(userService.createUser(userDto), HttpStatusCode.valueOf(200));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping(value = DELETE_USER)
    public ResponseEntity<Long> deleteUser(@PathVariable("id") Long id){
        return new ResponseEntity<>(userService.deleteUser(id),HttpStatusCode.valueOf(200));
    }

    @GetMapping(value =  GET_ALL_USER)
    public ResponseEntity<List<User>> getAllUser(){
        return new ResponseEntity<>(userService.getAllUser(),HttpStatusCode.valueOf(200));
    }
}
