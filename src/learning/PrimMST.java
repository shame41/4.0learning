package learning;

public class PrimMST
{
    private Edge[] edgeTo;          //the edge closest to ST
    private double[] distTo;        //distTO[w] = edgeTo[w].weight();
    private boolean[] marked;       //true when v is in the ST
    private IndexMinPQ<Double> pq;  //effective cross-cutting edge

    public PrimMST(EdgeWeightedGraph G)
    {
        edgeTo = new Edge[G.V()];
        distTo = new double[G.V()];
        marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++)
            distTo[v] = Double.POSITIVE_INFINITY;
        pq = new IndexMinPQ<Double>(G.V());

        distTo[0] = 0.0;
        pq.insert(0,0.0);       //initialize pq with vertex 0 and weight 0
        while (!pq.isEmpty())
            visit(G, pq.delMin());      //add the nearest vertex to the ST

    }
    private void visit(EdgeWeightedGraph G, int v)
    {
        //add vertex v to the tree to refresh data
        marked[v] = true;
        for (Edge e : G.adj(v))
        {
            int w = e.other(v);
            if (marked[w])
                continue;       //v & w become invalid
            if (e.weight() < distTo[w])
            {
                //the most suited Edge connecting w and ST becomes e
                edgeTo[w] = e;

                distTo[w] = e.weight();
                if (pq.contains(w))         //refresh the MinPQ
                    pq.change(w, distTo[w]);
                else
                    pq.insert(w, distTo[w]);
            }
        }
    }
    public Iterable<Edge> edges()
    {
        Bag<Edge> mst = new Bag<Edge>();
        for (int v = 1; v<edgeTo.length; v++)
            mst.add(edgeTo[v]);
        return mst;
    }
}
