package string_test;

public class MostNumber {
	public static void main(String[] args) {
		String str = "aaaffffbbkkkkkkkkkghi";
		maxNum(str, str.length());
	}

	public static void maxNum(String str, int n) {
		int maxCount = 0;
		StringBuffer sb = new StringBuffer();
		int count[] = new int[128];// 设置一个128大小的数组，代表128个ASCII码
		// 将26个字母赋值，默认值为-1
		for (char i = 'a'; i < 'z'; i++)
			count[i] = -1;
		// 把要进行判断的字符串按长度进行迭代，如果有相同的就加1
		for (int i = 0; i < n; i++) {
			if (count[str.charAt(i)] == -1)
				count[str.charAt(i)] = 1;
			else
				count[str.charAt(i)] += 1;
		}
		// 找到最单词最多的是哪个字母
		for (char i = 'a'; i < 'z'; i++) {
			if (maxCount < count[i])
				maxCount = count[i];
		}
		for (char i = 'a'; i < 'z'; i++) {
			if (count[i] == maxCount)
				sb.append(i);
		}
		System.out.println("The max number is: " + maxCount + ",it's: " + sb);
	}

}
