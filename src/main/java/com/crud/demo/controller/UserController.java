package com.crud.demo.controller;


import com.crud.demo.model.User;

import com.crud.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/signup")
    public String showSignUpForm(Model model) {
        model.addAttribute("user",new User());
        model.addAttribute("users",userRepository.findAll());
        return "index";
    }

    @PostMapping(value = "/addUser")
    public String addUser(@ModelAttribute User user){
        userRepository.save(user);
        return "redirect:/user/getUser";
    }

    @GetMapping("/getUser")
    public String getUsers(Model model){
        model.addAttribute("user",new User());
        model.addAttribute("users",userRepository.findAll());
        return "index";
    }

    @GetMapping("delete/{id}")
    public String deleteStudent(@PathVariable("id") long id, Model model) {
        try {
            User user = userRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
            userRepository.delete(user);

            model.addAttribute("user", new User());
            model.addAttribute("users", userRepository.findAll());
        }
        catch (IllegalArgumentException e){
            return "redirect:/user/signup";
        }
        return "index";
    }

}
