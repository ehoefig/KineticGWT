package net.edzard.kinetic;

/**
 * A shape that draws paths defined using the SVG standard.
 * * A SVG path string is made up from path commands (see <a href="http://www.w3.org/TR/SVG/paths.html">W3C SVG 1.1 TR</a>).
 * @author Ed 
 */
public class PathSVG extends Shape {

	/** Protected default Ctor keeps GWT happy */
	protected PathSVG() {}
	
	/**
	 * Retrieve the SVG Path string.
	 * @return The path string
	 */
	public final native String getData() /*-{
		return this.getData();
	}-*/;
	
	/**
	 * Assign a SVG path string.
	 * @param data The new path string
	 */
	public final native void setData(String data) /*-{
		this.setData(data);
	}-*/;
	
	/**
	 * Animate a linear transition of this SVG path shape.
	 * @param target Another SVG path shape - defines the characteristics that the current SVG path shape will have at the end of the animation
	 * @param duration The time it will take for the animation to complete, in seconds
	 * @return An object for controlling the transition.
	 */
	public final Transition transitionTo(PathSVG target, double duration) {
		return transitionTo(target, duration, null, null);
	}
	
	/**
	 * Animate a transition of this SVG path shape.
	 * @param target Another SVG path shape - defines the characteristics that the current SVG path shape will have at the end of the animation
	 * @param duration The time it will take for the animation to complete, in seconds
	 * @param ease An easing function that defines how the transition will take place
	 * @param callback A function that will be called at the end of the animation
	 * @return An object for controlling the transition.
	 */
	// Delegates to shape (no special properties to animate)
	public final Transition transitionTo(PathSVG target, double duration, EasingFunction ease, Runnable callback) {
		StringBuffer sb = new StringBuffer();
		return transitionToShape(target, sb, duration, ease, callback);
	}
}
