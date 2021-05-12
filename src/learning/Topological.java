package learning;

//”–œÚÕºÕÿ∆À≈≈–Ú
public class Topological
{
	private Iterable<Integer> order;		//∂•µ„µƒÕÿ∆À≈≈–Ú
	
	public Topological(Digraph G)
	{
		DirectedCycle cyclefinder = new DirectedCycle(G);
		if(!cyclefinder.hasCycle())
		{
			DepthFirstOrder dfs = new DepthFirstOrder(G);
			order = dfs.reversePost();
		}
	}
	public Topological(EdgeWeightedDigraph G)
	{
		EdgeWeightedDiCycle cyclefinder = new EdgeWeightedDiCycle(G);
		if(!cyclefinder.hasCycle())
		{
			EdgeWeightedDiDFO dfs = new EdgeWeightedDiDFO(G);
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
