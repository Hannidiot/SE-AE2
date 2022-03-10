package team.se.ae2;

import team.se.ae2.io.FileDataLoader;
import team.se.ae2.io.FileDataWriter;
import team.se.ae2.io.IDataLoader;
import team.se.ae2.io.IDataWriter;
import team.se.ae2.ui.CommandLineUi;
import team.se.ae2.ui.page.MainPage;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // if the program cannot load the database file, please change the below path to ABSOLUTE PATH
        String testFilePath = Util.baseDir + "/resources/db.txt";

        // load data from db
        IDataLoader loader = new FileDataLoader(testFilePath);
        try {
            loader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }

        MainPage root = new MainPage();
        CommandLineUi ui = new CommandLineUi(root);
        ui.run();

        // write data to db
        DataCollection dc = DataCollection.getInstance();
        IDataWriter writer = new FileDataWriter(testFilePath);
        try {
            writer.open();
            writer.write("systemVariable", dc.getSystemVariable());
            writer.write("uiSetting", dc.getUiSetting());
            writer.writeBatch("user", dc.getUsers());
            writer.writeBatch("course", dc.getCourses());
            writer.writeBatch("courseRequirement", dc.getCourseRequirements());
            writer.writeBatch("training", dc.getTrainings());
            writer.writeBatch("trainee", dc.getTrainees());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
    }
}
