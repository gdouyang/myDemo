package test;

public class MultiplicationTable {
	public static void main(String[] args) {
		// i 表示列， j 表示行
		for (int i = 1, j = 1; j <= 9; i++) {
			System.out.print(i + "*" + j + "=" + i * j + " ");
			if (i == j) {
				i = 0;
				j++;
				System.out.println();
			}
		}
//		int i = 0;
//		for (; i < args.length; i++) {
//			System.out.print(i);
//		}
	}

}
