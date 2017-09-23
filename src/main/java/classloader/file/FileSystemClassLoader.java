package classloader.file;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/***
 * 文件系统类加载器
 * @author Snake
 *
 */
public class FileSystemClassLoader extends ClassLoader {

	private String rootDir;

	public FileSystemClassLoader(String rootDir) {
		this.rootDir = rootDir;
	}

	/**
	 * 继承ClassLoader需要重写findClass方法，当调用loadClass方法的时候会调用此方法
	 */
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		byte[] classData = getClassData(name);
		if (classData == null) {
			throw new ClassNotFoundException();
		}
		else {
			//可以通过byte[]数组来创建对像
			return defineClass(name, classData, 0, classData.length);
		}
	}

	private byte[] getClassData(String className) {
		String path = classNameToPath(className);
		try {
			InputStream ins = new FileInputStream(path);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int bufferSize = 4096;
			byte[] buffer = new byte[bufferSize];
			int bytesNumRead = 0;
			while ((bytesNumRead = ins.read(buffer)) != -1) {
				baos.write(buffer, 0, bytesNumRead);
			}
			return baos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private String classNameToPath(String className) {
		return rootDir + File.separatorChar
				+ className.replace('.', File.separatorChar) + ".class";
	}
}
