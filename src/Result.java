import java.util.ArrayList;

public class Result
{
    public void ShowResult( ArrayList<ArrayList<String>> result)    //Here we are showing our result
    {
        for(int i = 0; i < result.size(); i++)
        {
            System.out.print(result.get(i).get(0)+": ");
            for(int j = 1; j < result.get(i).size(); j++)
            {
                System.out.print(result.get(i).get(j)+", ");
            }
            System.out.println();
        }
    }
}