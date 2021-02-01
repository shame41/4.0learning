package learning;

public class Insertion
{
	public static void sort(Comparable[] a)
	{
		//��a[]����������
		int N = a.length;
		for(int i=1; i<N; i++)
		{	//��һ��Ԫ���Ѿ��ź�
			//��δ�����Ԫ��һ��һ���������źõĲ�����
			for(int j = i; j>0 && less(a[j],a[j-1]); j--)
				exch(a, j, j-1);//��a[]���ҵ����ʵ�λ�ò��벢����ߵ�Ԫ��������
			//��һ�����Ǻܺ���⣬���������Լ���һ��
		}
	}
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

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
	
}
