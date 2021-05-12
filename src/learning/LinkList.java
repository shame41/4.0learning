package learning;

import java.util.Iterator;

//单向链表
public class LinkList<Item> implements Iterable<Item>
{
	private Node first;	//指向最早添加的结点的链接
	private Node last;	//指向最后添加的结点的链接
	private int N;		//队列中的元素数量
	
	private class Node
	{
		Item item;
		Node next;
	}
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		LinkList<Integer> a = new LinkList<Integer>();
		a.add(1);
		a.add(2);
		a.add(3);

		
	}
	
	public void add(Item item)
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
	
	
	public Node KeyFind(int k)
	{
		//找到第k个结点（从零开始）并返回该节点
		Node p = first;
		if(k>N||k<0)
			return null;
		else
		{
			for(int i=0; i<k; i++)
			{
				p = p.next;
			}
			return p;
		}
	}
	
	public boolean delete(int k)
	{
		//删除第k个结点（从零开始）
		if(k>N||k<0)
			return false;
		
		if(k==0)
		{
			first = first.next;
			if(isEmpty())
				last = null;
			N--;
		}
		else
		{
			Node delNode = KeyFind(k-1);
			if(k==N-1)
			{
				last = delNode;
				delNode.next = null;
			}
			else
			{
				delNode.next = delNode.next.next;
			}
		}
		return true;
	}



	public boolean isEmpty()	{return first == null;}
	public int size()				{return N;}
	@Override
	public Iterator<Item> iterator()
	{	return new ListIterator();	}
	private class ListIterator implements Iterator<Item>
	{
		private Node current = first;
		public boolean hasNext() {return current != null;}
		public void remove() {}
		public Item next()
		{
			Item item = current.item;
			current = current.next;
			return item;
		}
	}

}
