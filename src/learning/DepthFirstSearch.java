package learning;

public class DepthFirstSearch
{
	//��֤��ͨ��
	private boolean[] marked;
	private int count;		//·��������
	
	public DepthFirstSearch(Graph G, int s)
	{
		marked = new boolean[G.V()];
		dfs(G, s);
	}
	private void dfs(Graph G, int v)
	{
		//�ж�ͼ����v�ڵ���ͨ�Ľڵ����ļ���
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
