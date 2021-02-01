package learning;

import java.util.Iterator;

//������ʵ�ֵĶ�ջ���У����Գ�ջ��ջ����ѯ���Ȼ��б��������ǲ���ɾ�����е�Ԫ��Ҳ���ܲ���
public class LinkListStack<Item> implements Iterable<Item> 
{
	private Node first;	//ָ��������ӵĽ�������
	private int N;		//�����е�Ԫ������
	
	private class Node
	{
		Item item;
		Node next;
	}
	
	public void push(Item item)
	{
		//��ջ�����Ԫ��
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		N++;
	}
	
	public Item pop()
	{
		//��ջ��ɾ��Ԫ�ز����䷵��
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
