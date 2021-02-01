package learning;

//基于深度优先搜索实现的找出连通分量

public class CC
{
	private boolean[] marked;
	private int[] id;
	private int count;
	
	public CC(Graph G)
	{
		marked = new boolean[G.V()];	//用于标记各个顶点是否已经被访问
		id = new int[G.V()];			//
		for(int s = 0; s < G.V(); s++)
			if(!marked[s])
			{
				dfs(G, s);				//对没有被标记过的顶点进行深度优先搜索，如果搜索进行到结束，count加一，代表形成了一个连通分量
				count++;
			}
	}
	private void dfs(Graph G, int v)
	{
		marked[v] = true;
		id[v] = count;				//如果v属于第i个连通分量，则id[v]的值为i	
		for(int w : G.adj(v))
			if(!marked[w])
				dfs(G, w);
	}
	public boolean connected(int v, int w)
	{
		return id[v] == id[w];		//如果两个顶点处于同一个连通分量中，那么这两个顶点是connected
	}
	public int id(int v)
	{
		return id[v];
	}
	public int count()
	{
		return count;
	}
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
