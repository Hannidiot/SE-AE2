package team.se.ae2;

import team.se.ae2.io.FileDataWriter;
import team.se.ae2.model.*;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<User> userList = new ArrayList<>();
        ArrayList<Course> courseList = new ArrayList<>();
        ArrayList<CourseRequirement> courseRequirements = new ArrayList<>();
        ArrayList<Training> trainings = new ArrayList<>();
        ArrayList<Trainee> trainees = new ArrayList<>();

        Setting setting = new Setting("4", "2", "2");

        ClassDirector cd = new ClassDirector("1", "classDirector", "test");
        Administrator admin = new Administrator("2", "admin", "test");
        Teacher hanni = new Teacher("3", "Hanni", "test");
        userList.add(cd);
        userList.add(admin);
        userList.add(hanni);

        Course writing = new Course("Writing", "1", null);
        courseList.add(writing);

        CourseRequirement cr =
                new CourseRequirement("A template requirement", cd, LocalDateTime.now(), writing);
        courseRequirements.add(cr);

        Training training = new Training("1", "test", LocalDateTime.now(), hanni, admin);
        trainings.add(training);

        Trainee trainee = new Trainee(hanni, training);
        trainees.add(trainee);

        FileDataWriter writer = new FileDataWriter();
        try {
            writer.open(Util.baseDir + "/resources/test.txt");
            writer.writeCategory("setting", setting);
            writer.writeCategoryCollection("user", userList);
            writer.writeCategoryCollection("course", courseList);
            writer.writeCategoryCollection("courseRequirement", courseRequirements);
            writer.writeCategoryCollection("training", trainings);
            writer.writeCategoryCollection("trainee", trainees);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
    }
}
