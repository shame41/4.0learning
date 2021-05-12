package learning;

public class LinearProbingHashST<Key, Value>
{
	private int N;			//符号表中键值对总数
	private int M = 16;		//线性探测表的大小
	private Key[] keys;		//键
	private Value[] vals;	//值
	
	public LinearProbingHashST()
	{
		keys = (Key[]) new Object[M];
		vals = (Value[]) new Object[M];
	}
	public LinearProbingHashST(int cap)
	{
		// TODO Auto-generated constructor stub
		keys = (Key[]) new Object[cap];
		vals = (Value[]) new Object[cap];
	}
	private int hash(Key key)
	{
		return (key.hashCode() & 0x7fffffff) % M;
	}
	private void resize(int cap)
	{
		LinearProbingHashST<Key, Value> t;
		t = new LinearProbingHashST<Key, Value> (cap);
		for(int i=0; i<M; i++)
		{
			if((keys[i] != null))
				t.put(keys[i], vals[i]);
		}
		keys = t.keys;
		vals = t.vals;
		M = t.M;
	}
	public void put(Key key, Value val)//往散列表中插入键值对
	{
		if(N >= M/2)
			resize(2*M);
		int i ;
		for(i = hash(key); keys[i] != null; i = (i + 1) % M)
			if(keys[i].equals(key))
			{
				vals[i] = val;
				return;
			}
		keys[i] = key;
		vals[i] = val;
		N++;
	}
	public void delete(Key key)//删除散列表中的键值对
	{
		if(!contain(key)) return;//如果要删除的元素不在散列表中则直接返回
		int i = hash(key);
		while(!key.equals(keys[i]))//依次寻找有无与key相同的键值元素
			i = (i + 1) % M;
		keys[i] = null;//删除键值对
		vals[i] = null;//删除键值对
		i = (i + 1) % M;//去到被删除元素的下一个键值对
		while(keys[i] != null)//如果这个键值对不为空，则说明被删除元素后续有人
		{
			Key keyToReDo = keys[i];//用这个来储存将要重新插入的键值对
			Value valToReDo = vals[i];
			keys[i] = null;//先删除
			vals[i] = null;
			N--;
			put(keyToReDo, valToReDo);//再重新插入到散列表
			//相信我们的put()，能将这个键值对插入他应该待的位置
			i = (i + 1) % M;//寻找下一个要重新插入的元素
		}
		N--;
		if(N > 0 && N == M/8)
			resize(M/2);
	}

	private boolean contain(Key key)
	{
		if(get(key)==null)
			return false;
		else
			return true;
	}

	public Value get(Key key)
	{
		for(int i=hash(key); keys[i] != null; i = (i + 1) % M)
			if(keys[i].equals(key))
				return vals[i];
		return null;
	}
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
