package learning;

public class LazyPrimMST
{
    private boolean[] marked;           //the vertices of MST
    private LinkListQueue<Edge> mst;    //the edge of MST
    private MinPQ<Edge> pq;             //the Edge which can devide two tree(including the failed part)

    public LazyPrimMST(EdgeWeightedGraph G)
    {
        pq = new MinPQ<Edge>(G.E());
        marked = new boolean[G.V()];
        mst = new LinkListQueue<>();

        visit(G, 0);            //suppose G is connected
        while (!pq.isEmpty())
        {
            Edge e = pq.delMin();   //find the edge which has the least weight from pq

            int v = e.either();
            int w = e.other(v);
            if(marked[v] && marked[w])
                continue;   //skip failed edge
            mst.enqueue(e); //add the edge to MST
            if(!marked[v])
                visit(G, v);//add the vertex(v or w) to MST
            if(!marked[w])
                visit(G, w);
        }
    }

    private void visit(EdgeWeightedGraph G, int v)
    {
        //mark the vertex v and add the edge which have connected vertex v and add all the edges whose vertices  have never been marked
        marked[v] = true;
        for(Edge e : G.adj(v))
            if(!marked[e.other(v)])
                pq.insert(e);
    }
    public Iterable<Edge> edges()
    {
        return mst;
    }

}
