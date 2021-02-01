package learning;

//自底向上的归并排序
public class MergeDU
{
	private static Comparable[] aux;  //辅助数组
	
	public static void sort(Comparable[] a)
	{
		//进行lgN次两两归并;
		int N = a.length;
		aux = new Comparable[N];
		for(int sz=1; sz<N; sz=sz+sz) //sz是每个子数组大小
			for(int lo=0; lo<N-sz; lo=lo+sz+sz)//lo：子数组索引
				merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));
	}
	public static void merge(Comparable[] a, int lo, int mid, int hi)
	{
		//整个归并排序的灵魂，将两个数组原地归并
		int i = lo, j = mid+1;
		
		for(int k=lo; k <= hi; k++)//将a[lo..hi]整个复制到aux[lo...hi]
			aux[k] = a[k];
		for(int k=lo; k <= hi; k++)//有两个游标 i j,分别对应左边和右边
			if		(i > mid)				a[k] = aux[j++];//左半边已经没有元素了
			else if (j > hi )				a[k] = aux[i++];//右半边已经没有元素了
			else if (less(aux[j], aux[i]))	a[k] = aux[j++];//左半边当前值大于右半边当前值
			else 							a[k] = aux[i++];//右半边当前值大于左半边当前值
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
		//在单行中打印数组
		for(int i = 0; i<a.length; i++)
			System.out.print(a[i]+" ");
	}
	public static boolean isSorted(Comparable[] a)
	{
		//测试数组元素是否有序
		for (int i=0; i<a.length; i++)
			if(less(a[i],a[i-1]))	return false;
		return true;
	}
}
