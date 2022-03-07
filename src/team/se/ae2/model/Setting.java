package team.se.ae2.model;

public class Setting {
    protected String code_user;
    protected String code_course;
    protected String code_training;

    public Setting(String code_user, String code_course, String code_training) {
        this.code_user = code_user;
        this.code_course = code_course;
        this.code_training = code_training;
    }

    public String getCode_user() {
        return code_user;
    }

    public void setCode_user(String code_user) {
        this.code_user = code_user;
    }

    public String getCode_course() {
        return code_course;
    }

    public void setCode_course(String code_course) {
        this.code_course = code_course;
    }

    public String getCode_training() {
        return code_training;
    }

    public void setCode_training(String code_training) {
        this.code_training = code_training;
    }

    @Override
    public String toString() {
        return "code_user=" + code_user +
                "\tcode_course=" + code_course +
                "\tcode_training=" + code_training +
                "" ;
    }
}
