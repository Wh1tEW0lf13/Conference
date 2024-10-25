import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        if(args.length > 0)
        {
            for (String arg : args) {
                GeneticAlgorithm meeting = new GeneticAlgorithm();
                Registration register = new Registration();
                Result result = new Result();
                ArrayList<Guest> guests = register.FileReader(arg);
                result.ShowResult(meeting.NewGenerationStarter(guests));
            }

        }
        else
        {
            System.out.println("I can't find the arguments");
        }

    }
}