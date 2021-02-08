package learning;

import com.sun.xml.internal.bind.v2.TODO;

public class KruskalMST
{
    private LinkListQueue<Edge> mst;

    public KruskalMST(EdgeWeightedGraph G)
    {
        mst = new LinkListQueue<Edge>();
        MinPQ<Edge> pq = new MinPQ<Edge>(G.V());
        for(Edge e : G.edges())
            pq.insert(e);
        //2021.2.5.02:13  we need union-find class

    }



}
