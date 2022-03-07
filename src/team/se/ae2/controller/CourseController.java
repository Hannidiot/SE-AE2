package team.se.ae2.controller;

import team.se.ae2.model.Course;
import team.se.ae2.model.CourseRequirement;
import team.se.ae2.model.User;

import java.time.LocalDateTime;

public class CourseController {
    public boolean addCourseRequirements(Course course, String requirementText, User user) {
        if (!user.getRole().equals(User.Role.ADMINISTRATOR)) return false;

        CourseRequirement cr = new CourseRequirement(requirementText, user, LocalDateTime.now());
        course.addRequirement(cr);
        return true;
    }
}
