package classloader;

/**
 * 查看类加载器关系树
 * @author Snake
 *
 */
public class ClassLoaderTree {

	public static void main(String[] args) {
		ClassLoader loader = ClassLoaderTree.class.getClassLoader();
		while (loader != null) {
			System.out.println(loader.toString());
			loader = loader.getParent();
		}
	}
}
