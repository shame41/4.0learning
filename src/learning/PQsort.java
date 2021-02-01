package learning;

public class PQsort
{
	public static void sort(Comparable[] a)
	{
		//堆排序
		int N = a.length;
		Comparable[] pb = new Comparable[N+1]; 
		for(int i=0; i<N; i++)
			pb[i+1] = a[i];
		for(int k = N/2; k >= 1; k--)
			sink(pb, k, N);//用于构造大顶堆
		while(N > 1)
		{
			exch(pb, 1, N--);
			sink(pb, 1, N);
		}
		for(int i=0; i<a.length; i++)
			a[i] = pb[i+1];
	}
	private static void sink(Comparable[] a, int k, int N)
	{
		while(2*k <= N)
		{
			int j = 2*k;
			if(j<N && less(a, j, j+1))
				j++;
			if(!less(a, k, j))
				break;
			exch(a, k, j);
			k = j;
		}
	}
	private static boolean less(Comparable[] pq, int i, int j)
	{
		return pq[i].compareTo(pq[j]) < 0;
	}
	private static void exch(Comparable[] pq, int i, int j)
	{
		Comparable t = pq[i];
		pq[i] = pq[j];
		pq[j] = t;
	}
	private static void show(Comparable[] a)
	{
		//在单行中打印数组
		for(int i = 0; i<a.length; i++)
			System.out.print(a[i]+" ");
	}
	public static void main(String[] args)
	{
		Integer[] a = {19,15,18,20,5,24,1,13,16,12,5};
		sort(a);
		show(a);
	}

}
