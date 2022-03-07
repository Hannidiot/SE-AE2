package team.se.ae2.factory;

import team.se.ae2.DataCollection;
import team.se.ae2.model.Setting;

import java.lang.reflect.Field;
import java.util.Dictionary;

public class InstanceFactory {
    protected static DataCollection dc = DataCollection.getInstance();

    public static void CreateInstanceFromDict(Dictionary<String, String> kvPairs, String className) {
        switch (className) {
            case "setting"-> CreateSetting(kvPairs);
            case "user"-> CreateUser(kvPairs);
            case "course"-> CreateCourse(kvPairs);
            case "courseRequirement"-> CreateCourseRequirement(kvPairs);
            case "training"-> CreateTraining(kvPairs);
            case "trainee"-> CreateTrainee(kvPairs);
        }
    }

    private static void CreateSetting(Dictionary<String, String> kvPairs) {
        Setting setting = new Setting();
        setting.setCodeCourse(kvPairs.get("codeCourse"));
    }

    private static void CreateUser(Dictionary<String, String> kvPairs) {

    }

    private static void CreateCourse(Dictionary<String, String> kvPairs) {

    }

    private static void CreateCourseRequirement(Dictionary<String, String> kvPairs) {

    }

    private static void CreateTraining(Dictionary<String, String> kvPairs) {

    }

    private static void CreateTrainee(Dictionary<String, String> kvPairs) {

    }
}
