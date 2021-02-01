package learning;

//有向图的可达性
public class DirectedDFS
{
	private boolean[] marked;
	
	public DirectedDFS(Digraph G, int s)
	{
		//图中从s点能到达的所有顶点
		marked = new boolean[G.V()];
		dfs(G, s);
	}
	public DirectedDFS(Digraph G, Iterable<Integer> sources)
	{
		//在G中找到从sources中的所有顶点可到达的所有顶点
		marked = new boolean[G.V()];
		for(int s : sources)
			if(!marked[s])
				dfs(G, s);
	}
	private void dfs(Digraph G, int v)
	{
		marked[v] = true;
		for(int w : G.adj(v))
			if(!marked[w])
				dfs(G, w);
	}
	public boolean marked(int v)
	{
		//v是可以到达的吗
		//并不是很理解这个方法的作用
		return marked[v];
	}
	public static void main(String[] args)
	{
		//

	}

}
