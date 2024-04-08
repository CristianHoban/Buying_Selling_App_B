package com.example.restservice.observer;

import com.example.restservice.model.User;

import java.util.ArrayList;
import java.util.List;

public class AdminAction{

    /**
     * Metoda care notifica user-ul in momentul in care i s-a facut o modificare a balantei de catre adminul sistemului
     * @param user
     * @param amount
     */
    public void notifyObserver(User user, double amount) {
            System.out.println(user.getFirstName()+ ", you received a gift of: " + amount);
    }


}