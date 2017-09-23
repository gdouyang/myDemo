package test;


/*
 *   3   7 
 *  2 4 6 8 
 * 1   5   9
 * 
 * 平面图形题(一般使用2维数组)
 * 
 * @author Snake
 * 
 */
public class Print_M {
	public static void main(String[] args) {
		int[][] arr = new int[3][9];
		boolean order = false;
		int x = 2;
		int y = 0;
		// 往数组中添加数据
		for (int i = 1; i <= 9; i++) {
			arr[x][y] = i;
			y++;
			if (!order) {
				x--;
			}
			if (order) {
				x++;
			}
			if (x < 0) {
				order = true;
				x = x + 2;
			}
			if (x > 2) {
				order = false;
				x = x - 2;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] == 0) {
					System.out.print(" ");
				} else
					System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
}
