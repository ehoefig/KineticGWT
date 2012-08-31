package net.edzard.kinetic;

/**
 * A circular shape.
 * @author Ed
 */
public class Ellipse extends Shape {

	/** Protected default Ctor keeps GWT happy */
	protected Ellipse() {}
	
	/**
	 * Retrieve this ellipse's radii.
	 * @return The radii (x and y component)
	 */
	public final native Vector2d getRadii() /*-{
		return @net.edzard.kinetic.Vector2d::new(DD)(this.getRadius().x, this.getRadius().y);
	}-*/;
	
	/**
	 * Retrieve this ellipse's radius.
	 * This convenience function returns the x component of the radii.
	 * Used with circles only.
	 * @return The radius (x component)
	 */
	public final native double getRadius() /*-{
		return this.getRadius().x;
	}-*/;


	/**
	 * Assign a single radius.
	 * This creates a circle.
	 * @param radius The new radius value
	 */
	public final native void setRadius(double radius) /*-{
		this.setRadius({x: radius, y: radius});
		//this.setRadius([radius, radius]);
	}-*/;
	
	/**
	 * Assign two radii.
	 * This creates an ellipse
	 * @param radius The new radius value (x and y component)
	 */
	public final native void setRadii(Vector2d radii) /*-{
		//this.setRadius({x: radius.x, y: radius.y});
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
		if (this.getRadii() != target.getRadii()) sb.append("radius: {x:").append(target.getRadii().x).append(", y: ").append(target.getRadii().y).append("},");
		return transitionToShape(target, sb, duration, ease, callback);
	}
}
