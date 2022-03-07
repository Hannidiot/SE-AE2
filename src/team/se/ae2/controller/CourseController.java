package team.se.ae2.controller;

import team.se.ae2.DataCollection;
import team.se.ae2.model.Course;
import team.se.ae2.model.CourseRequirement;
import team.se.ae2.model.User;

import java.time.LocalDateTime;

public class CourseController {
    protected DataCollection dc = DataCollection.getInstance();

    public boolean addCourseRequirements(Course course, String requirementText, User user) {
        if (!user.getRole().equals(User.Role.ADMINISTRATOR)) return false;

        CourseRequirement cr = new CourseRequirement(requirementText, user, course);
        dc.addCourseRequirement(cr);
        return true;
    }

    public boolean addCourse(String courseCode, String courseName) {
        // todo: check if course in course list

        Course newCourse = new Course(courseName, courseCode);
        dc.addCourse(newCourse);
        return true;
    }
}
