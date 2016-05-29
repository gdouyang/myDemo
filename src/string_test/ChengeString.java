package string_test;

/**
 * 把字符串反向输入
 * @author snake
 *
 */
public class ChengeString {
	int a = 1;

	public static void main(String[] args) {
		String str = "abcdef";
		
		char[] charArray = str.toCharArray();
		StringBuffer strB = new StringBuffer();
		for (int i = charArray.length - 1; i >= 0; i--) {
			strB.append(charArray[i]);
			System.out.println(strB);
		}
		
		
		String str1 = new String("abcdef");
		System.out.println(str.hashCode());
		System.out.println(str1.hashCode());
		System.out.println(str == str1);
		System.out.println(str.equals(str1));
	}

}
