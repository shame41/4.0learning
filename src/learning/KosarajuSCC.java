package learning;

public class KosarajuSCC
{
	private boolean[] marked;		//�ѷ��ʹ��Ľڵ�
	private int[] id;				//ǿ��ͨ�����ı�ʶ��
	private int count;				//ǿ��ͨ����������
	
	public KosarajuSCC(Digraph G)
	{
		marked = new boolean[G.V()];
		id = new int[G.V()];
		DepthFirstOrder order = new DepthFirstOrder(G.reverse());
		for(int s : order.reversePost())//��������е�˳���൱�������Ѿ��߹��Ķ��������
			if(!marked[s])
			{
				dfs(G, s);
				count++;
			}
	}
	private void dfs(Digraph G, int v)
	{
		marked[v] = true;
		id[v] = count;
		for(int w : G.adj(v))
			if(!marked[w])
				dfs(G, w);
	}
	public boolean stronglyConnected(int v, int w)
	{
		return id[v] == id[w];
	}
	public int id(int v)
	{
		return id[v];
	}
	public int count()
	{
		return count;
	}
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
