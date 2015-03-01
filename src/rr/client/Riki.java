package rr.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;

public class Riki implements EntryPoint {

	public void onModuleLoad() {
		final Button bb = new Button("   Клякни меня!  ");
		RootPanel.get().add(bb);
		final HTML aa = new HTML();
		RootPanel.get().add(aa);
		MyHandler handler = new MyHandler(bb, aa);
		bb.addClickHandler(handler);	
	}
}
