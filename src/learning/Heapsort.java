package learning;

import java.security.Key;
import java.util.Random;

public class Heapsort
{
    public static void sort(Comparable a[])
    {
        int N = a.length;
        for(int k = N/2; k>=0; k--)
            sink(a, k, N);//build the Heap  (we can do this by sinking backwards

        while (N > 1)//move the top one to the last of the array
        {
            exch(a, 0, --N);
            sink(a, 0, N-1);
        }
    }

    private void swim(Comparable a[], int k, int N)
    {

    }
    private static void sink(Comparable a[], int k, int N)
    {
        while(2*k < N)
        {
            int j = 2*k;
            if(j < N && less(a, j, j+1))
                j++;
            if(!less(a,k, j))
                break;
            exch(a, k, j);
            k = j;
        }
    }
    private static void exch(Comparable a[], int k, int j)
    {
        Comparable t = a[k];
        a[k] = a[j];
        a[j] = t;
    }

    public static void main(String[] argv)
    {
        Random r = new Random(11);
        Integer[] a = new Integer[100];
        for (int i = 0; i<a.length; i++)
        {
            a[i] = r.nextInt()%1000;
        }
        for(Integer i : a)
            System.out.println(i);
        System.out.println("now let's sort it!");
        Heapsort.sort(a);
        for(Integer i : a)
            System.out.println(i);
    }
    private static boolean less(Comparable a[], int i, int j)
    {
        return a[i].compareTo(a[j]) < 0;
    }
}
