package learning;

import java.util.Scanner;

public class Selection
{
	public static void sort(Comparable[] a)//指的是任何实现comparable的数组，包括Integer/Double/等等（但是不包括int/double）
	{
		//将a[]按升序排列
		int N = a.length;
		for(int i=0; i<N; i++)
		{
			//将a[i]和a[i+1..N]中最小的元素交换
			int min = i;//最小元素的索引
			for(int j = i+1; j<N; j++)
				if(less(a[j],a[min]))
					min = j;//找到未排序序列中的最小元素
			exch(a,i,min);
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
	public static boolean isSorted(Comparable[] a)
	{
		//测试数组元素是否有序
		for (int i=0; i<a.length; i++)
			if(less(a[i],a[i-1]))	return false;
		return true;
	}
	
	public static void main(String[] args)
	{
		Integer[] a = new Integer[10];
		Scanner input = new Scanner(System.in);
		for(int i = 0; i<10; i++)
			a[i] = input.nextInt();
		for(int i = 0; i<10; i++)
			System.out.println(a[i]);
		System.out.println("now let's sort it");
		Selection.sort(a);
		for(Integer i : a)
			System.out.println(i);
	}

}
