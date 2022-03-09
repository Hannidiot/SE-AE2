package team.se.ae2.io;

public interface IDataLoader {
    /*
        Since the FileDataLoader does not share a lot of functions with DbDataLoader,
        only this function is extracted to an interface, which is exposed to the outer program
        to be called to load all data into the memory.
     */
    void load() throws Exception;
}
