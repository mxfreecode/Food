package com.foodorderingapp.java.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.foodorderingapp.java.dto.UserRequestDTO;
import com.foodorderingapp.java.entity.Address;
import com.foodorderingapp.java.entity.User;
import com.foodorderingapp.java.repo.UserRepo;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {
    @Mock
    UserRepo userRepo; //Mock object
    
    @InjectMocks
    UserServiceImpl userServiceImpl; //Real object whit mock dependency objects
    
    UserRequestDTO userRequestDTO;
    
    User user;
    
    @BeforeEach
    public void setup() {
        userRequestDTO = new UserRequestDTO();
        userRequestDTO.setUsername("Diana Rodriguez");
        userRequestDTO.setPassword("1234");
        userRequestDTO.setEmail("diana@gmail.com");
        userRequestDTO.setPhoneNo("4795994");
        
        Address address = new Address();
        address.setCity("Los Angeles");
        address.setPincode("34566");
        address.setStreet("Av. Linkin");
        
        user=new User();
        user.setUserId(2);
        user.setAddressList(List.of(address));
    }
    
    @Test
    @DisplayName("save user details: positive")
    public void saveUserTest() {
        
        when(userRepo.save(any(User.class))).thenAnswer(i -> {
            User user = i.getArgument(0);
            user.setUserId(2);
            return user;
        });
        
        User userResult = userServiceImpl.saveUser(userRequestDTO);
        assertNotNull(userResult);
        assertEquals(2, userResult.getUserId());
        assertEquals("Diana Rodriguez", userResult.getUsername());
    }

 

    @Test
    @DisplayName("save user details: negative")
    public void saveUserTest1() {
        when(userRepo.findById(2)).thenReturn(Optional.empty());
        
        assertThrows(IllegalArgumentException.class, () -> userServiceImpl.saveUser(userRequestDTO));
    }
}
