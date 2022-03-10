package team.se.ae2.controller;

import team.se.ae2.DataCollection;
import team.se.ae2.model.ClassDirector;
import team.se.ae2.model.Course;
import team.se.ae2.model.CourseRequirement;
import team.se.ae2.model.User;

import java.util.ArrayList;
import java.util.List;

public class CourseController {
    protected DataCollection dc = DataCollection.getInstance();

    public boolean addCourseRequirement(Course course, String requirementText, User user) {
        if (!user.getRole().equals(User.Role.CLASS_DIRECTOR)) return false;

        CourseRequirement cr = new CourseRequirement(requirementText, (ClassDirector) user, course);
        dc.addCourseRequirement(cr);
        return true;
    }

    public boolean addCourse(String courseCode, String courseName) {

        Course newCourse = new Course(courseName, courseCode);
        dc.addCourse(newCourse);
        return true;
    }

    public List<Course> getAllCourse() {
        return dc.getCourses();
    }

    public List<CourseRequirement> getCourseReqsByCourse(Course course) {
        ArrayList<CourseRequirement> courseRequirements = new ArrayList<>();
        ArrayList<CourseRequirement> allCrs = dc.getCourseRequirements();

        for (CourseRequirement cr:
             allCrs) {
            if (cr.getCourse().getCourseCode().equals(course.getCourseCode())) {
                courseRequirements.add(cr);
            }
        }

        return courseRequirements;
    }

    public Course getCourseByCourseName(String code) {
        return dc.getCourseByName(code);
    }
}
