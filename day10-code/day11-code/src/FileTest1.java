import java.io.File;
import java.io.IOException;

public class FileTest1 {
    public static void main(String[] args) throws IOException {
        File file1 = new File("aaa//a.txt");
        boolean b1 = file1.createNewFile();
        System.out.println(b1);
    }
}
