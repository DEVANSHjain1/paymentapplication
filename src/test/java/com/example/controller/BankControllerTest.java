package com.example.controller;

import main.java.com.example.model.User;
import main.java.com.example.service.BankService;
import main.java.com.example.controller.BankController;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.math.BigDecimal;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BankControllerTest {

    @Mock
    private BankService bankService;

    @InjectMocks
    private BankController bankController;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRegisterUser_Success() {
        User user = new User();
        user.setUserName("testuser");
        user.setBalance((new BigDecimal("100.00")));

        when(bankService.registerUser(any(User.class))).thenReturn(user);

        User response = bankController.registerUser(user);

        //assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("testuser", response.getUserName());
        assertEquals((new BigDecimal("100.00")), response.getBalance());
        verify(bankService, times(1)).registerUser(any(User.class));
    }

    // Add more tests for other methods in BankController
}