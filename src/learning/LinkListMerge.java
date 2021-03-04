package learning;

import java.util.Random;

public class LinkListMerge
{
    private Node head;
    private int N;

    private class Node
    {
        Comparable item;
        Node next;
    }

    public void sort(Node k)
    {
        if(k.next == null)
            return;
        Node L1 = k;//fast
        Node L2 = k;//slow

        while(L1.next != null )
        {
            L1 = L1.next.next;
            L2 = L2.next;
        }
        Node pre = L2.next;
        L2.next = null;
        sort(k);
        sort(pre);
        k =  Merge(k, pre);
    }

    public Node Merge(Node L, Node R)
    {
        Node key;
        Node notkey;
        if(less(L.item, R.item))
        {
            key = L;
            notkey = R;
        }
        else
        {
            key = R;
            notkey = L;
        }
        while(key.next != null || notkey.next != null)
        {
           if(less(key.item, notkey.item))
               key = key.next;
           else if(!less(key.item,notkey.item))
           {
               Node temp = notkey;
               temp.next = key.next;
               key.next = temp;

           }
           else if(key.next == null)
               key.next = notkey;

        }

        return key;
    }



    private static boolean less(Comparable v, Comparable w)
    {
        return v.compareTo(w) < 0;
    }
}
