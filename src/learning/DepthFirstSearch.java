package learning;

public class DepthFirstSearch
{
	//验证连通性
	private boolean[] marked;
	private int count;		//路径的数量
	
	public DepthFirstSearch(Graph G, int s)
	{
		marked = new boolean[G.V()];
		dfs(G, s);
	}
	private void dfs(Graph G, int v)
	{
		//判断图中与v节点连通的节点是哪几个
		marked[v] = true;
		count++;
		for(int w : G.adj(v))
			if(!marked[w]) dfs(G , w);
	}
	public boolean marked(int w)
	{
		return marked[w];
	}
	public int count()
	{
		return count;
	}
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Graph g = new Graph(6);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(0, 5);
		g.addEdge(2, 1);
		g.addEdge(2, 3);
		g.addEdge(2, 4);
		g.addEdge(3, 4);
		g.addEdge(3, 5);
		DepthFirstSearch gg = new DepthFirstSearch(g, 2);
		
	}

}
