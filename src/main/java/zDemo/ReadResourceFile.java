package zDemo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ReadResourceFile {
    public static void main(String[] args) throws IOException {
        String fileName = "webAutomationConfig.xml";
        ClassLoader classLoader = ReadResourceFile.class.getClassLoader();

        File file = new File(classLoader.getResource(fileName).getFile());
        System.out.println("File exists: " + file.exists());

        String content = new String(Files.readAllBytes(file.toPath()));
        System.out.println(content);
    }
}
