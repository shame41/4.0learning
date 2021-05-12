package learning;

public class EdgeWeightedDiDFO
{
    private boolean[] marked;
    private LinkListQueue<Integer> pre;			//所有顶点的前序排列
    private LinkListQueue<Integer> post;		//所有顶点的后序排列
    private LinkListStack<Integer> reversePost;	//所有顶点的逆后序排列

    public EdgeWeightedDiDFO(EdgeWeightedDigraph G)
    {
        pre = new LinkListQueue<Integer>();
        post = new LinkListQueue<Integer>();
        reversePost = new LinkListStack<Integer>();
        marked = new boolean[G.V()];

        for(int v = 0; v<G.V(); v++)//起点是0
            if(!marked[v])
                dfs(G,v);
    }
    private void dfs(EdgeWeightedDigraph G, int v)
    {
        pre.enqueue(v);

        marked[v] = true;
        for(DirectedEdge w : G.adj(v))
            if(!marked[w.to()])
                dfs(G, w.to());
        post.enqueue(v);
        reversePost.push(v);
    }
    public Iterable<Integer> pre()
    {
        return pre;
    }
    public Iterable<Integer> post()
    {
        return post;
    }
    public Iterable<Integer> reversePost()
    {
        return reversePost;
    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }
}
