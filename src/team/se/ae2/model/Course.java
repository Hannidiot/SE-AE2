package team.se.ae2.model;

public class Course implements IDbModel {
    protected String courseName;
    protected String courseCode;

    protected Teacher courseTeacher;

    public Course() {}

    public Course(String courseName, String courseCode) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.courseTeacher = null;
    }

    public Course(String courseName, String courseCode, Teacher teacher) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.courseTeacher = teacher;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public Teacher getCourseTeacher() {
        return courseTeacher;
    }

    public void setCourseTeacher(Teacher courseTeacher) {
        this.courseTeacher = courseTeacher;
    }

    @Override
    public String toString() {
        return "courseName=" + courseName +
                "\tcourseCode=" + courseCode +
                "\tcourseTeacher=" + (courseTeacher == null ? "null" : courseTeacher.id) +
                "" ;
    }

    @Override
    public String getText() {
        return toString();
    }
}
