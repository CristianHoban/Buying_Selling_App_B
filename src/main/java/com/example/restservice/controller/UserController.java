package com.example.restservice.controller;

import com.example.restservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.restservice.service.UserServiceImpl;

import java.util.Optional;

/**
 * cu ajutorul acestei clase, se realizeaza endpoint-uri pentru creare, stergere, editare si cautare in tabela User
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    /**
     *Endpoint pentru cautarea unui user
     *
     * @param id ID-ul user-ului pe care il cautam in tabela
     * @return ResponseEntity care il contine pe userul cu ID-ul respectiv in cazul in care exista, NOT_FOUND in caz contrar
     */


    @GetMapping("/get/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userServiceImpl.getUserById(id);
        return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    /**
     * Endpoint pentru adaugarea unui nou User
     * @param user Obiectul User care va fi adaugat in tabel
     * @return
     */
    @PostMapping("/add")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userServiceImpl.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    /**
     * Endpoint for updating an existing user.
     *
     * @param id   ID-ul User-ului care se vrea a fi modificat
     * @param user User-ul modificat
     * @return NOT_FOUND, in cazul in care nu a fost gasit un User cu ID-ul respectiv
     */

    @PutMapping("/put/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        User updatedUser = userServiceImpl.updateUser(id, user);
        if (updatedUser != null) {
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    /**
     * Endpoint pentru stergerea unui User
     * @param id ID-ul user-ului care va fi sters
     * @return
     */

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userServiceImpl.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/admin/updateBalances")
    public ResponseEntity<?> updateAllUserBalances(@RequestBody double amount) {
        userServiceImpl.performAdminAction(amount);
        userServiceImpl.addBalanceToUsers(amount);
        return ResponseEntity.ok().build();
    }
}