package team.se.ae2.model;

public class ClassDirector extends User{
    public ClassDirector() {
        this.role = Role.CLASS_DIRECTOR;
    }

    public ClassDirector(String id, String username, String password) {
        super(id, username, password, Role.CLASS_DIRECTOR);
    }
}
