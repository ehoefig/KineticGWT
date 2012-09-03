package net.edzard.kinetic;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Used to control transitions.
 * @author Ed
 */
public class Transition extends JavaScriptObject {

	/** Protected default Ctor keeps GWT happy */
	protected Transition() {}
	
	/**
	 * Resumes a previously stopped transition.
	 */
	public final native void resume() /*-{
		this.resume();
	}-*/;
	
	/**
	 * Starts a transition.
	 */
	public final native void start() /*-{
		this.start();
	}-*/;
	
	/**
	 * Stops a transition.
	 */
	public final native void stop() /*-{
		this.stop();
	}-*/;
}
