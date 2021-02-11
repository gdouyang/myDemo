package sort;

import java.util.Arrays;
import java.util.List;

public class BubbleSort {

	/**
	 * 冒泡排序
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> asList = Arrays.asList( 1, 2, 3, 4, 5, 6, 7, 8, 10, 12 );
		System.out.println("================= 1");
		method1(asList.toArray(new Integer[] {}));
		System.out.println("\r\n================= 2");
		method2(asList.toArray(new Integer[] {}));
		System.out.println("\r\n================= 3");
		method3(asList.toArray(new Integer[] {}));
		System.out.println("\r\n================= 4");
		method4(asList.toArray(new Integer[] {}));
		System.out.println("\r\n================= 5");
		method5(asList.toArray(new Integer[] {}));
	}

	public static void method1(Integer[] array) {
		//ok:
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 1; j < array.length - i; j++) {
				if (array[i] < array[j + i]) {
					int temp = array[j + i];
					array[j + i] = array[i];
					array[i] = temp;
					//break ok;
				}
				count++;
			}
		}
		System.out.println("loop count= "+count);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+",");
		}
	}

	public static void method2(Integer[] array) {
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] < array[j]) {
					int temp = array[j];
					array[j] = array[i];
					array[i] = temp;
				}
				count++;
			}
		}
		// count = (1+8)*8/2 等差数列
		System.out.println((1+array.length-1)*(array.length-1)/2);
		System.out.println("loop count= "+count);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+",");
		}
	}

	public static void method3(Integer[] array) {
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (array[i] > array[j]) {
					int temp = array[j];
					array[j] = array[i];
					array[i] = temp;
				}
				count++;
			}
		}
		System.out.println("loop count= "+count);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+",");
		}
	}

	public static void method4(Integer[] array) {
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (array[i] > array[j]) {
					array[j] = array[i] ^ array[j];
					array[i] = array[i] ^ array[j];
					array[j] = array[i] ^ array[j];
				}
				count++;
			}
		}
		System.out.println("loop count= "+count);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+",");
		}
	}
	
	public static void method5(Integer[] array) {
		//ok:
		int count = 0;
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - i -1; j++) {
				if (array[j] < array[j + 1]) {
					int temp = array[j + 1];
					array[j + 1] = array[j];
					array[j] = temp;
					//break ok;
				}
				count++;
			}
		}
		System.out.println("loop count= "+count);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+",");
		}
	}
}
