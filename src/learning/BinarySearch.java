package learning;

public class BinarySearch
{
	public static int rank(int key, int[] a)//迭代实现的有序数组二分查找
	{
		//数组必须是有序的
		int lo = 0;
		int hi = a.length - 1;
		while(lo <= hi)
		{
			int mid = lo + (hi - lo)/2;
			if		(key < a[mid])
				hi = mid - 1;
			else if (key > a[mid])
				lo = mid + 1;
			else return mid;
		}
		return -1;
	}
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
