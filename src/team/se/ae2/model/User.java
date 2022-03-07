package team.se.ae2.model;

public abstract class User {
    public enum Role {
        TEACHER,
        CLASS_DIRECTOR,
        ADMINISTRATOR
    }

    protected String id;
    protected String username;
    protected String password;
    protected Role role;

    public User(String id, String username, String password, Role role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "id=" + id +
                "\tusername=" + username +
                "\tpassword=" + password +
                "\trole=" + role +
                "" ;
    }
}
