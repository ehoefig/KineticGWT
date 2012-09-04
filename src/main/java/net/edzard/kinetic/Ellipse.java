package net.edzard.kinetic;

/**
 * An elliptical shape.
 * @author Ed
 */
public class Ellipse extends Shape {

	/** Protected default Ctor keeps GWT happy */
	protected Ellipse() {}
	
	/**
	 * Retrieve this ellipse's radius.
	 * @return The radius (x and y component)
	 */
	public final native Vector2d getRadius() /*-{
		return @net.edzard.kinetic.Vector2d::new(DD)(this.getRadius().x, this.getRadius().y);
	}-*/;

	/**
	 * Assign the ellipse's radius.
	 * @param radius The new radius value (x and y component)
	 */
	public final native void setRadius(Vector2d radius) /*-{
		this.setRadius([radii.@net.edzard.kinetic.Vector2d::x, radii.@net.edzard.kinetic.Vector2d::y]);
	}-*/;
	
	/**
	 * Animate a linear transition of this circle.
	 * @param target Another circle shape - defines the characteristics that the current circle will have at the end of the animation
	 * @param duration The time it will take for the animation to complete, in seconds
	 * @return An object for controlling the transition.
	 */
	public final Transition transitionTo(Ellipse target, double duration) {
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
	public final Transition transitionTo(Ellipse target, double duration, EasingFunction ease, Runnable callback) {
		StringBuffer sb = new StringBuffer();
		if (this.getRadius() != target.getRadius()) sb.append("radius: {x:").append(target.getRadius().x).append(", y: ").append(target.getRadius().y).append("},");
		return transitionToShape(target, sb, duration, ease, callback);
	}
}
