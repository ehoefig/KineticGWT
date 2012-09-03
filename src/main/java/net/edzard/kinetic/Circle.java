package net.edzard.kinetic;

/**
 * A circular shape.
 * @author Ed
 */
public class Circle extends Shape {

	/** Protected default Ctor keeps GWT happy */
	protected Circle() {}
	
	/**
	 * Retrieve this circle's radius.
	 * @return The radius
	 */
	public final native double getRadius() /*-{
		return this.getRadius();
	}-*/;

	/**
	 * Assign a radius.
	 * @param radius The new radius value
	 */
	public final native void setRadius(double radius) /*-{
		this.setRadius(radius);
	}-*/;
	
	/**
	 * Animate a linear transition of this circle.
	 * @param target Another circle shape - defines the characteristics that the current circle will have at the end of the animation
	 * @param duration The time it will take for the animation to complete, in seconds
	 * @return An object for controlling the transition.
	 */
	public final Transition transitionTo(Circle target, int duration) {
		return transitionTo(target, duration, null, null);
	}
	
	/**
	 * Animate a transition of this circle.
	 * @param target Another circle shape - defines the characteristics that the current circle will have at the end of the animation
	 * @param duration The time it will take for the animation to complete, in seconds
	 * @param ease An easing function that defines how the transition will take place
	 * @param callback A function that will be called at the end of the animation
	 * @return An object for controlling the transition.
	 */
	public final Transition transitionTo(Circle target, int duration, EasingFunction ease, Runnable callback) {
		StringBuffer sb = new StringBuffer();
		if (this.getRadius() != target.getRadius()) sb.append("radius:").append(target.getRadius()).append(",");
		return transitionToShape(target, sb, duration, ease, callback);
	}
}
