package security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class TestMD5 {
	public String md5(String str){
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			//把输入的字符串使用md5的摘要进行改变
			byte[] md5 = md.digest(str.getBytes());
			//由于md5直接转换成String会出现乱码，所以使用BASE64Encoder来重新编码，转换成可以被人识别的字符
			BASE64Encoder en = new BASE64Encoder();
			return en.encode(md5);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} 
		return null;
	}
	public static void main(String[] args) {
		System.out.println(new TestMD5().md5("123456")); 
	}
}
