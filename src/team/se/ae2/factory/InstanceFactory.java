package team.se.ae2.factory;

import team.se.ae2.DataCollection;
import team.se.ae2.model.*;

import java.util.Dictionary;

public class InstanceFactory {
    protected static DataCollection dc = DataCollection.getInstance();

    public static void initInstanceFromDict(Dictionary<String, String> kvPairs, String className) {
        switch (className) {
            case "systemVariable"-> createSystemVariable(kvPairs);
            case "user"-> createUser(kvPairs);
            case "course"-> createCourse(kvPairs);
            case "courseRequirement"-> createCourseRequirement(kvPairs);
            case "training"-> createTraining(kvPairs);
            case "trainee"-> createTrainee(kvPairs);
            case "uiSetting" -> createUiSetting(kvPairs);
        }
    }

    private static void createSystemVariable(Dictionary<String, String> kvPairs) {
        SystemVariable systemVariable = new SystemVariable();
        systemVariable.setCodeCourse(kvPairs.get("codeCourse"));
        systemVariable.setCodeTraining(kvPairs.get("codeTraining"));
        systemVariable.setCodeUser(kvPairs.get("codeUser"));

        dc.setSystemVariable(systemVariable);
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

    private static void createUiSetting(Dictionary<String, String> kvPairs) {
        UiSetting uiSetting = new UiSetting();
        String boxWidthStr = kvPairs.get("boxWidth");
        int boxWidth = Integer.parseInt(boxWidthStr);

        uiSetting.setBoxWidth(boxWidth);

        dc.setUiSetting(uiSetting);
    }
}
