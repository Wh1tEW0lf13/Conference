import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class Registration{

    public ArrayList<Guest>FileReader(String path)
    {
        ArrayList<Guest> guests = new ArrayList<>();   //Here I save the guests
        try
        {
            File file = new File(path);
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine())
                {
                    String data = scanner.nextLine();
                    String [] trait, interests;
                    data = data.toUpperCase();  // change text to lower eliminate problems with size letter
                    try
                    {
                        String name = data.substring(0,data.indexOf("\t")); //Save name
                        data = data.replace(name+"\t", ""); //Delete name from the string
                        trait = InterestAssing(data.substring(0,data.indexOf("\t"))); //We are looking for this
                        interests = InterestAssing(data.substring(data.indexOf("\t")+1,data.length())); //We want this
                        guests.add(new Guest(name, trait, interests));
                    }
                    catch(StringIndexOutOfBoundsException e)
                    {
                        System.out.println("Something is wrong with a file!!! " + e.getMessage());
                    }
                }
            }
            if(guests.size()<5)
            {
                System.out.println("The file is to small");
                System.exit(0);
            }

        }
        catch(FileNotFoundException a)
        {
            System.out.println("File not find!");
            System.exit(0);
        }
        return guests;
    }
    private String[] InterestAssing(String nameEngage)  //Separate trait and interest
    {
        return nameEngage.split(",");
    }
}