package learning;

import java.util.Iterator;


public class LinkListTwoWay<Item> implements Iterable<Item>
{
	private Node first;	//ָ��������ӵĽ�������
	private Node last;	//ָ�������ӵĽ�������
	private int N;		//�����е�Ԫ������
	
	private class Node
	{
		Item item;
		Node next;
		Node pre;
	}
	
	public static void main(String[] args)
	{
		LinkListTwoWay<Integer> a = new LinkListTwoWay<Integer>();
		a.add(0);
		a.add(1);
		a.add(2);
		a.add(3);
		for(Integer i : a)
			System.out.println(i);
		a.insert(4, 2);
		for(Integer i : a)
			System.out.println(i);
		
	}

	
	public void add(Item item)
	{
		//���β���Ԫ��
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if(isEmpty()) 
		{
			first = last;
			first.pre = null;
		}
		else
		{
			oldlast.next = last;
			last.pre = oldlast;
		}
		N++;
	}

	public boolean insert(Item item, int k)
	{
		//���뵽��k�������㿪ʼ������  ��ע���嵽��һ��ǰ��������-1��
		Node newItem = new Node();
		newItem.item = item;
		if(k>N||k<-1)
			return false;
		if(k==-1)
		{
			newItem.next = first;
			first = newItem;
		}
		else
		{
			if(k==N-1)
				add(item);
			else
			{
				Node target = KeyFind(k);
				newItem.next = target.next;
				target.next = newItem;
				newItem.pre = target;
				newItem.next.pre = newItem;
			}
		}
		return true;
	}
	public Node KeyFind(int k)
	{
		//�ҵ���k����㣨���㿪ʼ�������ظýڵ�
		Node p = first;
		p.pre = first;
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
		//ɾ����k����㣨���㿪ʼ��
		if(k>N||k<0)
			return false;
		Node delNode = KeyFind(k-1);
		if(k==N-1)
		{
			last = delNode;
			delNode.next = null;
		}
		else if(k==0)
		{
			first = first.next;
			if(isEmpty())
				last = null;
		}
		else
		{
			delNode.next = delNode.next.next;
			delNode.next.pre = delNode;
		}
		N--;
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
