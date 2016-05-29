package string_test;

/**
 * 编写一个截取字符串的函数，输入为一个字符串和字节数， 输出为按字节截取的字符串，<br>
 * 但要保证汉字不被截取半个， 如“我ABC”，4，应该截取“我AB”， 输入“我ABC汉DEF”， 6，应该输出“我ABC”，而不是“我ABC+汉的半个”。
 * 
 * @author snake
 * 
 */
public class ChineseSubstring {
	public static void main(String[] args) throws Exception {
		String str = "我a爱中华abc我爱传智def";
		// String str = "我ABC汉";
		int num = trimGBK(str.getBytes("GBK"), 5);
		System.out.println(str.substring(0, num));
		// 看起来像是空字符串，其实是两个乱码长度为2
		String code = "‍‍";

		System.out.println(new String(code.getBytes(), "utf8"));
		System.out.println("LWVBA2040EA092225‍‍".contains(code));
	}

	/**
	 * 首先要了解中文字符有多种编码及各种编码的特征。 假设n为要截取的字节数。
	 * GBK的编码是一个汉字两个字节，范围是第一个字节大于128开始，第二个字节从大于64开始。<br>
	 * 第一个字节大于127就表示这是个汉字的开始。 byte这种类型只有java有，范围是-127到127.所以打印出来转换了就变成负数了。
	 * 
	 * @param buf
	 * @param n
	 * @return 2013年9月2日-下午6:03:27
	 * 
	 */
	public static int trimGBK(byte[] buf, int n) {
		int num = 0;
		boolean bChineseFirstHalf = false;
		for (int i = 0; i < n; i++) {
			if (buf[i] < 0 && !bChineseFirstHalf) {
				bChineseFirstHalf = true;
			} else {
				num++;
				bChineseFirstHalf = false;
			}
		}
		return num;
	}

}
