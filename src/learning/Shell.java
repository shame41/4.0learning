package learning;

import java.util.Random;

public class Shell
{
	public static void sort(Comparable[] a)
	{
		//��a[]����������
		int N = a.length;
		int h = 1;
		while(h < N/3)
			h = 3*h + 1;//h��1,4,13,40,121,364,1093...//ע�⣬������в�һ������õģ����Ѿ�����
		while(h>=1)
		{
			//�������Ϊh����
			for(int i=h; i<N; i++)
			{
				//����������ѭ��
				for(int j=i; j>=h && less(a[j],a[j-1]); j-=h)
					exch(a, j, j-h);
			}	
			h = h/3;//�����Խ��ԽС��֪��hΪ1ʱ�ź�
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

	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Random r = new Random(1);
		Integer[] a = new Integer[100];
		for (int i = 0; i<a.length; i++)
		{
			a[i] = r.nextInt()%1000;
		}
		for(Integer i : a)
			System.out.println(i);
		System.out.println("now let's sort it!");
		Shell.sort(a);
		for(Integer i : a)
			System.out.println(i);
	}

}
