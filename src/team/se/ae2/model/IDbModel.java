package team.se.ae2.model;

/*
    Base class for all model classes which need to interact with database
 */
public interface IDbModel {
    // for writing object to text file, implement this method
    String getText();

    // for writing object to csv file, implement this method
//    String getCsvText();

    // for writing to database file, implement this method
//    String createSelectAllSql();
}
