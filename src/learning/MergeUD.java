package learning;

//�Զ����µĹ鲢����
public class MergeUD
{
	private static Comparable[] aux;
	
	public static void sort(Comparable[] a)
	{
		aux = new Comparable[a.length];//һ���Է���ռ�
		sort(a, 0, a.length -1);
	}
	
	private static void sort(Comparable[] a, int lo, int hi)
	{
		//������a[lo...hi]���򣨵ݹ��
		if(hi <= lo) return;
		int mid = lo + (hi - lo) /2;
		sort(a, lo, mid);//��������
		sort(a, mid+1, hi);//�����Ұ��
		merge(a, lo, mid, hi);//�鲢���
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
