package com.example.restservice.service;

import com.example.restservice.model.User;
import com.example.restservice.observer.AdminAction;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.*;
import com.example.restservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementeaza interfata UserService si implementeaza totodata metodele cu care aceasta vine;
 * se instantiaza un obiect de tipul userRepository, cu ajutorul caruia vom putea realiza operatii CRUD pe tabelul User
 * am realizat cate o functie care apeleaza fiecare din cele 4 operatii de baza
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    private AdminAction adminAction = new AdminAction();
    @Autowired
    private ProductService productService;



    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User newUser) {
        if (userRepository.existsById(id)) {
            newUser.setId(id);
            return userRepository.save(newUser);
        }
        return null;
    }

    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    /**
     * metoda care apeleaza notifyUser pentru fiecare User, in momentul in care este apelata din controller
     * @param amount
     */
    public void performAdminAction(double amount) {
            List<User> users = userRepository.findAll();
            for(User user:users){
                adminAction.notifyObserver(user, amount);
            }
    }

    public void addBalanceToUsers(double amount){
        userRepository.addAmountToAllUsers(amount);
    }


}