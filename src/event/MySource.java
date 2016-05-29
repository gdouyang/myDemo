package event;

import java.util.Enumeration;
import java.util.Vector;

public class MySource {
	@SuppressWarnings("rawtypes")
	private Vector repository = new Vector();
	MyListener ml;

	@SuppressWarnings("unchecked")
	public void addMyListener(MyListener listener) {
		repository.addElement(listener);
	}

	public void notifyMyEvent() {
		@SuppressWarnings("rawtypes")
		Enumeration enume = repository.elements();
		while (enume.hasMoreElements()) {
			ml = (MyListener) enume.nextElement();
			ml.propertyEvent(new MyEvent(this));
		}
	}
}
