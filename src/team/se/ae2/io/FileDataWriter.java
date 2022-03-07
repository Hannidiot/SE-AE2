package team.se.ae2.io;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileDataWriter {
    protected FileWriter writer;
    protected BufferedWriter bufferedWriter;

    public void open(String path) throws IOException {
        writer = new FileWriter(path);
        bufferedWriter = new BufferedWriter(writer);
    }

    public void writeCategory(String categoryName, @NotNull Object obj) {
        try {
            bufferedWriter.write(":" + categoryName + "\n");

            bufferedWriter.write(obj.toString());
            bufferedWriter.newLine();

            bufferedWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeCategoryCollection(String categoryName, @NotNull ArrayList objs) {
        try {
            bufferedWriter.write(":" + categoryName + "\n");

            for (int i = 0; i < objs.size(); i++) {
                bufferedWriter.write(objs.get(i).toString());
                bufferedWriter.newLine();
            }

            bufferedWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            this.bufferedWriter.close();
            this.writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
