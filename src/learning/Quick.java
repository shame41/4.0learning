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
		//标准的快速排序
		if(hi <= lo)
			return;
		int j = partition(a, lo, hi);//切分，快排的关键点
		sort(a, lo, j-1);//对左边排序
		sort(a, j+1, hi);//对右边排序
	}
	private static void sort3way(Comparable[] a, int lo, int hi)
	{
		//三切分快速排序，用来处理数据中有相同元素的数组的排序
		if(hi <= lo)
			return;
		int lt = lo, i = lo + 1, gt = hi;
		Comparable v = a[lo];
		while(i <= gt)
		{
			int cmp = a[i].compareTo(v);
			if		(cmp < 0)
				exch(a, lt++, i++);//放左边
			else if (cmp > 0)
				exch(a, i, gt--);//放右边
			else
				i++;//留在原地，之后它就是在中间
		}//这个循环实现了a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi]
		sort(a, lo, lt - 1);
		sort(a, gt + 1, hi);
	}
	private static int partition(Comparable[] a, int lo, int hi)
	{
		int i = lo, j = hi + 1;//左指针与右指针
		Comparable v = a[lo];  //切分元素
		while(true)
		{
			while(less(a[++i], v) )
				if(i == hi) break;
			//从左到右扫描找出第一个大于切分元素的单元
			while(less(v, a[--j]) )
				if(j == lo) break;
			//从右到左扫描找出第一个小于切分元素的单元
				
			if(i >= j) break;
			exch(a, i, j);//交换两个单元
		}
		//注意此时切分元素仍然放在第一个位置，因此下一步要把它放到中间，而i,j已经在中间相遇，所以放在j处
		exch(a, lo, j);//将v = a[j]放入正确的位置
		return j;
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
