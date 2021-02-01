package learning;

import java.util.Iterator;

//用链表实现的队列，可以入队出队、查询长度还有遍历，但是不能删除其中的元素也不能插队
public class LinkListQueue<Item> implements Iterable<Item> 
{
	private Node first;	//指向最早添加的结点的链接
	private Node last;	//指向最后添加的结点的链接
	private int N;		//队列中的元素数量
	
	private class Node
	{
		Item item;
		Node next;
	}
	
	public void enqueue(Item item)
	{
		//向表尾添加元素
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
		//从表头删除元素并将其返回
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
		public void remove() {}//尽量不要使用这个方法
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
