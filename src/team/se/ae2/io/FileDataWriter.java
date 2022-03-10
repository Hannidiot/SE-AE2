package team.se.ae2.io;

import team.se.ae2.model.IDbModel;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileDataWriter implements IDataWriter {
    protected FileWriter writer;
    protected BufferedWriter bufferedWriter;
    protected String path;

    public FileDataWriter(String path) {
        this.path = path;
    }

    public void open() throws IOException {
        writer = new FileWriter(path);
        bufferedWriter = new BufferedWriter(writer);
    }

    public void write(String categoryName, IDbModel dbModel) {
        try {
            bufferedWriter.write(":" + categoryName + "\n");

            bufferedWriter.write(dbModel.getText());
            bufferedWriter.newLine();

            bufferedWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeBatch(String categoryName, List dbModels) {
        try {
            bufferedWriter.write(":" + categoryName + "\n");

            for (Object dbModel : dbModels) {
                if (!(dbModel instanceof IDbModel)) continue;
                bufferedWriter.write(((IDbModel) dbModel).getText());
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
