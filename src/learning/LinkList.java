package learning;

import java.util.Iterator;

//��������
public class LinkList<Item> implements Iterable<Item>
{
	private Node first;	//ָ��������ӵĽ�������
	private Node last;	//ָ�������ӵĽ�������
	private int N;		//�����е�Ԫ������
	
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
	
	
	public Node KeyFind(int k)
	{
		//�ҵ���k����㣨���㿪ʼ�������ظýڵ�
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
		//ɾ����k����㣨���㿪ʼ��
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
