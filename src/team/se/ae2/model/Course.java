package team.se.ae2.model;

import java.util.ArrayList;

public class Course {
    protected String courseName;
    protected String courseCode;

    protected Teacher courseTeacher;
    protected ArrayList<CourseRequirement> teachingRequirements;

    public Course(String courseName, String courseCode) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.courseTeacher = null;
        this.teachingRequirements = new ArrayList<>();
    }

    public void addRequirement(CourseRequirement cr) {
        teachingRequirements.add(cr);
    }

    public void removeRequirement(CourseRequirement cr) {

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
}
