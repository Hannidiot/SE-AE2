package team.se.ae2;

import team.se.ae2.io.FileDataLoader;
import team.se.ae2.io.FileDataWriter;
import team.se.ae2.model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        String testFilePath = Util.baseDir + "/resources/test.txt";
        DataCollection dc = DataCollection.getInstance();
        List<IDbModel> userList = new ArrayList<>();
        List<IDbModel> courseList = new ArrayList<>();
        List<IDbModel> courseRequirements = new ArrayList<>();
        List<IDbModel> trainings = new ArrayList<>();
        List<IDbModel> trainees = new ArrayList<>();

        SystemVariable systemVariable = new SystemVariable("4", "2", "2");
        UiSetting uiSetting = new UiSetting();
        uiSetting.setBoxWidth(20);

        ClassDirector cd = new ClassDirector("1", "classDirector", "test");
        Administrator admin = new Administrator("2", "admin", "test");
        Teacher hanni = new Teacher("3", "Hanni", "test");
        userList.add(cd);
        userList.add(admin);
        userList.add(hanni);

        Course writing = new Course("Writing", "1", null);
        courseList.add(writing);

        CourseRequirement cr =
                new CourseRequirement("A template requirement", cd, writing);
        courseRequirements.add(cr);

        Training training = new Training("1", "test", hanni, admin);
        trainings.add(training);

        Trainee trainee = new Trainee(hanni, training);
        trainees.add(trainee);

        FileDataWriter writer = new FileDataWriter();
        try {
            writer.open(testFilePath);
            writer.write("systemVariable", systemVariable);
            writer.write("uiSetting", uiSetting);
            writer.writeBatch("user", userList);
            writer.writeBatch("course", courseList);
            writer.writeBatch("courseRequirement", courseRequirements);
            writer.writeBatch("training", trainings);
            writer.writeBatch("trainee", trainees);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }

        FileDataLoader loader = new FileDataLoader(testFilePath);
        try {
            loader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(dc);
    }
}
