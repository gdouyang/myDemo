package collection;

public class InnerClassDemo {
	private String str;
	private InnerClassDemo.InnerClass subAbc = new InnerClassDemo.InnerClass();

	public void setStr(String str) {
		this.str = str;
	}

	public String getStr() {
		return str;
	}

	public void setSubAbc(InnerClass subAbc) {
		this.subAbc = subAbc;
	}

	public InnerClass getSubAbc() {
		return subAbc;
	}

	class InnerClass {
		private String ss = "oyang";

		public void setSs(String ss) {
			this.ss = ss;
		}

		public String getSs() {
			return ss;
		}

	}

}

class SubABC {
	private String ss = "oyang";

	public void setSs(String ss) {
		this.ss = ss;
	}

	public String getSs() {
		return ss;
	}

}
