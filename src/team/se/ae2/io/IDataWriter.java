package team.se.ae2.io;

import team.se.ae2.model.IDbModel;

import java.io.IOException;
import java.util.List;

/*

 */
public interface IDataWriter {
    // write one record to the target
    void write(String tableName, IDbModel obj);

    // write a batch of records to the target
    void writeBatch(String tableName, List objs);

    // open connection
    void open() throws IOException;

    // close connection
    void close();
}
