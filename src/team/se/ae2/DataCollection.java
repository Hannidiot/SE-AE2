package team.se.ae2;

import team.se.ae2.model.*;

import java.util.ArrayList;

/* a singleton class to store all the data in memory

   The implementation is a bit dirty. In concept, this class is a combination of database and memory.
   It is better to remove some data from here to a new class, like ui settings which ought to be stored
   in the local file, and only keep this class to store all business data.
 */
public class DataCollection {
    private static DataCollection instance = null;

    public static DataCollection getInstance() {
        if (instance == null) {
            instance = new DataCollection();
        }
        return instance;
    }

    public User getUserById(String id) {
        for (User user :
                this.users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    public Course getCourseById(String id) {
        for (Course course :
                this.courses) {
            if (course.getCourseCode().equals(id)) return course;
        }
        return null;
    }

    public Course getCourseByName(String name) {
        for (Course course :
                this.courses) {
            if (course.getCourseName().equals(name)) return course;
        }
        return null;
    }

    public Training getTrainingById(String id) {
        for (Training training :
                this.trainings) {
            if (training.getTrainingCode().equals(id)) return training;
        }
        return null;
    }

    public void setSystemVariable(SystemVariable systemVariable) {
        this.systemVariable = systemVariable;
    }

    public void setUiSetting(UiSetting uiSetting) {
        this.uiSetting = uiSetting;
    }

    public void userLogin(User user) {
        this.loginUser = user;
    }

    public void userLogout() {
        this.loginUser = null;
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

    public void addTrainee(Trainee trainee) {
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

    public ArrayList<Trainee> getTrainees() {
        return trainees;
    }

    public SystemVariable getSystemVariable() {
        return this.systemVariable;
    }

    public UiSetting getUiSetting() {
        return uiSetting;
    }

    public User getLoginUser() {
        return loginUser;
    }

    // Course Models
    protected ArrayList<Course> courses = new ArrayList<>();
    protected ArrayList<CourseRequirement> courseRequirements = new ArrayList<>();

    // User Models
    protected ArrayList<User> users = new ArrayList<>();

    // Training Models
    protected ArrayList<Training> trainings = new ArrayList<>();
    protected ArrayList<Trainee> trainees = new ArrayList<>();

    // SystemVariable Model
    protected SystemVariable systemVariable;

    // UiSetting Model
    protected UiSetting uiSetting;

    // Context
    protected User loginUser;

    @Override
    public String toString() {
        return "courses=" + courses +
                "\ncourseRequirements=" + courseRequirements +
                "\nusers=" + users +
                "\ntrainings=" + trainings +
                "\ntrainees=" + trainees +
                "\nsystemVariable=" + systemVariable +
                "\nuiSetting=" + uiSetting +
                "" ;
    }
}
