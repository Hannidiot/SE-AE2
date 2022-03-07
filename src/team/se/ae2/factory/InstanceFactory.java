package team.se.ae2.factory;

import team.se.ae2.DataCollection;
import team.se.ae2.model.*;

import java.util.Dictionary;

public class InstanceFactory {
    protected static DataCollection dc = DataCollection.getInstance();

    public static void initInstanceFromDict(Dictionary<String, String> kvPairs, String className) {
        switch (className) {
            case "setting"-> createSetting(kvPairs);
            case "user"-> createUser(kvPairs);
            case "course"-> createCourse(kvPairs);
            case "courseRequirement"-> createCourseRequirement(kvPairs);
            case "training"-> createTraining(kvPairs);
            case "trainee"-> createTrainee(kvPairs);
        }
    }

    private static void createSetting(Dictionary<String, String> kvPairs) {
        Setting setting = new Setting();
        setting.setCodeCourse(kvPairs.get("codeCourse"));
        setting.setCodeTraining(kvPairs.get("codeTraining"));
        setting.setCodeUser(kvPairs.get("codeUser"));

        dc.setSetting(setting);
    }

    private static void createUser(Dictionary<String, String> kvPairs) {
        String id = kvPairs.get("id");
        String username = kvPairs.get("username");
        String password = kvPairs.get("password");
        String role = kvPairs.get("role");
        User user = UserFactory.CreateUser(id, username, password, role);

        dc.addUser(user);
    }

    private static void createCourse(Dictionary<String, String> kvPairs) {
        Course course = new Course();
        course.setCourseCode(kvPairs.get("courseCode"));
        course.setCourseName(kvPairs.get("courseName"));
        String courseTeacherId = kvPairs.get("courseTeacher");

        if (!courseTeacherId.equals("null")) {
            Teacher courseTeacher = (Teacher) dc.getUserById(courseTeacherId);
            course.setCourseTeacher(courseTeacher);
        }

        dc.addCourse(course);
    }

    private static void createCourseRequirement(Dictionary<String, String> kvPairs) {
        CourseRequirement cr = new CourseRequirement();
        String courseId = kvPairs.get("course");
        Course course = dc.getCourseById(courseId);

        String creatorId = kvPairs.get("creator");
        User creator = dc.getUserById(creatorId);

        cr.setRequirementText(kvPairs.get("requirementText"));
        cr.setCourse(course);
        cr.setCreator(creator);

        dc.addCourseRequirement(cr);
    }

    private static void createTraining(Dictionary<String, String> kvPairs) {
        Training training = new Training();
        String trainerId = kvPairs.get("trainer");
        User trainer = dc.getUserById(trainerId);

        String ownerId = kvPairs.get("owner");
        Administrator owner = (Administrator) dc.getUserById(ownerId);

        training.setTrainingCode(kvPairs.get("trainingCode"));
        training.setTrainingName(kvPairs.get("trainingName"));
        training.setTrainer(trainer);
        training.setOwner(owner);

        dc.addTraining(training);
    }

    private static void createTrainee(Dictionary<String, String> kvPairs) {
        Trainee trainee = new Trainee();
        String traineeId = kvPairs.get("trainee");
        Teacher traineePpl = (Teacher) dc.getUserById(traineeId);

        String trainingId = kvPairs.get("training");
        Training training = dc.getTrainingById(trainingId);

        trainee.setTrainee(traineePpl);
        trainee.setTraining(training);

        dc.addTrainee(trainee);
    }
}
