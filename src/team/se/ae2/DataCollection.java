package team.se.ae2;

import team.se.ae2.model.*;

import java.util.ArrayList;

// a singleton class to store all the data in memory
public class DataCollection {
    private static DataCollection _dataCollection = null;
    private static String _filePath = "";

    public static DataCollection getInstance() {
        if (_dataCollection == null) {
            _dataCollection = new DataCollection();
        }
        return _dataCollection;
    }

    public void loadData() {

    }

    public void saveData() {

    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }

    public void addCourseRequirement(CourseRequirement cr) {
        this.courseRequirements.add(cr);
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public void addTraining(Training training) {
        this.trainings.add(training);
    }

    public void addTrainee(Teacher trainee) {
        this.trainees.add(trainee);
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public ArrayList<Training> getTrainings() {
        return trainings;
    }

    public ArrayList<CourseRequirement> getCourseRequirements() {
        return courseRequirements;
    }

    public ArrayList<Teacher> getTrainees() {
        return trainees;
    }

    // Course Models
    protected ArrayList<Course> courses;
    protected ArrayList<CourseRequirement> courseRequirements;

    // User Models
    protected ArrayList<User> users;

    // Training Models
    protected ArrayList<Training> trainings;
    protected ArrayList<Teacher> trainees;
}
