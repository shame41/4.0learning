package learning;

public class Graph
{
	private final int V;		//������Ŀ
	private int E;				//�ߵ���Ŀ
	public Bag<Integer>[] adj;	//�ڽӱ�
	public Graph(int V)
	{
		//����һ��������ĿΪV��ͼ
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
