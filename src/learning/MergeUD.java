package learning;

//自顶向下的归并排序
public class MergeUD
{
	private static Comparable[] aux;
	
	public static void sort(Comparable[] a)
	{
		aux = new Comparable[a.length];//一次性分配空间
		sort(a, 0, a.length -1);
	}
	
	private static void sort(Comparable[] a, int lo, int hi)
	{
		//将数组a[lo...hi]排序（递归地
		if(hi <= lo) return;
		int mid = lo + (hi - lo) /2;
		sort(a, lo, mid);//排序左半边
		sort(a, mid+1, hi);//排序右半边
		merge(a, lo, mid, hi);//归并结果
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
		// TODO Auto-generated method stub

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
