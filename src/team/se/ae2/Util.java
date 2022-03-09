package team.se.ae2;

import team.se.ae2.model.*;

public class Util {
    public static String baseDir = System.getProperty("user.dir");

    protected static DataCollection dc = DataCollection.getInstance();
    public static void InitiateInstance(IDbModel model) {
        if (model instanceof User) dc.addUser((User) model);
        else if (model instanceof Course) dc.addCourse((Course) model);
        else if (model instanceof CourseRequirement) dc.addCourseRequirement((CourseRequirement) model);
        else if (model instanceof SystemVariable) dc.setSystemVariable((SystemVariable) model);
        else if (model instanceof UiSetting) dc.setUiSetting((UiSetting) model);
        else if (model instanceof Training) dc.addTraining((Training) model);
        else if (model instanceof Trainee) dc.addTrainee((Trainee) model);
    }
}
