package learning;

public class MaxPQ<Key extends Comparable<Key>>
{
	//基于堆的优先队列
	private Key[] pq;	//基于堆的完全二叉树
	private int N = 0;	//储存于pq[1..N]中，pq[0]没有使用
	
	public MaxPQ(int maxN)
	{
		pq = (Key[]) new Comparable[maxN+1];
	}
	public boolean isEmpty()
	{
		return N == 0;
	}
	public void insert(Key v)
	{
		pq[++N] = v;
		swim(N);
	}
	public Key delMax()
	{
		Key max = pq[1];
		exch(1, N--);
		pq[N+1] = null;
		sink(1);
		return max;
	}
	
	private boolean less(int i, int j)
	{
		return pq[i].compareTo(pq[j]) < 0;
	}
	private void exch(int i, int j)
	{
		Key t = pq[i];
		pq[i] = pq[j];
		pq[j] = t;
	}
	private void swim(int k)//上浮
	{
		while(k>1 && less(k/2, k))
		{
			exch(k/2, k);
			k = k/2;
		}
	}
	private void sink(int k)
	{
		while(2*k <= N)
		{
			int j = 2*k;
			if(j<N && less(j, j+1))
				j++;
			if(!less(k, j))
				break;
			exch(k, j);
			k = j;
		}
	}
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		MaxPQ<Integer> a = new MaxPQ(10);
		a.insert(9);
		a.insert(6);
		a.insert(3);
		a.insert(12);
		a.insert(2);
	}

}
