package learning;


//�ú����ʵ��ƽ�����2-3��
public class RedBlackBST<Key extends Comparable<Key>, Value>
{
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	
	private Node root;
	
	private class Node
	{
		Key key;		//��
		Value val;		//�������ֵ
		Node left,right;//��������
		int N;			//��������еĽڵ�����
		boolean color;	//���丸�ڵ�ָ���������ӵ���ɫ
		public Node(Key key, Value val, int n, boolean color)
		{
			this.key = key;
			this.val = val;
			N = n;
			this.color = color;
		}
	}
	private boolean isEmpty()
	{
		return root.N == 0;
	}
	public int size(Node x)
	{
		return x.N;
	}
	private boolean isRed(Node x)
	{
		if(x == null) return false;
		return x.color == RED;
	}
	private Node rotateLeft(Node h)
	{
		//��Щ�������ܻ������ɫ������
		//��������ܰ������ӷ�ת�����ط�ת������ĸ��ڵ�
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		x.color = h.color;
		h.color = RED;
		x.N = h.N;
		h.N = 1 + size(h.left) + size(h.right);
		return x;
	}
	private Node rotateRight(Node h)
	{
		//��Щ�������ܻ�������������ĺ�ɫ������
		//������������ĺ�����Ҫ����ת
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		x.color = h.color;
		h.color = RED;
		x.N = h.N;
		h.N = 1 + size(h.left) + size(h.right);
		return x;
	}
	private void flipColors(Node h)
	{
		h.color = RED;
		h.left.color = BLACK;
		h.right.color = BLACK;
	}
	public void put(Key key, Value val)
	{
		//����key���ҵ����������ֵ������Ϊ���½�һ���ڵ�
		root = put(root, key, val);
		root.color = BLACK;
	}
	private Node put(Node h, Key key, Value val)
	{
		if(h == null)	//���ñ�׼�Ĳ���������͸��ڵ��ú��������� p.282
			return new Node(key, val, 1, RED);
		int cmp = key.compareTo(h.key);
		if		(cmp < 0)
			h.left = put(h.left, key, val);
		else if	(cmp > 0)
			h.right = put(h.left, key, val);
		else 
			h.val = val;
		if(isRed(h.right) && !isRed(h.left))
			h = rotateLeft(h);
		if(isRed(h.left) && !isRed(h.left.left))
			h = rotateRight(h);
		if(isRed(h.left) && !isRed(h.right))
			flipColors(h);
		h.N = size(h.left) + size(h.right) + 1;
		return h;
	}
	//����Ϊɾ����С������
	private Node moveRedLeft(Node h)
	{
		//����ڵ�hΪ��ɫ��h.left��h.left.left���Ǻ�ɫ
		//��h.left����h.left���ӽڵ�֮һ���
		flipColors(h);
		if(isRed(h.right.left))
		{
			h.right = rotateRight(h.right);
			h = rotateLeft(h);
		}
		return h;
	}
	public void deleteMin()
	{
		if(!isRed(root.left) && !isRed(root.right))
			root.color = RED;
		root = deleteMin(root);
		if(!isEmpty())
			root.color = BLACK;
	}
	private Node deleteMin(Node h)
	{
		if(h.left == null)
			return null;
		if(!isRed(h.left) && !isRed(h.left.left))
			h = moveRedLeft(h);
		h.left = deleteMin(h.left);
		return balance(h);
	}
	//����Ϊɾ����������
	private Node moveRedRight(Node h)
	{
		//����ڵ�hΪ��ɫ��h.right��h.right.left���Ǻ�ɫ
		//��h.right����h.right���ӽڵ�֮һ���
		flipColors(h);
		if(!isRed(h.left.left))
			h = rotateRight(h);
		return h;
	}
	public void deleteMax()
	{
		if(!isRed(root.left) && !isRed(root.right))
			root.color = RED;
		root = deleteMax(root);
		if(!isEmpty())
			root.color = BLACK;
	}
	private Node deleteMax(Node h)
	{
		if(isRed(h.left))
			h = rotateRight(h);
		if(h.right == null)
			return null;
		if(!isRed(h.right) && !isRed(h.right.left))
			h = moveRedRight(h);
		h.right = deleteMax(h.right);
		return balance(h);
	}
	private Node balance(Node h)
	{
		if(isRed(h.right))
			h = rotateLeft(h);
		if(isRed(h.right) && !isRed(h.left))
			h = rotateLeft(h);
		if(isRed(h.left) && !isRed(h.left.left))
			h = rotateRight(h);
		if(isRed(h.left) && !isRed(h.right))
			flipColors(h);
		h.N = size(h.left) + size(h.right) + 1;
		return h;
	}
	//����Ϊɾ��������Ĳ���
	public void delete(Key key)
	{
		if(!isRed(root.left) && !isRed(root.right))
			root.color = RED;
		root = delete(root, key);
		if(!isEmpty())
			root.color = BLACK;
	}
	private Node delete(Node h, Key key)
	{
		if(key.compareTo(h.key) < 0)
		{
			if(!isRed(h.left) && !isRed(h.left.left))
				h = moveRedLeft(h);
			h.left = delete(h.left, key);
		}
		else
		{
			if(isRed(h.left))
				h = rotateRight(h);
			if(key.compareTo(h.key) == 0 && (h.right == null))
				return null;
			if(!isRed(h.right) && !isRed(h.right.left))
				h = moveRedRight(h);
			if(key.compareTo(h.key) == 0)
			{
				h.val = get(h.right, min(h.right).key);
				h.key = min(h.right).key;
				h.right = deleteMin(h.right);
			}
			else
				h.right = delete(h.right, key);
		}
		return balance(h);
	}
	public Key min()
	{
		return min(root).key;
	}
	private Node min(Node x)
	{
		if(x.left == null) return x;
		return min(x.left);
	}
	public Value get(Key key)
	{
		return get(root, key);
	}
	private Value get(Node x, Key key)
	{
		//����xΪ���ڵ�������в��Ҳ�����key����Ӧ��ֵ
		//����Ҳ����򷵻�null
		if(x == null) return null;
		int cmp = key.compareTo(x.key);
		if		(cmp < 0) return get(x.left, key);
		else if (cmp > 0) return get(x.right, key);
		else return x.val;
	}
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
