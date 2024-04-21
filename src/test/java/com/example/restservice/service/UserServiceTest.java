package com.example.restservice.service;

import com.example.restservice.data.UserContract;
import com.example.restservice.model.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;

/**
 * Unit tests for the UserService class.
 */
public class UserServiceTest {
    @Mock
    private UserContract userContract;
    private UserService userServiceImpl;
    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        userServiceImpl = new UserServiceImpl(userContract);
    }

    /**
     * Test for creating a user.
     * Verifies that the user is saved correctly.
     */
    @Test
    public void createUserTest() {
        User user = new User(1, "Hoban", "Cristian", "hc@yahoo.com", "0000", "Strada strada", 200);
        Mockito.when(userContract.save(user)).thenReturn(user);
        User userResult = userServiceImpl.createUser(user);
        Mockito.verify(userContract).save(user);
        assertEquals(user, userResult);
    }

    /**
     * Test for retrieving a user by its ID.
     * Verifies that the correct user is returned when searching by ID.
     */
    @Test
    public void getUserByIdTest() {

        User expectedUser = new User(1, "Hoban", "Cristian", "hc@yahoo.com", "0000", "Strada strada", 200);

        Mockito.when(userContract.findById(1L)).thenReturn(Optional.of(expectedUser));

        Optional<User> actualUser = userServiceImpl.getUserById(1L);

        Mockito.verify(userContract).findById(1L);

        assertEquals(Optional.of(expectedUser), actualUser);
    }

    /**
     * Test for updating a user.
     * Verifies that the user is updated correctly when it exists.
     */
    @Test
    public void updateUserTest1() {
        User newUser = new User(1L, "Hoban", "Cristian", "hc@yahoo.com", "0000", "Strada strada", 200);
        Mockito.when(userContract.existsById(1L)).thenReturn(true);
        Mockito.when(userContract.save(newUser)).thenReturn(newUser);

        User updatedUser = userServiceImpl.updateUser(1L, newUser);

        assertNotNull(updatedUser);
        assertEquals(1L, updatedUser.getId());
        Mockito.verify(userContract).existsById(1L);
        Mockito.verify(userContract).save(newUser);

        assertEquals(newUser, updatedUser);
    }

    /**
     * Test for updating a user that doesn't exist.
     * Verifies that the update operation fails and no changes are made.
     */
    @Test
    public void updateUserTest2() {
        Long userId = 2L;
        User newUser = new User(2L, "Hoban", "Cristian", "hc@yahoo.com", "0000", "Strada strada", 200);
        Mockito.when(userContract.existsById(userId)).thenReturn(false);

        User updatedUser = userServiceImpl.updateUser(userId, newUser);

        assertNull(updatedUser);
        Mockito.verify(userContract).existsById(userId);
        Mockito.verify(userContract, Mockito.never()).save(Mockito.any(User.class));
    }
    /**
     * Test for deleting a user.
     * Verifies that the user is deleted by its ID.
     */
    @Test
    public void deleteUserTest() {
        userServiceImpl.deleteUser(1L);
        Mockito.verify(userContract, times(1)).deleteById(1L);
    }

}
