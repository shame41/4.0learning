package learning;

//Weighte deges
public class Edge implements Comparable<Edge>
{
    private final int v;                    //one of the vertices
    private final int w;                    //another vertices
    private final double weight;            //weights of edges

    public Edge(int v, int w, double weight)
    {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }
    public double weight()
    {
        return weight;
    }
    public int either(){return v;}//to get one of the vertices of the two segments of the edge
    public int other(int vertex)
    {
        if      (vertex == v)   return w;
        else if (vertex == w)   return v;
        else
            throw new RuntimeException("Inconsistent edge");
    }
    public String toString()
    {
        return String.format("%d-%d %.2f ", v,w,weight);
    }

    @Override
    public int compareTo(Edge that) //the method to know which Edge's weight is bigger
    {
        if      (this.weight() < that.weight())
            return -1;
        else if (this.weight() > that.weight())
            return +1;
        else
            return 0;
    }
}
