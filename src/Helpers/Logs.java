package Helpers;

import java.io.FileWriter;
import java.io.IOException;

public class Logs {
    public FileWriter writer;

    public Logs() throws IOException {
        writer = new FileWriter("output.txt");
    }

    public void close() throws IOException {
        writer.flush();
        writer.close();
    }
}
