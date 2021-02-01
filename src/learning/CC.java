package learning;

//���������������ʵ�ֵ��ҳ���ͨ����

public class CC
{
	private boolean[] marked;
	private int[] id;
	private int count;
	
	public CC(Graph G)
	{
		marked = new boolean[G.V()];	//���ڱ�Ǹ��������Ƿ��Ѿ�������
		id = new int[G.V()];			//
		for(int s = 0; s < G.V(); s++)
			if(!marked[s])
			{
				dfs(G, s);				//��û�б���ǹ��Ķ�����������������������������е�������count��һ�������γ���һ����ͨ����
				count++;
			}
	}
	private void dfs(Graph G, int v)
	{
		marked[v] = true;
		id[v] = count;				//���v���ڵ�i����ͨ��������id[v]��ֵΪi	
		for(int w : G.adj(v))
			if(!marked[w])
				dfs(G, w);
	}
	public boolean connected(int v, int w)
	{
		return id[v] == id[w];		//����������㴦��ͬһ����ͨ�����У���ô������������connected
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
