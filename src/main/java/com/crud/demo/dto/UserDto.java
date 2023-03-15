package com.crud.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDto {


    @JsonProperty("user_name")
    private String userName;

    @JsonProperty("user_id")
    private String userId;

    public UserDto(long id, String userName, String userId) {
        this.userName = userName;
        this.userId = userId;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                ", userName='" + userName + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
