package team.se.ae2;

import team.se.ae2.io.FileDataLoader;
import team.se.ae2.ui.CommandLineUi;
import team.se.ae2.ui.page.MainPage;

public class Main {
    public static void main(String[] args) {
        String testFilePath = Util.baseDir + "/resources/test.txt";

        FileDataLoader loader = new FileDataLoader(testFilePath);
        try {
            loader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }

        MainPage root = new MainPage();
        CommandLineUi ui = new CommandLineUi(root);
        ui.run();
    }
}
