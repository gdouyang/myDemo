package test;

public class Circle {
	public static void main(String[] args) {
		// int diameter = 11;// zhi jing
		// int b = 10;
		// for (int i = 0; i < diameter; i++) {
		// for (int j = diameter - i; j > 0; j--) {
		// System.out.print(" ");
		// }
		// for (int k = 0; k < i; k++) {
		// System.out.print("*");
		// }
		// System.out.println();
		//
		// }

		int r = 15;
		for (int y = 0; y <= 2 * r; y += 2) {

			long x = Math.round(r - Math.sqrt(2 * r * y - y * y));
			long longLength = 2 * (r - x);
			if (longLength == 0) {
				longLength = 5;
			}
			if (x == r)
				x -= 3;
			for (int i = 0; i <= x; i++) {
				System.out.print(' ');
			}
			System.out.print('*');

			for (int j = 0; j <= longLength; j++) {
				System.out.print('*');
			}
			System.out.println('*');
		}
	}

}
