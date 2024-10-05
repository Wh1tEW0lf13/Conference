import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class FileHandling{

    ArrayList<Guest> guest = new ArrayList<Guest>();
    public void FileReader()
    {

        try
        {
            File file = new File("goscie.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine())
            {
                ArrayList<String> character = new ArrayList<String>();
                ArrayList<String> interests = new ArrayList<String>();
                String data = scanner.nextLine();
                data = data.toLowerCase();  // change text to lower eliminate problems with size letter
                String name = data.substring(0,data.indexOf("\t"));
                data = data.replace(name+"\t", "");
                while(data.substring(0,1)!="\t")
                {
                    if(data.indexOf(",")<data.indexOf("\t"))
                    {
                        String oneCharacter = data.substring(0, data.indexOf(","));
                        data = data.replace(oneCharacter+",", "");
                        character.add(oneCharacter);
                    }
                    else
                    {
                        String oneCharacter = data.substring(0, data.indexOf("\t"));
                        data = data.replace(oneCharacter+"\t", "");
                        character.add(oneCharacter);
                        break;
                    }
                    
                }
            }
            scanner.close();
        }
        catch(FileNotFoundException a)
        {
            System.out.println("File not find!");
        }
    }
}