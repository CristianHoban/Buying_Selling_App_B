package com.example.restservice.data;

import com.example.restservice.model.User;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

/**
 * A contract that defines methods necessary for managing user data
 */
public interface UserContract {
    /**
     * A method that finds a user by its ID
     * @param id
     * @return the user with specific ID, if it is found
     */
    Optional<User> findById(Long id);

    Optional<User> findByEmail(String email);
    /**
     * A method that saves a user
     * It is used for creating method
     * @param user
     * @return the saved user
     */
    User save(User user);
    /**
     * A method that checks if there is a user with a specific ID
     * @param id
     * @return True - if there is a user with the specific ID, False - otherwise
     */
    boolean existsById(Long id);
    /**
     * A method that deletes a user with a specific ID
     * @param id
     */
    void deleteById(Long id);

    /**
     * A method that finds all users in database
     * @return the list with all users
     */
    List<User> findAll();

    /**
     * A method that adds an amount of money to all users' balance
     * @param amount
     */
    void addAmountToAllUsers(double amount);

    Optional<User> findByEmailAndPassword(String email, String password);




}
