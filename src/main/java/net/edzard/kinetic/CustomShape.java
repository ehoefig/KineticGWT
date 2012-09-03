package net.edzard.kinetic;

/**
 * A custom shape.
 * The shape is defined using a given path object. 
 * Custom shapes are CPU intensive to render.
 * @author Ed
 */
public class CustomShape extends Shape { 
	
	/** Protected Ctor keeps GWT happy */
	protected CustomShape() {}

	/**
	 * Retrieve the custom shape's path.
	 * @return The path
	 */
	public final native Path getPath() /*-{
		return this.path;
	}-*/;
	
	/**
	 * Assign a path to the custom shape.
	 * @param path The new path
	 */
	public final native void setPath(Path path) /*-{
		this.path = path;
	}-*/;
	
	/**
	 * Animate a linear transition of this custom shape.
	 * @param target Another custom shape - defines the characteristics that the current circle will have at the end of the animation
	 * @param duration The time it will take for the animation to complete, in seconds
	 * @return An object for controlling the transition.
	 */
	public final Transition transitionTo(CustomShape target, double duration) {
		return transitionTo(target, duration, null, null);
	}
	
	/**
	 * Animate a transition of this custom shape.
	 * @param target Another custom shape - defines the characteristics that the current circle will have at the end of the animation
	 * @param duration The time it will take for the animation to complete, in seconds
	 * @param ease An easing function that defines how the transition will take place
	 * @param callback A function that will be called at the end of the animation
	 * @return An object for controlling the transition.
	 */
	// Delegates to shape (no special properties to animate)
	public final Transition transitionTo(CustomShape target, double duration, EasingFunction ease, Runnable callback) {
		StringBuffer sb = new StringBuffer();
		return transitionToShape(target, sb, duration, ease, callback);
	}
}
