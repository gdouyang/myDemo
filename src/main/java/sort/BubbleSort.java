package sort;

public class BubbleSort {

	/**
	 * 冒泡排序
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		method1();
		System.out.println();
		method2();
		System.out.println();
		method3();
		System.out.println();
		method4();
	}

	public static void method1() {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8 };
		//ok:
		for (int i = 0; i < array.length; i++) {
			for (int j = 1; j < array.length - i; j++) {
				if (array[i] < array[j + i]) {
					int temp = array[j + i];
					array[j + i] = array[i];
					array[i] = temp;
					//break ok;
				}
			}
		}
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
		}
	}

	public static void method2() {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8 };
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] < array[j]) {
					int temp = array[j];
					array[j] = array[i];
					array[i] = temp;
				}
			}
		}
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
		}
	}

	public static void method3() {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8 };
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (array[i] > array[j]) {
					int temp = array[j];
					array[j] = array[i];
					array[i] = temp;
				}
			}
		}
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
		}
	}

	public static void method4() {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8 };
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (array[i] > array[j]) {
					array[j] = array[i] ^ array[j];
					array[i] = array[i] ^ array[j];
					array[j] = array[i] ^ array[j];
				}
			}
		}
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
		}
	}
}
