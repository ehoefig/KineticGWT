package net.edzard.kinetic;

import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * A layer object.
 * Layers contain nodes. Multiple layers can be assigned to a stage. Each will be drawn individually and combined into a single overall drawing.
 * By restricting shapes to certain layers, update operations can be kept to a minimum, which is good for performance.
 * @author Ed
 */
public class Layer extends Container {

	/** Protected Ctor keeps GWT happy */
	protected Layer() {}

	/**
	 * Clear this layer.
	 */
	public final native void clear() /*-{
		this.clear();
	}-*/;
	
	/**
	 * Draw this layer.
	 */
	public final native void draw()  /*-{
		this.draw();
	}-*/;
	
	/**
	 * Animate a linear transition of this layer object.
	 * @param target Another layer object - defines the characteristics that the current layer object will have at the end of the animation
	 * @param duration The time it will take for the animation to complete, in seconds
	 * @return An object for controlling the transition.
	 */
	// Delegates to node (no special properties to animate)
	public final Transition transitionTo(Node target, double duration) {
		return transitionTo(target, duration, null, null);
	}
	
	/**
	 * Animate a transition of this layer object.
	 * @param target Another layer object - defines the characteristics that the current layer object will have at the end of the animation
	 * @param duration The time it will take for the animation to complete, in seconds
	 * @param ease An easing function that defines how the transition will take place
	 * @param callback A function that will be called at the end of the animation
	 * @return An object for controlling the transition.
	 */
	// Delegates to node (no special properties to animate)
	public final Transition transitionTo(Node target, double duration, EasingFunction ease, Runnable callback) {
		StringBuffer sb = new StringBuffer();
		return transitionToNode(target, sb, duration, ease, callback);
	}
	
	/**
	 * Assign a callback handler for execution after each drawing operation.
	 * @param callback The callback handler to execute
	 */
	public final native void setAfterDrawHandler(Runnable callback) /*-{
		this.afterDraw(function() {
		    callback.@java.lang.Runnable::run()();
		});
	}-*/; 

	/**
	 * Assign a callback handler for execution before each drawing operation.
	 * @param callback The callback handler to execute
	 */
	public final native void setBeforeDrawHandler(Runnable callback) /*-{
		this.afterDraw(function() {
		    callback.@java.lang.Runnable::run()();
		});
	}-*/; 

	/**
	 * Retrieves the throttle value for animations on this layer object.
	 * The throttle value influences how often drawing operations are executed.
	 * @return The throttle value in milliseconds.
	 */
	public final native int getThrottle()  /*-{
		return this.getThrottle();
	}-*/;
	
	/**
	 * Assign a throttle value for animation on this layer object.
	 * The throttle value influences how often drawing operations are executed.
	 * @param throttle The throttle value in milliseconds.
	 */
	public final native void setThrottle(int throttle) /*-{
		this.setThrottle(throttle);
	}-*/;

	public final native Canvas getCanvas() /*-{
		return this.getCanvas();
	}-*/;
	
	public final native Context2d getContext() /*-{
		return this.getCanvas().getContext();
	}-*/;
}
