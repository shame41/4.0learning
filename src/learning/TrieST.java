package learning;

import java.util.Queue;
import java.util.Random;

public class TrieST<Value>
{
    private static int R = 256;     //ASCII码基数
    //值得一提的是，这里的基数是256是128(ascii的大小)的两倍，0代表null，115代表‘s'
    private Node root;

    private static class Node
    {
        private Object val;
        private Node[] next = new Node[R];
    }

    public Value get(String key)
    {
        Node x = get(root, key, 0);
        if (x == null)
            return null;
        return (Value) x.val;
    }

    private Node get(Node x, String key, int d)
    {
        //返回以x作为根节点的子单词查找树中与key相关联的值
        if (x == null)
            return null;
        if (d == key.length())
            return x;
        char c = key.charAt(d);//找到第d个字符串所对应的子单词查找树
        return get(x.next[c], key, d+1);
    }
    public void put(String key, Value val)
    {
        root = put(root, key, val, 0);
    }

    private Node put(Node x, String key, Value val, int d)
    {
        //如果key存在于以x为根节点的子单词查找树中则更新与它相关联的值
        if (x == null)
            x = new Node();
        if (d == key.length())
        {
            x.val = val;
            return x;
        }
        char c = key.charAt(d);//找到第d个字符所对应的子单词查找树
        x.next[c] = put(x.next[c], key, val, d+1);
        return x;
    }
    private void collect(Node x, String pre, String pat, LinkListQueue<String> q)
    {
        int d = pre.length();
        if (x == null)
            return;
        if (d == pat.length() && x.val != null)
            q.enqueue(pre);
        if (d == pat.length())
            return;

        char next = pat.charAt(d);
        for (char c = 0; c < R; c++)
            if (next == '.' || next == c)
                collect(x.next[c], pre + c, pat, q );
    }
    public Iterable<String> keysThatMatch(String pat)
    {
        LinkListQueue<String> q = new LinkListQueue<>();
        collect(root, "", pat, q);
        return q;
    }
    public Iterable<String> keys()
    {
        return keysWithPrefix("");
    }
    public Iterable<String> keysWithPrefix(String pre)
    {
        LinkListQueue<String> q = new LinkListQueue<String>();
        collect(get(root, pre, 0), pre, q);
        return q;
    }
    private void collect(Node x, String pre, LinkListQueue<String> q)
    {
        if (x == null)
            return;
        if (x.val != null)
            q.enqueue(pre);//用来判断是否已经到达字符串结尾，如果到达，就将此字符串加入队列
        for (char c = 0; c < R; c++)
        {
            collect(x.next[c],pre + c, q );
        }
    }
    public void delete(String key)
    {
        root = delete(root, key, 0);
    }
    private Node delete(Node x, String key, int d)
    {
        if (x == null)      //结点为空则直接返回结点
            return null;
        if (d == key.length())//找到了所要删除的键，让它变为空，
            x.val = null;
        else
        {
            //?????????????????
            char c = key.charAt(d);
            x.next[c] = delete(x.next[c], key, d+1);
        }
        if (x.val != null)
            return x;
        for (char c = 0; c < R; c++)
            if (x.next[c] != null)
                return x;
        return null;
    }
    public  String longestPrefixOf(String s)
    {
        int length = search(root, s, 0, 0);
        return  s.substring(0, length);
    }
    private int search(Node x, String s, int d, int length)
    {
        if (x == null)
            return length;
        if (x.val != null)
            length = d;
        if (d == s.length())
            return length;
        char c = s.charAt(d);
        return search(x.next[c], s, d+1, length);
    }
    public static void main(String[] argvs)
    {
        TrieST<Integer> a  = new TrieST<Integer>();
        a.put("sea",2);
        a.put("sells",1);
        a.put("shells",3);
        a.put("she",0);
        a.delete("shell");
        for(String i : a.keys())
            System.out.println(i);
    }
}
