package com.example.restservice.data;

import com.example.restservice.model.User;
import com.example.restservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class UserData implements UserContract{

    private final UserRepository userRepository;
    @Autowired
    public UserData(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User save(User user) {
        return  this.userRepository.save(user);
    }

    @Override
    public boolean existsById(Long id) {
        return this.userRepository.existsById(id);
    }


    @Override
    public void deleteById(Long id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public void addAmountToAllUsers(double amount) {
        this.userRepository.addAmountToAllUsers(amount);
    }
}
