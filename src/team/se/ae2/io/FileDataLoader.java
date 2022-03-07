package team.se.ae2.io;

import team.se.ae2.DataCollection;
import team.se.ae2.model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Scanner;

public class FileDataLoader {
    protected DataCollection dc = DataCollection.getInstance();
    private final Dictionary<String, Class> category2ClassMap = new Hashtable<>();

    public FileDataLoader() {
        category2ClassMap.put("setting", Setting.class);
        category2ClassMap.put("user", User.class);
        category2ClassMap.put("course", Course.class);
        category2ClassMap.put("courseRequirement", CourseRequirement.class);
        category2ClassMap.put("training", Training.class);
        category2ClassMap.put("trainee", Trainee.class);
    }

    public void load(String path) throws Exception {
        File db = new File(path);
        if (!db.exists()) throw new FileNotFoundException("db file is not found!");

        Scanner fileReader = new Scanner(db);
        while (fileReader.hasNextLine()) {
            String line = fileReader.next();

            parseLine(line, fileReader);
        }
    }

    protected void parseLine(String line, Scanner reader) throws Exception {
        if (!line.startsWith(":")) return;

        String category = line.strip().substring(1);
        while (reader.hasNextLine()) {
            String dataLine = reader.nextLine();
            if (dataLine.isEmpty()) break;

            Dictionary<String, String> kvPairs = new Hashtable<>();
            String[] sets = dataLine.strip().split("\t");
            for (String set :
                    sets) {
                String[] kvPair = set.split("=");
                kvPairs.put(kvPair[0], kvPair[1]);
            }

            Class targetClass = category2ClassMap.get(category);
            if (kvPairs.size() != targetClass.getFields().length)
                throw new Exception("no enough parameters when parsing.");


        }
    }
}
