package ro.academyplus.avaj.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public final class Logger {

    private static BufferedWriter writer;

    private Logger() {}

    public static void init(String fileName) throws IOException {
        writer = new BufferedWriter(new FileWriter(fileName));
    }

    public static void log(String s) {
        if (writer == null)
            throw new IllegalStateException("Logger not initialized");
            
        try {
            writer.write(s);
            writer.newLine();
        } catch (IOException e) {
                throw new RuntimeException("Logging failed", e);
        }
    }

    public static void close() {
        try {
            if (writer != null)
                writer.close();
        } catch (IOException e) {
        }
    } 

}