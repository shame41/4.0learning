package learning;

//�Ե����ϵĹ鲢����
public class MergeDU
{
	private static Comparable[] aux;  //��������
	
	public static void sort(Comparable[] a)
	{
		//����lgN�������鲢;
		int N = a.length;
		aux = new Comparable[N];
		for(int sz=1; sz<N; sz=sz+sz) //sz��ÿ���������С
			for(int lo=0; lo<N-sz; lo=lo+sz+sz)//lo������������
				merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));
	}
	public static void merge(Comparable[] a, int lo, int mid, int hi)
	{
		//�����鲢�������꣬����������ԭ�ع鲢
		int i = lo, j = mid+1;
		
		for(int k=lo; k <= hi; k++)//��a[lo..hi]�������Ƶ�aux[lo...hi]
			aux[k] = a[k];
		for(int k=lo; k <= hi; k++)//�������α� i j,�ֱ��Ӧ��ߺ��ұ�
			if		(i > mid)				a[k] = aux[j++];//�����Ѿ�û��Ԫ����
			else if (j > hi )				a[k] = aux[i++];//�Ұ���Ѿ�û��Ԫ����
			else if (less(aux[j], aux[i]))	a[k] = aux[j++];//���ߵ�ǰֵ�����Ұ�ߵ�ǰֵ
			else 							a[k] = aux[i++];//�Ұ�ߵ�ǰֵ�������ߵ�ǰֵ
	}
	public static void main(String[] args)
	{
		Integer[] num = {1,44,2,132,4,23,133};
		MergeDU.sort(num);
		show(num);
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
