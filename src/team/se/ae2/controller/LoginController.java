package team.se.ae2.controller;

import team.se.ae2.DataCollection;
import team.se.ae2.model.User;

import java.util.ArrayList;

public class LoginController {
    protected DataCollection dc = DataCollection.getInstance();

    public boolean login(String username, String password) {
        ArrayList<User> users = dc.getUsers();

        for (User user:
             users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                dc.userLogin(user);
                return true;
            }
        }

        return false;
    }

    public boolean logout() {
        if (dc.getLoginUser() == null) return false;

        dc.userLogout();
        return true;
    }
}
