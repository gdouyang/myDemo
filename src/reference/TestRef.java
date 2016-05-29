package reference;

import java.util.ArrayList;
import java.util.List;

public class TestRef {
	public static void changeRef1() {
		User ref = new User();
		ref.num = 1;
		ref.str = "abc";
		System.out.println(ref);
		System.out.println(ref.num);
		System.out.println(ref.str);
		//
		User ref1 = ref;
		ref1.num = 2;
		ref1.str = "def";
		System.out.println(ref1);
		System.out.println(ref1.num);
		System.out.println(ref1.str);
		System.out.println(ref == ref1);
	}

	public static void changeRef2() {
		List<User> refList = new ArrayList<User>(0);
		User ref = new User();
		ref.num = 1;
		ref.str = "abc";
		System.out.println("ref = " + ref);
		System.out.println("ref.num = " + ref.num);
		System.out.println("ref.str = " + ref.str);
		System.out.println("<------------------>");
		refList.add(ref);
		User ref1 = refList.get(0);
		System.out.println("refList.get(0) = " + refList.get(0));
		System.out.println("refList.get(0).num = " + refList.get(0).num );
		System.out.println("refList.get(0).str = " + refList.get(0).str);
		System.out.println("<------------------>");
		ref1.num = 2;
		ref1.str = "def";
		System.out.println("ref1 = " + ref1);
		System.out.println("ref1.num = " + ref1.num);
		System.out.println("ref1.str = " + ref1.str);
		System.out.println("ref == ref1 ? : " + (ref == ref1));
		System.out.println("<------------------>");
		System.out.println("refList.get(0) = " + refList.get(0));
		System.out.println("refList.get(0).num = " + refList.get(0).num );
		System.out.println("refList.get(0).str = " + refList.get(0).str);
		System.out.println("refList.get(0) == ref ? : " + refList.get(0).equals(ref));
	}

	public static void main(String[] args) {
		// changeRef1();
		changeRef2();
	}
}
