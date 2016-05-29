package io_test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 简单的复制文件
 * 
 * @author Snake
 * 
 */
public class CopyFile {
	public static void main(String[] args) {
		method01();
	}

	public static void method01() {
		try {
			String urlIn = "E:/abc.txt";
			String urlOut = "F:/cba.txt";
			FileInputStream fis = new FileInputStream(new File(urlIn));
			byte[] bt = new byte[2048];
			fis.read(bt);// 把文件读入byte数组中
			FileOutputStream fos = new FileOutputStream(new File(urlOut));
			System.out.println(bt.length);
			fos.write(bt);// 把数据写入文件内
			fos.close();
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void method02() {
		try {
			String urlIn = "E:/abc.txt";
			String urlOut = "F:/cba.txt";
			FileInputStream fis = new FileInputStream(new File(urlIn));
			FileOutputStream fos = new FileOutputStream(new File(urlOut));
			byte[] bytes = new byte[fis.available()];
			fis.read(bytes);
			fos.write(bytes);// 把数据写入文件内

			fos.close();
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
