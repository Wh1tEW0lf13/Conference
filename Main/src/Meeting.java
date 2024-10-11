import java.util.ArrayList;

public class Meeting
{
    public void FindNewFriend(ArrayList<Guest> guests)
    {
        for(int i = 0; i<guests.size(); i++)
        {
            int [] wanted = new int[guests.size()] ;
            for(int x = 0; x<guests.get(i).interests.length; x++)
            {
                String actuallInterest = guests.get(i).interests[x];
                for(int j = 0; j < guests.size(); j++)
                {  
                    if(i==j)
                    {
                        continue;
                    }
                    else
                    {
                        for(int y = 0; y < guests.get(j).trait.length; y++)
                        {
                            if(actuallInterest.equals(guests.get(j).trait[y]))
                            {
                                wanted[j]++;
                            }
                        }
                    }   
                                   
                }
            }
        }
    }
}