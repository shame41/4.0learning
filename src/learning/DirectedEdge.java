package learning;

public class DirectedEdge
{
    private final int v;            //the starting point of the edge
    private final int w;            //the ending point of the edge
    private final double weight;    //the weight of the edge

    public DirectedEdge(int v, int w, double weight)
    {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }
    public double weight()
    {
        return weight;
    }
    public int from()
    {
        return v;
    }
    public int to()
    {
        return w;
    }
    public String toString()
    {
        return String.format("%d->%d %.2f", v, w, weight);
    }

}
