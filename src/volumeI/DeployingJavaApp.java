package volumeI;

import java.io.*;
import java.util.Properties;

public class DeployingJavaApp {
    public static void main(){
        Properties setting = new Properties();
        setting.setProperty("width", "200");
        setting.setProperty("height", "100");
        setting.setProperty("flag", "true");
        setting.setProperty("fileName", "name");
        setting.setProperty("title", "hello world");

        OutputStream out = null;
        try {
            out = new FileOutputStream("program.properties");
            setting.store(out, "properties");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        InputStream in = null;
        try {
            in = new FileInputStream("program.properties");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            setting.load(in);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(setting);
        System.out.println(System.getProperty("user.home"));
        System.out.println(System.getProperty("title","Default title")); // setting a default value for keys


    }
}
