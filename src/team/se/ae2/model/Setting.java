package team.se.ae2.model;

public class Setting {
    protected String codeUser;
    protected String codeCourse;
    protected String codeTraining;

    public Setting() {}

    public Setting(String codeUser, String codeCourse, String codeTraining) {
        this.codeUser = codeUser;
        this.codeCourse = codeCourse;
        this.codeTraining = codeTraining;
    }

    public String getCodeUser() {
        return codeUser;
    }

    public void setCodeUser(String codeUser) {
        this.codeUser = codeUser;
    }

    public String getCodeCourse() {
        return codeCourse;
    }

    public void setCodeCourse(String codeCourse) {
        this.codeCourse = codeCourse;
    }

    public String getCodeTraining() {
        return codeTraining;
    }

    public void setCodeTraining(String codeTraining) {
        this.codeTraining = codeTraining;
    }

    @Override
    public String toString() {
        return "codeUser=" + codeUser +
                "\tcodeCourse=" + codeCourse +
                "\tcodeTraining=" + codeTraining +
                "" ;
    }
}
