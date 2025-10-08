import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class Activity14 {
    public static void main(String[] args) {
        try {
            // Step 1: Create a File object
            File file = new File("sample.txt");

            // Step 2: Try creating the file
            boolean fStatus = file.createNewFile();

            // Step 3: Inform whether file was created or already existed
            if (fStatus) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }

            // Step 4: Write text into the file using FileUtils
            String fileContent = "This is a sample file created in Activity 14.";
            FileUtils.writeStringToFile(file, fileContent, "UTF-8");
            System.out.println("Content written to the file successfully.");

        } catch (IOException e) {
            System.out.println("An error occurred while creating or writing to the file.");
            e.printStackTrace();
        }
    }
}
