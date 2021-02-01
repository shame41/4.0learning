package learning;

//����ͼ�Ŀɴ���
public class DirectedDFS
{
	private boolean[] marked;
	
	public DirectedDFS(Digraph G, int s)
	{
		//ͼ�д�s���ܵ�������ж���
		marked = new boolean[G.V()];
		dfs(G, s);
	}
	public DirectedDFS(Digraph G, Iterable<Integer> sources)
	{
		//��G���ҵ���sources�е����ж���ɵ�������ж���
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
		//v�ǿ��Ե������
		//�����Ǻ�����������������
		return marked[v];
	}
	public static void main(String[] args)
	{
		//

	}

}
