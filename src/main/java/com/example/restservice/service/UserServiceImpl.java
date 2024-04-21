package com.example.restservice.service;

import com.example.restservice.data.UserContract;
import com.example.restservice.model.User;
import com.example.restservice.observer.AdminAction;
import com.example.restservice.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private final UserContract userContract;

    /*public UserServiceImpl(){
        this.userRepository = new UserRepositoryImpl();
    }
*/
    public UserServiceImpl(UserContract userContract){
        this.userContract = userContract;
    }
    private AdminAction adminAction = new AdminAction();
    @Autowired
    private ProductService productService;


    /**
     * Retrieves a user by ID.
     * @param id the ID of the user to retrieve
     * @return an Optional containing the found user, or empty if not found
     */
    public Optional<User> getUserById(Long id) {
        return userContract.findById(id);
    }

    /**
     * Creates a new user.
     * @param user the user to create
     * @return the created user
     */
    public User createUser(User user) {
        return userContract.save(user);
    }


    /**
     * Updates an existing user.
     * @param id the ID of the user to update
     * @param newUser the new user data
     * @return the updated user, or null if the user does not exist
     */
    public User updateUser(Long id, User newUser) {
        if (userContract.existsById(id)) {
            newUser.setId(id);
            return userContract.save(newUser);
        }
        return null;
    }

    /**
     * Deletes a user by ID.
     * @param id the ID of the user to delete
     */
    @Transactional
    public void deleteUser(Long id) {
        userContract.deleteById(id);
    }

    /**
     * Performs an admin action, notifying users.
     * @param amount the amount associated with the admin action
     */
    public void performAdminAction(double amount) {
            List<User> users = userContract.findAll();
            for(User user:users){
                adminAction.notifyObserver(user, amount);
            }
    }

    /**
     * Adds balance to all users.
     * @param amount the amount to add to each user's balance
     */
    public void addBalanceToUsers(double amount){
        userContract.addAmountToAllUsers(amount);
    }


}