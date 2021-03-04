package learning;

import java.util.Iterator;


public class ST<Key extends Comparable<Key>, Value>
{
	private Node first;	//指向最早添加的结点的链接
	private Node last;	//指向最后添加的结点的链接
	private int N;		//队列中的元素数量
	
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
		//构造函数
	}
	public void put(Key key, Value val)
	{
		//将键值对存入表中（若值为空则将键Key从表中删除
		for(Node x = first; x != null; x = x.next)
			if(key.equals(x.key))
			{
				//找到
				x.val = val;
				return;
			}
		first = new Node(key, val, first);//没找到，新建节点
	}
	public Value get(Key key)
	{
		//获取键Key对应的值（若键Key不存在则返回空
		for(Node x = first; x != null; x = x.next)
			if(key.equals(x.key))
				return x.val;//找到了
		return null;//没找到
	}
	public void delete(Key key)
	{
		//从表中删去key（以及对应的值
		for(Node x = first; x != null; x = x.next)
			if(key.equals(x.next.key))
			{
				//找到了
				x.next = x.next.next;
				N--;
				return;
			}
		System.out.println("要删除的键值对不存在");
		return;
	}
	public boolean contains(Key key)
	{
		//键key是否在表中
		return get(key) != null;
	}
	public boolean isEmpty()
	{
		//表是空的
		return size() == 0;
	}
	public int size()
	{
		//表中键值对的数量
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
