package event;

import java.util.EventObject;

public class MyEvent extends EventObject {
	//Object obj;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyEvent(Object source) {
		super(source);
		//obj = source;
	}

//	public Object getSource() {
//		return obj;
//	}

}
