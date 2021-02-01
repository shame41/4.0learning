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
	public void put(Key key, Value val)
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
	public void delete(Key key)
	{
//		if(!contain(key)) return;
		int i = hash(key);
		while(!key.equals(keys[i]))
			i = (i + 1) % M;
		keys[i] = null;
		vals[i] = null;
		i = (i + 1) % M;
		while(keys[i] != null)
		{
			Key keyToReDo = keys[i];
			Value valToReDo = vals[i];
			keys[i] = null;
			vals[i] = null;
			N--;
			put(keyToReDo, valToReDo);
			i = (i + 1) % M;
		}
		N--;
		if(N > 0 && N == M/8)
			resize(M/2);
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
