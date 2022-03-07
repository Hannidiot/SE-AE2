package team.se.ae2.model;

public class Administrator extends User{

    public Administrator(String id, String username, String password) {
        super(id, username, password, Role.ADMINISTRATOR);
    }
}
