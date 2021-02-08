package learning;
//索引优先队列
public class IndexMinPQ<Key extends Comparable<Key>>
{
	private int N;				//amount of the elements in PQ
	private int[] pq;			//index binary heap, begin at '1'
	private int[] qp;			//inverted pq : qp[pq[i]] = pq[qp[i]] = i
	private Key[] keys;			//elements with priority
	public IndexMinPQ(int maxN)
	{
		keys = (Key[]) new Comparable[maxN + 1];
		pq = new int[maxN + 1];
		qp = new int[maxN + 1];
		for(int i = 0; i <= maxN; i++)
			qp[i] = -1;
	}
	private void exch(int i, int j)
	{
		Key t = keys[i];
		keys[i] = keys[j];
		keys[j] = t;
	}
	private void swim(int k)//上浮
	{
		while(k>1 && bigger(k/2, k))
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
			if(j<N && bigger(j, j+1))
				j++;
			if(!bigger(k, j))
				break;
			exch(k, j);
			k = j;
		}
	}
	private boolean bigger(int i, int j)
	{
		return keys[i].compareTo(keys[j]) > 0;
	}
	public boolean isEmpty()
	{
		return N == 0;
	}
	public boolean contains(int k)
	{
		return qp[k] != -1;
	}
	public void insert(int k, Key key)
	{
		N++;
		qp[k] = N;
		pq[N] = k;
		keys[k] = key;
		swim(N);
	}
	public Key min()
	{
		return keys[pq[1]];
	}
	public int delMin()
	{
		int indexOfMin = pq[1];
		exch(1, N--);
		sink(1);
		keys[pq[N+1]] = null;
		qp[pq[N+1]] = -1;
		return indexOfMin;
	}

	public int minIndex()
	{
		return pq[1];
	}
	public void change(int k, Key key)
	{
		keys[k] = key;
		swim(qp[k]);
		sink(qp[k]);
	}
	public void delete(int k)
	{
		int index = qp[k];
		exch(index, N--);
		swim(index);
		sink(index);
		keys[k] = null;
		qp[k] = -1;
	}
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
