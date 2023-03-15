package com.crud.demo.service;

import com.crud.demo.dto.UserDto;
import com.crud.demo.model.User;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public interface UserService {

    public String createUser(UserDto user) throws Exception;
    public List<User> getAllUser();

    public Long deleteUser(Long id);

}
