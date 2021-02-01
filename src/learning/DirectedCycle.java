package learning;

//�ж�����ͼ���Ƿ��л�
public class DirectedCycle
{
	private boolean[] marked;
	private int[] edgeTo;
	private LinkListStack<Integer> cycle;	//�����е����ж���
	private boolean[] onStack;				//�ݹ���õ�ջ�����еĶ��㣬Ѱ�һ��ĺ��ģ������ҵ�һ��v��w��w�Ѿ���ջ��ʱ��˵���Ѿ��ҵ���һ������
	
	public DirectedCycle (Digraph G)
	{
		onStack = new boolean[G.V()];
		edgeTo = new int[G.V()];
		marked = new boolean[G.V()];
		for(int v = 0; v<G.V(); v++)
			if(!marked[v])
				dfs(G, v);
	}
	private void dfs(Digraph G, int v)
	{
		onStack[v] = true;
		marked[v] = true;
		for(int w : G.adj(v))
			if(this.hasCycle())
				return;
			else if(!marked[w])
			{
				edgeTo[w] = v;
				dfs(G, w);
			}
			else if(onStack[w])
			{
				cycle = new LinkListStack<Integer>();
				for(int x = v; x != w; x = edgeTo[x])
					cycle.push(x);
				cycle.push(w);
				cycle.push(v);
			}
		onStack[v] = false;
	}
	public boolean hasCycle()
	{
		return cycle != null;
	}
	public Iterable<Integer> cycle()
	{
		return cycle;
	}
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
