package learning;

public class DijkstraSP
{
    private DirectedEdge[] edgeTo;          //this vertex's last vertex's path to this vertex
    private double[] distTo;                //the starting point to this vertex's shortest distance
    private IndexMinPQ<Double> pq;          //a priority queue to keep weight to know which edge is lighter

    public DijkstraSP(EdgeWeightedDigraph G, int s)
    {
        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];
        pq = new IndexMinPQ<Double>(G.V());
        for (int v = 0; v < G.V(); v++)
            distTo[v] = Double.POSITIVE_INFINITY;
        distTo[s] = 0.0;
        pq.insert(s, 0.0);
        while (!pq.isEmpty())
            relax(G, pq.delMin());
    }

    private void relax(EdgeWeightedDigraph G, int v)
    {
        for (DirectedEdge e : G.adj(v))
        {
            int w = e.to();
            if (distTo[w] > distTo[v] + e.weight())
            {
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
                if (pq.contains(w))
                    pq.change(w, distTo[w]);
                else
                    pq.insert(w, distTo[w]);
            }
        }
    }
    public double distTo(int v)
    {
        return distTo[v];
    }
    public boolean hasPathTo(int v)
    {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }
    public Iterable<DirectedEdge> pathTo(int v)
    {
        if(!hasPathTo(v))
            return null;
        LinkListStack<DirectedEdge> path = new LinkListStack<DirectedEdge>();
        for(DirectedEdge e = edgeTo[v]; e!=null; e = edgeTo[e.from()])
            path.push(e);
        return path;
    }
    public static void main(String[] argv)
    {
        EdgeWeightedDigraph a = new EdgeWeightedDigraph(10);
        System.out.println(a.V());
        DijkstraSP S = new DijkstraSP(a, 1);
        for(int t = 0; t < a.V(); t++)
        {
            System.out.println(S + " to " + t);
            System.out.printf("(%4.2f):", S.distTo(t));
            if(S.hasPathTo(t))
                for(DirectedEdge e : S.pathTo(t))
                    System.out.print(e + " ");
                System.out.println();
        }
    }
}
