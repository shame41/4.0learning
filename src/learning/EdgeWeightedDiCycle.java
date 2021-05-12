package learning;

public class EdgeWeightedDiCycle
{
    private boolean[] marked;
    private int[] edgeTo;
    private LinkListStack<Integer> cycle;	//有向环中的所有顶点
    private boolean[] onStack;				//递归调用的栈上所有的顶点，寻找环的核心，当它找到一条v→w且w已经在栈中时，说明已经找到了一个有向环

    public EdgeWeightedDiCycle (EdgeWeightedDigraph G)
    {
        onStack = new boolean[G.V()];
        edgeTo = new int[G.V()];
        marked = new boolean[G.V()];
        for(int v = 0; v<G.V(); v++)
            if(!marked[v])
                dfs(G, v);
    }
    private void dfs(EdgeWeightedDigraph G, int v)
    {
        onStack[v] = true;
        marked[v] = true;
        for(DirectedEdge w : G.adj(v))
            if(this.hasCycle())
                return;
            else if(!marked[w.to()])
            {
                edgeTo[w.to()] = v;
                dfs(G, w.to());
            }
            else if(onStack[w.to()])
            {
                cycle = new LinkListStack<Integer>();
                for(int x = v; x != w.to(); x = edgeTo[x])
                    cycle.push(x);
                cycle.push(w.to());
                cycle.push(v);
            }
        onStack[v] = false;
    }
    public boolean hasCycle()
    {
        return cycle != null;
    }
    public Iterable<Integer> cycle()
    {
        return cycle;
    }
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        EdgeWeightedDigraph a = new EdgeWeightedDigraph(4);
        a.connect(0,1,12.0);
        a.connect(1,2,10.0);
        a.connect(2,3,11.1);
        EdgeWeightedDiCycle b = new EdgeWeightedDiCycle(a);
        System.out.println(b.hasCycle());
    }
}
