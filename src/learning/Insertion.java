package learning;

import java.util.Scanner;

public class Insertion
{
	public static void sort(Comparable[] a)
	{
		//将a[]按升序排序
		int N = a.length;
		for(int i=1; i<N; i++)
		{	//第一个元素已经排好
			//将未排序的元素一个一个插入已排好的部分中
			for(int j = i; j>0 && less(a[j],a[j-1]); j--)
				exch(a, j, j-1);//在a[]中找到合适的位置插入并将后边的元素往后移
			//这一步不是很好理解，可以试着自己画一画
		}
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
	public static void main(String[] argvs)
	{
		Integer[] a = new Integer[10];
		Scanner input = new Scanner(System.in);
		for(int i = 0; i<10; i++)
			a[i] = input.nextInt();
		for(int i = 0; i<10; i++)
			System.out.println(a[i]);
		System.out.println("now let's sort it");
		Insertion.sort(a);
		for(Integer i : a)
			System.out.println(i);
	}

	public static void sort(String[] a, int lo, int hi, int d)
	{
		//用于字符串排序，不必理会
		//从第d个字符开始对a[lo]到a[hi]排序
		for (int i = lo; i <= hi; i++)
			for (int j = i; j > lo && less(a[j], a[j-1], d); j--)
				exch(a, j, j-1);
	}
	private static boolean less(String v, String w, int d)
	{
		return v.substring(d).compareTo(w.substring(d)) < 0;
	}
}
