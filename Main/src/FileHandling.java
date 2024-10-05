import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileHandling{

    Guest guest;
    public void FileReader()
    {

        try
        {
            File file = new File("goscie.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine())
            {
                String data = scanner.nextLine();
                guest = new Guest();
            }
            scanner.close();
        }
        catch(FileNotFoundException a)
        {
            System.out.println("File not find!");
        }
    }
}