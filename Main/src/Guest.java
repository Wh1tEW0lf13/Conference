import java.util.ArrayList;

public class Guest {
    String name;
    ArrayList<String> characteristic = new ArrayList<String>();
    ArrayList<String> interests = new ArrayList<String>();
    public Guest(String id, ArrayList<String> character, ArrayList<String> interests)
    {
        name = id;
        characteristic = character;
        this.interests = interests;
    }
}
