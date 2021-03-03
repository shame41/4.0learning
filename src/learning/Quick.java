package learning;

import java.util.Random;

public class Quick
{
	public static void sort(Comparable[] a)
	{
		sort(a, 0, a.length -1);
	}
	private static void sort(Comparable[] a, int lo, int hi)
	{
		//��׼�Ŀ�������
		if(hi <= lo)
			return;
		int j = partition(a, lo, hi);//�з֣����ŵĹؼ���
		sort(a, lo, j-1);//���������
		sort(a, j+1, hi);//���ұ�����
	}
	private static void sort3way(Comparable[] a, int lo, int hi)
	{
		//���зֿ�������������������������ͬԪ�ص����������
		if(hi <= lo)
			return;
		int lt = lo, i = lo + 1, gt = hi;
		Comparable v = a[lo];
		while(i <= gt)
		{
			int cmp = a[i].compareTo(v);
			if		(cmp < 0)
				exch(a, lt++, i++);//�����
			else if (cmp > 0)
				exch(a, i, gt--);//���ұ�
			else
				i++;//����ԭ�أ�֮�����������м�
		}//���ѭ��ʵ����a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi]
		sort(a, lo, lt - 1);
		sort(a, gt + 1, hi);
	}
	private static int partition(Comparable[] a, int lo, int hi)
	{
		int i = lo, j = hi + 1;//��ָ������ָ��
		Comparable v = a[lo];  //�з�Ԫ��
		while(true)
		{
			while(less(a[++i], v) )
				if(i == hi) break;
			//������ɨ���ҳ���һ�������з�Ԫ�صĵ�Ԫ
			while(less(v, a[--j]) )
				if(j == lo) break;
			//���ҵ���ɨ���ҳ���һ��С���з�Ԫ�صĵ�Ԫ
				
			if(i >= j) break;
			exch(a, i, j);//����������Ԫ
		}
		//ע���ʱ�з�Ԫ����Ȼ���ڵ�һ��λ�ã������һ��Ҫ�����ŵ��м䣬��i,j�Ѿ����м����������Է���j��
		exch(a, lo, j);//��v = a[j]������ȷ��λ��
		return j;
	}
	private static boolean less(Comparable v, Comparable w)
	{	return v.compareTo(w) < 0;	}
	private static void exch(Comparable[] a, int i, int j)
	{	Comparable t = a[i]; a[i] = a[j]; a[j] = t;	}
	private static void show(Comparable[] a)
	{
		//�ڵ����д�ӡ����
		for(int i = 0; i<a.length; i++)
			System.out.print(a[i]+" ");
	}
	public static boolean isSorted(Comparable[] a)
	{
		//��������Ԫ���Ƿ�����
		for (int i=0; i<a.length; i++)
			if(less(a[i],a[i-1]))	return false;
		return true;
	}
	
	public static void main(String[] args)
	{
		Random r = new Random(1);
		Integer[] a = new Integer[100];
		for (int i = 0; i<a.length; i++)
		{
			a[i] = r.nextInt()%1000;
		}
		for(Integer i : a)
			System.out.println(i);
		System.out.println("now let's sort it!");
		Quick.sort(a);
		for(Integer i : a)
			System.out.println(i);

	}

}
