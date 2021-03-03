package learning;

import java.util.Scanner;

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
	
}
