public class Guest {
    private final String name;
    private final String[] trait;
    private final String[] interests;

    public Guest(String id, String[] character, String[] interests)
    {
        name = id;
        trait = character;
        this.interests = interests;
    }
    
    public String getName()
    {
        return name;
    }

    public String[] getTrait()
    {
        return trait;
    }

    public String[] getInterests()
    {
        return interests;
    }
}
