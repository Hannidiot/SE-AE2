package team.se.ae2.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UiInputElement extends UiBase {
    protected String defaultHint;
    protected InputStreamReader inputStream;
    protected BufferedReader reader;

    public UiInputElement() {
        inputStream = new InputStreamReader(System.in);
        reader = new BufferedReader(inputStream);
    }

    public String getInput(String hint) {
        String input;

        printPrefix(hint);
        try {
            input = reader.readLine();
            return input;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

    protected void printPrefix(String hint) {
        System.out.print(hint + " > ");
    }

    public void close() {
        try {
            reader.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
