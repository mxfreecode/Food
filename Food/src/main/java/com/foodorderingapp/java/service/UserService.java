package com.foodorderingapp.java.service;

import javax.validation.Valid;

import com.foodorderingapp.java.dto.LoginRequestDTO;
import com.foodorderingapp.java.dto.ResponseDTO;
import com.foodorderingapp.java.dto.UserRequestDTO;
import com.foodorderingapp.java.entity.User;

public interface UserService {

	User saveUser(UserRequestDTO userRequestDTO);

	ResponseDTO login(@Valid LoginRequestDTO loginRequestDTO);

}
