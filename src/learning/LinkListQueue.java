package learning;

import java.util.Iterator;

//������ʵ�ֵĶ��У�������ӳ��ӡ���ѯ���Ȼ��б��������ǲ���ɾ�����е�Ԫ��Ҳ���ܲ��
public class LinkListQueue<Item> implements Iterable<Item> 
{
	private Node first;	//ָ��������ӵĽ�������
	private Node last;	//ָ�������ӵĽ�������
	private int N;		//�����е�Ԫ������
	
	private class Node
	{
		Item item;
		Node next;
	}
	
	public void enqueue(Item item)
	{
		//���β���Ԫ��
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if(isEmpty()) 
			first = last;
		else
			oldlast.next = last;
		N++;
	}
	
	public Item dequeue()
	{
		//�ӱ�ͷɾ��Ԫ�ز����䷵��
		Item item = first.item;
		first = first.next;
		if(isEmpty())
			last = null;
		N--;
		return item;
	}
	
	public static void main(String[] args)
	{
		LinkListQueue<Integer> a = new LinkListQueue<Integer>();
		a.enqueue(1);
		a.enqueue(2);
		a.enqueue(3);
		a.enqueue(4);
		for(Integer c : a)
			System.out.println(c);
	}

	@Override
	public Iterator<Item> iterator()
	{	return new ListIterator();	}
	private class ListIterator implements Iterator<Item>
	{
		private Node current = first;
		public boolean hasNext()
		{	return current != null;	}
		public void remove() {}//������Ҫʹ���������
		public Item next()
		{
			Item item = current.item;
			current = current.next;
			return item;
		}
	}
	public boolean isEmpty()	{return first == null;}
	public int size()				{return N;}
	
}
