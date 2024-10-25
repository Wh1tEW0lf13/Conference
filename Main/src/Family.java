public class Family
{
    private final boolean[] genes;
    private final int genesPower;
    public Family(boolean[] genes, int genesPower)
    {
        this.genes = genes;
        this.genesPower = genesPower;
    }

    public boolean[] getGenes()
    {
        return genes;
    }

    public int getGenesPower()
    {
        return genesPower;
    }
}