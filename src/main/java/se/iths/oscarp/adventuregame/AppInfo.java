package se.iths.oscarp.adventuregame;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class AppInfo {
    private static AppInfo instance;
    private Properties properties;

    private AppInfo() {
        properties = new Properties();
        try (FileReader reader = new FileReader("data/config.properties")) {
             properties.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static AppInfo getInstance() {
        if (instance == null) {
            instance = new AppInfo();
        }
        return instance;
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public void ensureFileExists(Path path) {
        try {
            // If File Parent does not exist then make it
            if (Files.notExists(path.getParent())) {
                Files.createDirectories(path.getParent());
            }
            // If File does not exist then make it
            if (Files.notExists(path)) {
                Files.createFile(path);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error creating file or directories", e);
        }
    }
}
