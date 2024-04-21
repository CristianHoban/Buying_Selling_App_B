package com.example.restservice.data;

import com.example.restservice.model.User;
import com.example.restservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
/**
 * A class that is used for managing user data using JPA repository
 */
@Repository
public class UserData implements UserContract{

    private final UserRepository userRepository;
    @Autowired
    public UserData(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    /**
     * A method that searches a user by a specific ID, by using findById() from JPA repository
     * @param id
     * @return the user found with the specific ID, if found
     */
    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    /**
     * A method that saves a specific user, by using save() method from JPA repository
     * @param user
     * @return the saved user
     */
    @Override
    public User save(User user) {
        return  this.userRepository.save(user);
    }

    @Override
    public boolean existsById(Long id) {
        return this.userRepository.existsById(id);
    }


    /**
     * A method that checks if there is a user with a specific ID, by using existsById() from JPA repository
     * @param id
     * @return True - if there is a user with the specific ID, False - otherwise
     */
    @Override
    public void deleteById(Long id) {
        this.userRepository.deleteById(id);
    }
    /**
     * A method that finds all users in database, by using findAll() method from JPA repository
     * @return the list with all users
     */
    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    /**
     * A method that adds an amount of money to all users' balance, by using a query implemented
     * in UserRepository that extends JPA repository
     * @param amount
     */
    @Override
    public void addAmountToAllUsers(double amount) {
        this.userRepository.addAmountToAllUsers(amount);
    }
}
