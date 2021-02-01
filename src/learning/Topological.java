package learning;

//ÓĞÏòÍ¼ÍØÆËÅÅĞò
public class Topological
{
	private Iterable<Integer> order;		//¶¥µãµÄÍØÆËÅÅĞò
	
	public Topological(Digraph G)
	{
		DirectedCycle cyclefinder = new DirectedCycle(G);
		if(!cyclefinder.hasCycle())
		{
			DepthFirstOrder dfs = new DepthFirstOrder(G);
			order = dfs.reversePost();
		}
	}
	public Iterable<Integer> order()
	{
		return order;
	}
	public boolean isDAG()
	{
		return order != null;
	}
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
