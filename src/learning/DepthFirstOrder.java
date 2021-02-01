package learning;

//����ͼ�������������ʵ�ֵĶ�������
public class DepthFirstOrder
{
	private boolean[] marked;
	private LinkListQueue<Integer> pre;			//���ж����ǰ������
	private LinkListQueue<Integer> post;		//���ж���ĺ�������
	private LinkListStack<Integer> reversePost;	//���ж�������������
	
	public DepthFirstOrder(Digraph G)
	{
		pre = new LinkListQueue<Integer>();
		post = new LinkListQueue<Integer>();
		reversePost = new LinkListStack<Integer>();
		marked = new boolean[G.V()];
		
		for(int v = 0; v<G.V(); v++)//�����0
			if(!marked[v])
				dfs(G,v);
	}
	private void dfs(Digraph G, int v)
	{
		pre.enqueue(v);
		
		marked[v] = true;
		for(int w : G.adj(v))
			if(!marked[w])
				dfs(G, w);
		post.enqueue(v);
		reversePost.push(v);
	}
	public Iterable<Integer> pre()
	{
		return pre;
	}
	public Iterable<Integer> post()
	{
		return post;
	}
	public Iterable<Integer> reversePost()
	{
		return reversePost;
	}
 	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
