package learning;

public class Graph
{
	private final int V;		//顶点数目
	private int E;				//边的数目
	public Bag<Integer>[] adj;	//邻接表
	public Graph(int V)
	{
		//创建一个顶点数目为V的图
		this.V = V;
		this.E = 0;
		adj = (Bag<Integer>[]) new Bag[V];
		for(int v = 0; v<V; v++)
			adj[v] = new Bag<Integer>();
	}
//	public Graph(In in)
//	{
//		
//	}
	public int V() {return V;}
	public int E() {return E;}
	public void addEdge(int v, int w)
	{
		adj[v].add(w);
		adj[w].add(v);
		E++;
	}
	public Iterable<Integer> adj(int v)
	{
		return adj[v];
	}
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
