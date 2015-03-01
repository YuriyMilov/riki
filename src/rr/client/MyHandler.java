package rr.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;

public class MyHandler implements ClickHandler, KeyUpHandler {

	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);
	Button bb = new Button();
	HTML aa = new HTML();

	public MyHandler(Button bb, HTML aa) {
		this.bb = bb;
		this.aa = aa;
	};

	public void onClick(ClickEvent event) {
		sendNameToServer();
		aa.setHTML("<img src=/waiting.gif>");
		
	}

	public void onKeyUp(KeyUpEvent event) {
		if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
			sendNameToServer();
		}
	}

	private void sendNameToServer() {
		greetingService.greetServer("textToServer",
				new AsyncCallback<String>() {
					public void onFailure(Throwable caught) {
					}

					public void onSuccess(String result) {
						aa.setHTML("<br/><br/> "+result);

					}
				});
	}
}
