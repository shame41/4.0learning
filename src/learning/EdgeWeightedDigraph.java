package learning;

public class EdgeWeightedDigraph
{
    private final int V;		//amount of vertex
    private int E;				//amount of edgehttps://github.com/shame41/4.0learning.gits
    private Bag<DirectedEdge>[] adj;//adjacency list

    public EdgeWeightedDigraph(int V)
    {
        this.V = V;
        this.E = 0;
        adj = (Bag<DirectedEdge>[])  new Bag[V];
        for (int v = 0; v<V; v++)
            adj[v] = new Bag<DirectedEdge>();
    }
    public int V() {return V;}
    public int E() {return E;}

    public void addEdge(DirectedEdge e)
    {
        //add edge e to the EdgeWeightedDigraph
        adj[e.from()].add(e);
        E++;
    }

    public Iterable<DirectedEdge> adj(int v)
    {
        //return the edge which comes from v
        return adj[v];
    }
    public Iterable<DirectedEdge> edges()
    {
        //return every edge in this EdgeWeightedDigraph
        Bag<DirectedEdge> bag = new Bag<DirectedEdge>();
        for(int v = 0; v < V; v++)
            for(DirectedEdge e : adj[v])
                bag.add(e);
        return bag;
    }

}
