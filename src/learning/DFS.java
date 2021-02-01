package learning;

import java.util.Stack;

public class DFS
{
	private boolean[] marked;		//��������ϵ��ù�dfs()��
	private int[] edgeTo;			//����㵽һ���������֪·���ϵ����һ������
	private final int s;			//���
	
	public DFS(Graph G, int s)
	{
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		dfs(G, s);
	}
	private void dfs(Graph G, int v)
	{
		marked[v] = true;
		for(int w : G.adj(v))
			if(!marked[w])
			{
				edgeTo[w] = v;
				dfs(G, w);
			}
	}
	
	public boolean hasPathTo(int v)
	{
		return marked[v];
	}
	public Iterable<Integer> pathTo(int v)
	{
		if(!hasPathTo(v))
			return null;
		Stack<Integer> path = new Stack<Integer>();
		for(int x = v; x!= s; x = edgeTo[x])
			path.push(x);
		path.push(s);
		return path;
	}
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}