package com.crud.demo.service;

import com.crud.demo.dto.UserDto;
import com.crud.demo.model.User;
import com.crud.demo.repository.UserRepository;

import java.util.List;

public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String createUser(UserDto userDto) throws Exception {
        if(userDto!= null){
            User user = new User();
            user.setUserName(userDto.getUserName());
            user.setUserId(userDto.getUserId());
            userRepository.save(user);
        }
        else{
            throw new Exception("User can`t be Empty");
        }
        return "User Created Succesfully!";
    }

    @Override
    public List<User> getAllUser() {
        List<User> userList = userRepository.findAll();
        return userList;
    }

    @Override
    public Long deleteUser(Long id) {
        userRepository.deleteById(id);
        return id;
    }
}
