package learning;

public class LinearProbingHashST<Key, Value>
{
	private int N;			//���ű��м�ֵ������
	private int M = 16;		//����̽���Ĵ�С
	private Key[] keys;		//��
	private Value[] vals;	//ֵ
	
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
	public void put(Key key, Value val)//��ɢ�б��в����ֵ��
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
	public void delete(Key key)//ɾ��ɢ�б��еļ�ֵ��
	{
		if(!contain(key)) return;//���Ҫɾ����Ԫ�ز���ɢ�б�����ֱ�ӷ���
		int i = hash(key);
		while(!key.equals(keys[i]))//����Ѱ��������key��ͬ�ļ�ֵԪ��
			i = (i + 1) % M;
		keys[i] = null;//ɾ����ֵ��
		vals[i] = null;//ɾ����ֵ��
		i = (i + 1) % M;//ȥ����ɾ��Ԫ�ص���һ����ֵ��
		while(keys[i] != null)//��������ֵ�Բ�Ϊ�գ���˵����ɾ��Ԫ�غ�������
		{
			Key keyToReDo = keys[i];//����������潫Ҫ���²���ļ�ֵ��
			Value valToReDo = vals[i];
			keys[i] = null;//��ɾ��
			vals[i] = null;
			N--;
			put(keyToReDo, valToReDo);//�����²��뵽ɢ�б�
			//�������ǵ�put()���ܽ������ֵ�Բ�����Ӧ�ô���λ��
			i = (i + 1) % M;//Ѱ����һ��Ҫ���²����Ԫ��
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
