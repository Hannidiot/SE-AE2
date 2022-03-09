package team.se.ae2.factory;

import team.se.ae2.DataCollection;
import team.se.ae2.model.*;

import java.util.Dictionary;

public class InstanceFactory {
    protected static DataCollection dc = DataCollection.getInstance();

    public static IDbModel createInstance(Dictionary<String, String> kvPairs, String className) {
        switch (className) {
            case "systemVariable" -> { return createSystemVariable(kvPairs); }
            case "user"-> { return createUser(kvPairs); }
            case "course"-> { return createCourse(kvPairs); }
            case "courseRequirement"-> { return createCourseRequirement(kvPairs); }
            case "training"-> { return createTraining(kvPairs); }
            case "trainee"-> { return createTrainee(kvPairs); }
            case "uiSetting" -> { return createUiSetting(kvPairs); }
        }

        return null;
    }

    private static SystemVariable createSystemVariable(Dictionary<String, String> kvPairs) {
        SystemVariable systemVariable = new SystemVariable();
        systemVariable.setCodeCourse(kvPairs.get("codeCourse"));
        systemVariable.setCodeTraining(kvPairs.get("codeTraining"));
        systemVariable.setCodeUser(kvPairs.get("codeUser"));

        return systemVariable;
    }

    private static User createUser(Dictionary<String, String> kvPairs) {
        String id = kvPairs.get("id");
        String username = kvPairs.get("username");
        String password = kvPairs.get("password");
        String role = kvPairs.get("role");

        return UserFactory.createUser(id, username, password, role);
    }

    private static Course createCourse(Dictionary<String, String> kvPairs) {
        Course course = new Course();
        course.setCourseCode(kvPairs.get("courseCode"));
        course.setCourseName(kvPairs.get("courseName"));
        String courseTeacherId = kvPairs.get("courseTeacher");

        if (!courseTeacherId.equals("null")) {
            Teacher courseTeacher = (Teacher) dc.getUserById(courseTeacherId);
            course.setCourseTeacher(courseTeacher);
        }

        return course;
    }

    private static CourseRequirement createCourseRequirement(Dictionary<String, String> kvPairs) {
        CourseRequirement cr = new CourseRequirement();
        String courseId = kvPairs.get("course");
        Course course = dc.getCourseById(courseId);

        String creatorId = kvPairs.get("creator");
        User creator = dc.getUserById(creatorId);

        cr.setRequirementText(kvPairs.get("requirementText"));
        cr.setCourse(course);
        cr.setCreator(creator);

        return cr;
    }

    private static Training createTraining(Dictionary<String, String> kvPairs) {
        Training training = new Training();
        String trainerId = kvPairs.get("trainer");
        User trainer = dc.getUserById(trainerId);

        String ownerId = kvPairs.get("owner");
        Administrator owner = (Administrator) dc.getUserById(ownerId);

        training.setTrainingCode(kvPairs.get("trainingCode"));
        training.setTrainingName(kvPairs.get("trainingName"));
        training.setTrainer(trainer);
        training.setOwner(owner);

        return training;
    }

    private static Trainee createTrainee(Dictionary<String, String> kvPairs) {
        Trainee trainee = new Trainee();
        String traineeId = kvPairs.get("trainee");
        Teacher traineePpl = (Teacher) dc.getUserById(traineeId);

        String trainingId = kvPairs.get("training");
        Training training = dc.getTrainingById(trainingId);

        trainee.setTrainee(traineePpl);
        trainee.setTraining(training);

        return trainee;
    }

    private static UiSetting createUiSetting(Dictionary<String, String> kvPairs) {
        UiSetting uiSetting = new UiSetting();
        String boxWidthStr = kvPairs.get("boxWidth");
        int boxWidth = Integer.parseInt(boxWidthStr);

        uiSetting.setBoxWidth(boxWidth);

        return uiSetting;
    }
}
