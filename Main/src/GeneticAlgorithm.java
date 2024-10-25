import java.util.ArrayList;
import java.util.Random;
public class GeneticAlgorithm
{   
    int generation;
    Random random = new Random();
    ArrayList<Guest>wanted = new ArrayList<>();
    Guest seeker;
    int lastChange;
    int bestSubject;
    HardCodeDestroyer hard;
    public ArrayList<ArrayList<String>> NewGenerationStarter(ArrayList<Guest> guests)   //Here everything started
    {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        for(int i = 0; i<guests.size(); i++)
        {
            wanted.clear();
            wanted.addAll(guests);
            seeker = wanted.get(i);
            wanted.remove(i);
            lastChange = 0;
            bestSubject = 0; 
            generation = -1;
            result.add(newSubjectGenerator());  
        } 
        return result;
    }  
    private ArrayList<String> newSubjectGenerator() //Here we create subjects for our family
    {
        ArrayList<Family>subjects = new ArrayList<>();
        boolean[] genes;
        int genStrong;
        for(int i = 0; i<100; i++)
        {
            genes = InOrOut(wanted.size());
            genStrong = Fitness(genes);
            subjects.add(new Family(genes, genStrong));  
        }
        return Generaton(subjects);
    }
    
    private ArrayList<String> Generaton(ArrayList<Family> subjects) //Here are all generation we create
    {    
        boolean[] bestGenotype = new boolean[wanted.size()];
        while(generation<hard.NumberOfGeneration())
        {    
            generation++;
            lastChange++;   
            if(lastChange>hard.lastChange()&&bestSubject >= 5)  // Second one (bestSubject >= 5) has to stay like it is because we cannot change it.
            {
                break;
            }
            if(subjects.get(0).getGenesPower()>bestSubject)
                {          
                    bestSubject = subjects.get(0).getGenesPower();
                    bestGenotype = subjects.get(0).getGenes();
                    lastChange = 0;
                }
            subjects = Selection(subjects);    
        }
        ArrayList<String>resultNames = new ArrayList<>();
        resultNames.add(seeker.getName());
        int trueCounter = 0;
        for(int i = 0; i<bestGenotype.length; i++)
        {
            if(bestGenotype[i]==true)
            {
                trueCounter++;
                resultNames.add(wanted.get(i).getName());
            }
        }
        for(int i = 0; i<bestGenotype.length; i++)
        {
            if(trueCounter >= 5)
            {
                break;
            }
            else if(bestGenotype[i]==false)
            {
                trueCounter++;
                resultNames.add(wanted.get(i).getName());
            }
        }
        return resultNames;
    }

    private boolean [] InOrOut(int size)
    { 
        boolean [] genes = new boolean[size];
        for(int i = 0; i<size; i++)
        {
            genes[i] = random.nextInt(wanted.size()) <= 5;
        }
        return genes;
    }

    private int Fitness(boolean[] genes)    //Here we confirm strong of the genes
    {
        String[]actualInterests = seeker.getInterests();
        int fitness = 0;
        int trueCount = 0;
        for(int i = 0; i<actualInterests.length; i++)
        {
            for(int j = 0; j<wanted.size(); j++)
            {
                if(genes[j]==false)
                {
                }
                else
                {
                    trueCount++;
                    if(trueCount>5&&i==0)
                    {
                        return 0;
                    }
                    for (String trait : wanted.get(j).getTrait()) {
                        if (actualInterests[i].equals(trait)) {
                            fitness++;
                        }
                    }
                }
                
            }
        }
        return fitness;
    }

    private ArrayList<Family> Selection(ArrayList<Family>sub)   //We are selecting the best subjects here
    {
        ArrayList<Family>bestSubjects = new ArrayList<>();
        ArrayList<Family>newSubjects = new ArrayList<>();
        for(int i = 0; i<100; i++)
        {
            if(sub.get(i).getGenesPower()>0)
            {
                bestSubjects.add(sub.get(i));
            }
        }
        for(int i = 0; i<100; i++)
        {
            int subject1 = 0;
            int subject2 = 0;
            while (subject1==subject2) {
                subject1 = random.nextInt(bestSubjects.size());
                subject2 = random.nextInt(bestSubjects.size());
            }
            Family first = bestSubjects.get(subject1);
            Family second = bestSubjects.get(subject2);
            newSubjects.add(Crossover(first,second));
            if(i>89)
            {
                newSubjects.add(new Family(sub.get(i-90).getGenes(), Fitness(sub.get(i-90).getGenes())));
            }
        }
        
        return newSubjects;
    }

    private Family Crossover(Family first, Family second)   //We cross genes randomly here
    { 
        int cut = random.nextInt(first.getGenes().length-1);
        boolean[] childGen = new boolean[first.getGenes().length];
        for(int i = 0; i<first.getGenes().length; i++)
        {
            if(i<cut)
            {
                childGen[i]=first.getGenes()[i];
            }
            else
            {
                childGen[i]=second.getGenes()[i];
            }

        }
        boolean[] newSub = Mutation(childGen);
        return new Family(newSub, Fitness(newSub));
    }

    private boolean[] Mutation(boolean[] gen)   //Randomly the code switch one chromosome from 0 to 1 and vice versa
    {
        int mutationPos = random.nextInt(gen.length-1);
        gen[mutationPos] = gen[mutationPos]==false;
        return gen;
    }
}