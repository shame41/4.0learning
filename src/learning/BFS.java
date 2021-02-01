package learning;

import java.util.Stack;

public class BFS
{
	private boolean[] marked;		//����ö�������·����֪��
	private int[] edgeTo;			//����ö������֪·���ϵ����һ������
	private final int s;			//���
	
	public BFS(Graph G, int s)
	{
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		bfs(G, s);
	}
	private void bfs(Graph G, int s)
	{
		LinkListQueue<Integer> queue = new LinkListQueue<Integer>();
		marked[s] = true;		//������
		queue.enqueue(s);		//�����������
		while(!queue.isEmpty())
		{
			int v = queue.dequeue();//�Ӷ�����ɾȥ��һ������
			for(int w : G.adj(v))
				if(!marked[w])
				{
					edgeTo[w] = v;		//�������·�������һ����
					marked[w] = true;	//���������Ϊ���·����֪
					queue.enqueue(w);	//���������������
				} 
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
