package com.example.restservice.observer;

import com.example.restservice.model.User;

import java.util.ArrayList;
import java.util.List;

public class AdminAction{

    public void notifyObserver(User user, double amount) {
            System.out.println(user.getFirstName()+ ", you received a gift of: " + amount);
    }


}