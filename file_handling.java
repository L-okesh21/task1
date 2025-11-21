import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class file_handling {
    public static void main(String a[]) {
        String source = "C:\\Users\\STUDENT\\Documents\\JAVA_LAB\\input.txt";
        String desfile = "C:\\Users\\STUDENT\\Documents\\JAVA_LAB\\output.txt";

        try (
                FileInputStream fis = new FileInputStream(source);
                FileOutputStream fop = new FileOutputStream(desfile);) {
            byte[] buff = new byte[4096];
            int byteread;
            while ((byteread = fis.read(buff)) != -1) {
                fop.write(buff, 0, byteread);
            }
            System.out.println("file copied sucessfully");
        } catch (IOException e) {
            System.out.println("error occured" + e.getMessage());
        }
    }
}