package team.se.ae2.model;

import java.util.ArrayList;

public class Teacher extends User{
    public Teacher(String id, String username, String password) {
        super(id, username, password, Role.TEACHER);
    }

    public Teacher() {
        this.role = Role.TEACHER;
    }
}
