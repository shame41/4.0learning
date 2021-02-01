package learning;

//用链表实现基于拉链法的哈希表
public class SeparateChainingHashST<Key, Value>
{
	private int N;			//键值对总数
	private int M;			//散列表的大小
	private SeparateChainingHashST<Key, Value>[] st;//存放链表的数组

	public SeparateChainingHashST()
	{
		this(997);
	}
	public SeparateChainingHashST(int M)
	{
		//创建M条链表
		this.M = M;
		st = (SeparateChainingHashST<Key, Value>[]) new SeparateChainingHashST[M];
		for(int i=0; i<M; i++)
			st[i] = new SeparateChainingHashST();
	}
	private int hash(Key key)
	{
		return (key.hashCode() & 0x7fffffff) % M;
	}
	public Value get(Key key)
	{
		return (Value) st[hash(key)].get(key);
	}
	public void put(Key key, Value val)
	{
		st[hash(key)].put(key, val);
	}
//	public Iterable<Key> keys()
//	{
//		
//	}
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		SeparateChainingHashST a = new SeparateChainingHashST(7);
		a.put(1, 'E');
	}

}
