package team.se.ae2.controller;

import team.se.ae2.DataCollection;
import team.se.ae2.model.Teacher;

public class EnrollController {
    protected DataCollection dc = DataCollection.getInstance();

    public boolean enrollNewTeacher(String id, String username, String password) {
        // todo: add check here

        Teacher newTeacher = new Teacher(id, username, password);
        dc.addUser(newTeacher);
        return true;
    }
}
