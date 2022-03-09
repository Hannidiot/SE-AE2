package team.se.ae2.io;

import team.se.ae2.Util;
import team.se.ae2.factory.InstanceFactory;
import team.se.ae2.model.IDbModel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Scanner;

public class FileDataLoader implements IDataLoader {

    protected String path;
    public FileDataLoader(String path) {
        this.path = path;
    }

    public void load() throws Exception {
        File db = new File(path);
        if (!db.exists()) throw new FileNotFoundException("db file is not found!");

        Scanner fileReader = new Scanner(db);
        while (fileReader.hasNextLine()) {
            String line = fileReader.nextLine();

            parseLine(line, fileReader);
        }

        fileReader.close();
    }

    protected void parseLine(String line, Scanner reader) {
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

            IDbModel instance = InstanceFactory.createInstance(kvPairs, category);
            Util.InitiateInstance(instance);
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
