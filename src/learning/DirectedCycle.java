package learning;

//判断有向图中是否有环
public class DirectedCycle
{
	private boolean[] marked;
	private int[] edgeTo;
	private LinkListStack<Integer> cycle;	//有向环中的所有顶点
	private boolean[] onStack;				//递归调用的栈上所有的顶点，寻找环的核心，当它找到一条v→w且w已经在栈中时，说明已经找到了一个有向环
	
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
