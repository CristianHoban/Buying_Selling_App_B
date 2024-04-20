package com.example.restservice.service;

import com.example.restservice.data.UserContract;
import com.example.restservice.model.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;


public class UserServiceTest {
    @Mock
    private UserContract userContract;
    private UserService userServiceImpl;
    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        userServiceImpl = new UserServiceImpl(userContract);
    }
    @Test
    public void createUserTest() {
        User user = new User(1, "Hoban", "Cristian", "hc@yahoo.com", "0000", "Strada strada", 200);
        Mockito.when(userContract.save(user)).thenReturn(user);
        User userResult = userServiceImpl.createUser(user);
        Mockito.verify(userContract).save(user);
        assertEquals(user, userResult);
    }
}
