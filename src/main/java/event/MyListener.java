package event;

import java.util.EventListener;

public interface MyListener extends EventListener {
	public void propertyEvent(MyEvent event);
}
