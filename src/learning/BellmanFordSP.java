package learning;

public class BellmanFordSP {
    private double[] distTo;
    private DirectedEdge[] edgeTo;
    private boolean[] onQ;                      //to describe whether the vertex is in the queue
    private LinkListQueue<Integer> queue;       //keep the vertex to relax
    private int cost;                           //the amount of times the relax() was performed
    private Iterable<DirectedEdge> cycle;       //is there a negative weighted edge in the edgeTo[]

    public BellmanFordSP(EdgeWeightedDigraph G, int s) {
        distTo = new double[G.V()];
        edgeTo = new DirectedEdge[G.V()];
        onQ = new boolean[G.V()];
        queue = new LinkListQueue<Integer>();
        for (int v = 0; v < G.V(); v++)
            distTo[v] = Double.POSITIVE_INFINITY;
        distTo[s] = 0.0;
        queue.enqueue(s);
        onQ[s] = true;
        while (!queue.isEmpty() && !hasNegativeCycle()) {
            int v = queue.dequeue();
            onQ[v] = false;
            relax(G, v);
        }
    }

    private void relax(EdgeWeightedDigraph G, int v) {
        for (DirectedEdge e : G.adj(v)) {
            int w = e.to();
            if (distTo[w] > distTo[v] + e.weight()) {
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
                if (!onQ[w]) {
                    queue.enqueue(w);
                    onQ[w] = true;
                }
            }
            if (cost++ % G.V() == 0)
                findNegativeCycle();
        }
    }

    private void findNegativeCycle()
    {
        int V = edgeTo.length;
        EdgeWeightedDigraph spt;
        spt = new EdgeWeightedDigraph(V);
        for(int v = 0; v < V; v++)
            if(edgeTo[v] != null)
                spt.addEdge(edgeTo[v]);
        EdgeWeightedDiCycle cf;
        cf = new EdgeWeightedDiCycle(spt);

    }
    public boolean hasNegativeCycle()
    {
        return cycle != null;
    }

}
