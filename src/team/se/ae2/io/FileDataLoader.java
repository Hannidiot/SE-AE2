package team.se.ae2.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileDataLoader {
    public void load(String path) throws FileNotFoundException {
        File db = new File(path);
        if (!db.exists()) throw new FileNotFoundException("db file is not found!");

        Scanner fileReader = new Scanner(db);
        while (fileReader.hasNextLine()) {
            String line = fileReader.next();

            handleLine(line, fileReader);
        }
    }

    protected void handleLine(String line, Scanner reader) {
        if (!line.startsWith(":")) return;

        String pattern = line.strip().substring(1);
        switch (pattern) {
            case "setting": {

                break;
            }
            case "user": {
                break;
            }
            case "course": {
                break;
            }
            case "course_requirement": {
                break;
            }
            case "training": {
                break;
            }
            case "trainee": {
                break;
            }
        }
    }
}
