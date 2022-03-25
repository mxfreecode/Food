package com.foodorderingapp.java.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.foodorderingapp.java.dto.UserRequestDTO;
import com.foodorderingapp.java.service.UserService;

@WebMvcTest(UserController.class)
public class UserControllerTest {
    
    @MockBean
    UserService userservice;
    
    @Autowired
    MockMvc mockMvc;
    
    UserRequestDTO userRequestDTO;
    
    @BeforeEach
    public void setup() {
        userRequestDTO = new UserRequestDTO();
        userRequestDTO.setUsername("Diana Rodriguez");
        userRequestDTO.setPassword("1234");
        userRequestDTO.setEmail("diana@gmail.com");
        userRequestDTO.setPhoneNo("4795994");
    }
    
    @Test
    public void saveUserTest() throws Exception{
        mockMvc.perform(post("/user")
                .content(asJsonString(userRequestDTO))
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isAccepted())
        .andExpect(jsonPath("$.message").value("User Saved Success"))
        .andExpect(jsonPath("$.statusCode").value(200));
    }

 

    private String asJsonString(UserRequestDTO userRequestDTO2) {
        try {
            return new ObjectMapper().writeValueAsString(userRequestDTO);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
