package learning;


//用红黑树实现平衡查找2-3树
public class RedBlackBST<Key extends Comparable<Key>, Value>
{
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	
	private Node root;
	
	private class Node
	{
		Key key;		//键
		Value val;		//相关联的值
		Node left,right;//左右子树
		int N;			//这棵子树中的节点总数
		boolean color;	//由其父节点指向它的链接的颜色
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
		if (x == null)
			return 0;
		else
			return x.N;
	}
	private boolean isRed(Node x)
	{
		if(x == null) return false;
		return x.color == RED;
	}
	private Node rotateLeft(Node h)
	{
		//有些操作可能会产生红色右链接
		//这个函数能把右链接翻转并返回翻转后的树的根节点
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
		//有些操作可能会产生两个连续的红色左链接
		//处理上述情况的函数需要右旋转
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
		//查找key，找到则更新它的值，否则为它新建一个节点
		root = put(root, key, val);
		root.color = BLACK;
	}
	private Node put(Node h, Key key, Value val)
	{
		if(h == null)	//采用标准的插入操作，和父节点用红链接连接 p.282
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
	//以下为删除最小键操作
	private Node moveRedLeft(Node h)
	{
		//假设节点h为红色，h.left和h.left.left都是黑色
		//将h.left或者h.left的子节点之一变红
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
			return null;//说明最小节点就是当前结点，将根节点删除
		if(!isRed(h.left) && !isRed(h.left.left))//判断左结点是否为2-结点
			h = moveRedLeft(h);//如果不是，向周围（兄弟或父亲）借一个结点
		h.left = deleteMin(h.left);
		return balance(h);
	}
	//以下为删除最大键操作
	private Node moveRedRight(Node h)
	{
		//假设节点h为红色，h.right和h.right.left都是黑色
		//将h.right或者h.right的子节点之一变红
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
	//以下为删除任意键的操作
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
		//在以x为根节点的子树中查找并返回key所对应的值
		//如果找不到则返回null
		if(x == null) return null;
		int cmp = key.compareTo(x.key);
		if		(cmp < 0) return get(x.left, key);
		else if (cmp > 0) return get(x.right, key);
		else return x.val;
	}
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		RedBlackBST a = new RedBlackBST();
		a.put("A", 1);
		a.put("B",2);
		a.put("C",3);
		a.put("D",4);
		a.put("E",5);
		a.put("F",6);
	}

}
