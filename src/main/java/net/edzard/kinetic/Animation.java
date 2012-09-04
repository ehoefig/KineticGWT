package net.edzard.kinetic;

/**
 * Used to control animations.
 * @author Ed
 */
public class Animation extends Container {

	/** Protected default Ctor keeps GWT happy */
	protected Animation() {}
	
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
