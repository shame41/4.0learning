package learning;

public class Selection
{
	public static void sort(Comparable[] a)//ָ�����κ�ʵ��comparable�����飬����Integer/Double/�ȵȣ����ǲ�����int/double��
	{
		//��a[]����������
		int N = a.length;
		for(int i=0; i<N; i++)
		{
			//��a[i]��a[i+1..N]����С��Ԫ�ؽ���
			int min = i;//��СԪ�ص�����
			for(int j = i+1; j<N; j++)
				if(less(a[j],a[min])) min = j;//�ҵ�δ���������е���СԪ��
			exch(a,i,min);
		}
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
		Integer[] a = new Integer[10];
		for(int i=a.length-1; i>=0; i--)
			a[i] = i;
		Selection.sort(a);
		for(Integer c : a)
			System.out.print(a);
	}

}
