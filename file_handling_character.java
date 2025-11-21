import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class file_handling_character {
    public static void main(String a[]) {
        String source = "C:\\Users\\STUDENT\\Documents\\JAVA_LAB\\input.txt";
        String desfile = "C:\\Users\\STUDENT\\Documents\\JAVA_LAB\\output.txt";

        try (
                FileReader reader = new FileReader(source);
                FileWriter writer = new FileWriter(desfile);) {
            char[] buff = new char[4096];
            int charread;
            while ((charread = reader.read(buff)) != -1) {
                writer.write(buff, 0, charread);
            }
            System.out.println("file copied sucessfully");
        } catch (IOException e) {
            System.out.println("error occured" + e.getMessage());
        }
    }
}