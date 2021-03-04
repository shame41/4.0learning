package learning;

import java.util.Iterator;


public class ST<Key extends Comparable<Key>, Value>
{
	private Node first;	//ָ��������ӵĽ�������
	private Node last;	//ָ�������ӵĽ�������
	private int N;		//�����е�Ԫ������
	
	private class Node
	{
		Value val;
		Key key;
		Node next;
		public Node(Key key, Value val, Node next)
		{
			this.key = key;
			this.val = val;
			this.next = next;
		}
	}
	
	public ST()
	{
		//���캯��
	}
	public void put(Key key, Value val)
	{
		//����ֵ�Դ�����У���ֵΪ���򽫼�Key�ӱ���ɾ��
		for(Node x = first; x != null; x = x.next)
			if(key.equals(x.key))
			{
				//�ҵ�
				x.val = val;
				return;
			}
		first = new Node(key, val, first);//û�ҵ����½��ڵ�
	}
	public Value get(Key key)
	{
		//��ȡ��Key��Ӧ��ֵ������Key�������򷵻ؿ�
		for(Node x = first; x != null; x = x.next)
			if(key.equals(x.key))
				return x.val;//�ҵ���
		return null;//û�ҵ�
	}
	public void delete(Key key)
	{
		//�ӱ���ɾȥkey���Լ���Ӧ��ֵ
		for(Node x = first; x != null; x = x.next)
			if(key.equals(x.next.key))
			{
				//�ҵ���
				x.next = x.next.next;
				N--;
				return;
			}
		System.out.println("Ҫɾ���ļ�ֵ�Բ�����");
		return;
	}
	public boolean contains(Key key)
	{
		//��key�Ƿ��ڱ���
		return get(key) != null;
	}
	public boolean isEmpty()
	{
		//���ǿյ�
		return size() == 0;
	}
	public int size()
	{
		//���м�ֵ�Ե�����
		return N;
	}
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		ST a = new ST();
		a.put("guangxi", 01);
		a.put("shanghai", 02);
		a.put("beijing", 03);
		a.put("shenzhen", 04);
		a.delete("shanghai");
		System.out.printf("%d,%d", a.get("guangxi"),a.get("shanghai"));
	}
	public Iterator<Key> key()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
