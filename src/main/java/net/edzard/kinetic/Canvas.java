package net.edzard.kinetic;

import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.CanvasElement;

public class Canvas extends JavaScriptObject {

	protected Canvas() {}
	
	public final native void clear() /*-{
		this.clear();
	}-*/;
	
	public final native Context2d getContext() /*-{
		return this.getContext();
	}-*/;
	
	public final native CanvasElement getElement() /*-{
		return this.getElement();
	}-*/;
	
}
