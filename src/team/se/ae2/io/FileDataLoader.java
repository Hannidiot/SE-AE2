package team.se.ae2.io;

import team.se.ae2.DataCollection;
import team.se.ae2.factory.InstanceFactory;
import team.se.ae2.model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Scanner;

public class FileDataLoader {

    public void load(String path) throws Exception {
        File db = new File(path);
        if (!db.exists()) throw new FileNotFoundException("db file is not found!");

        Scanner fileReader = new Scanner(db);
        while (fileReader.hasNextLine()) {
            String line = fileReader.nextLine();

            parseLine(line, fileReader);
        }

        fileReader.close();
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

            InstanceFactory.initInstanceFromDict(kvPairs, category);
        }
    }
}
