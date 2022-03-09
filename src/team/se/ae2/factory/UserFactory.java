package team.se.ae2.factory;

import team.se.ae2.model.Administrator;
import team.se.ae2.model.ClassDirector;
import team.se.ae2.model.Teacher;
import team.se.ae2.model.User;

public class UserFactory {
    public static User createUser(String id, String username, String password, String role) {
        if (role.equals("ADMINISTRATOR")) return new Administrator(id, username, password);
        else if (role.equals("CLASS_DIRECTOR")) return new ClassDirector(id, username, password);
        return new Teacher(id, username, password);
    }
}
