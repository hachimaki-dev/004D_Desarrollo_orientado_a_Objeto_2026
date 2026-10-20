package com.amaro.biblioapp.controller;

import com.amaro.biblioapp.model.User;
import com.amaro.biblioapp.model.UserManager;

public class UserController {
    
    public User searchUserByRut(String rut) {
        UserManager userManager = new UserManager();
        User user = userManager.returnUserByRut(rut);
        return user;
    }

    public void test(){
        UserManager userManager = new UserManager();
        userManager.aVerSiEsVerdad();
    }
}
