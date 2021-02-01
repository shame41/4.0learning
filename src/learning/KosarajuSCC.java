package learning;

public class KosarajuSCC
{
	private boolean[] marked;		//已访问过的节点
	private int[] id;				//强连通分量的标识符
	private int count;				//强连通分量的数量
	
	public KosarajuSCC(Digraph G)
	{
		marked = new boolean[G.V()];
		id = new int[G.V()];
		DepthFirstOrder order = new DepthFirstOrder(G.reverse());
		for(int s : order.reversePost())//逆后序排列的顺序相当于所有已经走过的顶点的逆序
			if(!marked[s])
			{
				dfs(G, s);
				count++;
			}
	}
	private void dfs(Digraph G, int v)
	{
		marked[v] = true;
		id[v] = count;
		for(int w : G.adj(v))
			if(!marked[w])
				dfs(G, w);
	}
	public boolean stronglyConnected(int v, int w)
	{
		return id[v] == id[w];
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
