package test;

/**
 * 丢手帕程序： 要求：有N个小孩围成一圈，指定从一个小孩开始报数， 如果报到4的小孩，就出去，然后重后面一个小孩开始重新报数， 直到最后一个小孩留下。
 * 
 * */
public class DiuShouPa {
	public static void main(String[] args) {
		int people = 4;
		int number = 4;
		int position = 1;
		int[] child = new int[people];
		for (int i = 0; i < child.length; i++) {
			child[i] = i;
		}
		for (int i = position - 1; i < child.length - 1; i++) {
			int index = i + number - 1;
			if ((index) > child.length - 1) {
				index = index - child.length;
			}
			int chenge = child[index];
			people--;
			child[i + index] = child[people];
			child[people] = chenge;
			i = (index + 1);
			if ((i) > child.length - 1) {
				i = i - child.length;
			}
		}
		for (int i = 0; i < child.length; i++) {
			System.out.print(i + ",");
		}
		System.out.println();
		
	}

}
