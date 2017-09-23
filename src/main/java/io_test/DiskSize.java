package io_test;

import java.io.File;

/**
 * 得到硬盘中所有分区的大小
 * @author snake
 *
 */
public class DiskSize {
	public static void main(String[] args) {
		File[] files = File.listRoots();
		for(File f:files){
			System.out.println(f.getPath());
			System.out.println(f.getAbsolutePath());
			System.out.println("可用大小"+f.getFreeSpace()/1024/1024/1024+"G");
			System.out.println("总大小"+f.getTotalSpace()/1024/1024/1024+"G");
		}
	}
}
