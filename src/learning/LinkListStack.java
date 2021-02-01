package learning;

import java.util.Iterator;

//用链表实现的堆栈队列，可以出栈入栈、查询长度还有遍历，但是不能删除其中的元素也不能插入
public class LinkListStack<Item> implements Iterable<Item> 
{
	private Node first;	//指向最早添加的结点的链接
	private int N;		//队列中的元素数量
	
	private class Node
	{
		Item item;
		Node next;
	}
	
	public void push(Item item)
	{
		//向栈顶添加元素
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		N++;
	}
	
	public Item pop()
	{
		//从栈顶删除元素并将其返回
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		LinkListStack<Integer> a = new LinkListStack<Integer>();
		a.push(1);
		a.push(2);
		a.push(3);
		a.push(4);
		for(Integer i : a)
			System.out.println(i);
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
