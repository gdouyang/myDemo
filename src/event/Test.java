package event;

public class Test {
	public static void main(String[] args) {
		MySource ms = new MySource();
		ms.addMyListener(new MyListener() {

			@Override
			public void propertyEvent(MyEvent event) {
				System.out.println("test_event!!!");
			}
		});
		ms.notifyMyEvent();
	}
}
