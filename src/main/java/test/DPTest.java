package test;

/**
 * 动态规化
 * 
 * [1,2,4,1,7,8,3]
 * 找出不相邻的数的相加的最大值如1,4,7,3
 * @author Snake
 *
 */
public class DPTest {
	public static void main(String[] args) {
		int[] arr = new int[]{1,2,4,1,7,8,3};
		int t = rec_opt(arr, arr.length - 1);
		System.out.println(t);
		System.out.println("call count="+recoptcount);
		int dp_opt = dp_opt(arr);
		System.out.println(dp_opt);
		System.out.println("call count="+dpoptcount);
	}
	
	static int recoptcount = 0;
	static int dpoptcount = 0;
	//基于递归的计算 O(2n)
	static int rec_opt(int[] arr, int index) {
		recoptcount++;
		if(index >= 0) {
			int v = arr[index] + rec_opt(arr, index-2);
			int a = index - 1;
			int v2 = 0;
			if(a > -1) {
				v2 = arr[a] + rec_opt(arr, a - 2);
			}
			return Math.max(v, v2);
		}
		return 0;
	}
	
	static int dp_opt(int[] arr) {
		int[] opt = new int[arr.length];
		opt[0] = arr[0];
		opt[1] = Math.max(arr[0], arr[1]);
		for(int i = 2; i< arr.length; i++) {
			dpoptcount++;
			int a = opt[i-2] + arr[i];
			int b = opt[i -1];
			opt[i] = Math.max(a, b);
		}
		return opt[arr.length - 1];
	}
}
