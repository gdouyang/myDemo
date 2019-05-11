package test;

/***
 * 某农场引进一只兔子，该兔到了第3个月就会产下一只小兔，从此之后每月产下一只小兔。而小兔也一样， 到了出生后的第三个月也会产下一只小兔，
 * 之后每个月都会产下一只小兔，以此类推， 8个月后这个农场一共有多少只兔子？（使用递回算法）
 * 
 * 斐波那奖数列：
 * 
 * 1，1，2，3，5，8，13，21，34,55,89,144,233,377......
 * 
 * 其规律是从第三项起，每一项都是前两项的和．用递推公式表达就是：
 * 
 * a1=a2=1， an＝an-1十an-2(n>=3) 将值带进公式an＝an-1十an-2(n>=3)
 * 
 * 能这样递回是这些兔子的生产规律都是一致的
 * 
 * @author Snake
 * 
 */
public class Fabonacci {
	static int reccount = 0;
	
	// 递归
	public static int rec_con(int n) {
		reccount++;
		if (n > 2) {
			return rec_con(n - 1) + rec_con(n - 2);
		}
		return 1;
	}

	public static void main(String[] args) {
		System.out.println(rec_con(9));
		System.out.println("rec count="+reccount);
		System.out.println(con2(9));
		System.out.println("count="+dpcount);
	}

	static int dpcount=0;
	public static int con2(int n) {
		int[] num = new int[n];
		for (int i = 0; i < n; i++) {
			dpcount++;
			if(i>1){
				num[i]=num[i-1]+num[i-2];
			}else{
				num[i]=1;
			}
		}
		return num[n-1];
	}
}
