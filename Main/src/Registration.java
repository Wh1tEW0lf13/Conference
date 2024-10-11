import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Registration{
    public int diversity = 0;
    public ArrayList<Guest> guests = new ArrayList<Guest>();   //Here I save the guests
    public void FileReader()
    {
        try
        {
            File file = new File("goscie.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine())
            {
                String [] trait, interests;
                String data = scanner.nextLine();
                data = data.toUpperCase();  // change text to lower eliminate problems with size letter
                String name = data.substring(0,data.indexOf("\t")); //Save name
                data = data.replace(name+"\t", ""); //Delete name from the string
                trait = InterestAssing(data.substring(0,data.indexOf("\t")));   //
                interests = InterestAssing(data.substring(data.indexOf("\t")+1,data.length()));
                guests.add(new Guest(name, trait, interests));
                if(trait.length > diversity)
                {
                    diversity = trait.length;
                }
            }
            scanner.close();
        }
        catch(FileNotFoundException a)
        {
            System.out.println("File not find!");
        }
    }
    private String[] InterestAssing(String nameEngage)
    {
        return nameEngage.split(",");
    }
}