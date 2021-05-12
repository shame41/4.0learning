package learning;

public class Digraph extends Graph
{
	private final int V;		//顶点总数
	private int E;				//边的总数
	private Bag<Integer>[] adj;	//此顶点的出度
	
	public Digraph(int V)
	{
		super(V);
		this.V = V;
		this.E = 0;
		adj = (Bag<Integer>[]) new Bag[V];
		for(int v = 0; v<V; v++)
			adj[v] = new Bag<Integer>();
	}
	
	public int V()
	{
		return V;
	}
	public int E()
	{
		return E;
	}
	public void addEdge(int v, int w)
	{
		adj[v].add(w);
		E++;
	}
	public Iterable<Integer> adj(int v)
	{
		return adj[v];
	}
	public Digraph reverse()
	{
		Digraph R = new Digraph(V);
		for(int v = 0; v<V; v++)
			for(int w : adj(v))
				R.addEdge(w, v);
		return R;
	}
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
