package team.se.ae2.controller;

import team.se.ae2.DataCollection;
import team.se.ae2.model.Course;
import team.se.ae2.model.Teacher;
import team.se.ae2.model.User;

public class EnrollController {
    protected DataCollection dc = DataCollection.getInstance();

    public boolean enrollNewTeacher(String id, String username, String password) {
        // todo: add check here

        Teacher newTeacher = new Teacher(id, username, password);
        dc.addUser(newTeacher);
        return true;
    }
    public User getUserByUserName(String code) {
        return dc.getUserByName(code);
    }
}

