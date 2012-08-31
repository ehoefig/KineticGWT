package net.edzard.kinetic;

/**
 * A regular polygon.
 * Regular polygons are defined using a radius and a number of sides.
 * @author Ed
 */
public class RegularPolygon extends Shape {

	/** Protected default Ctor keeps GWT happy */ 
	protected RegularPolygon() {}
	
	/**
	 * Retrieve this regular polygon's radius.
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
	 * Retrieve the number of sides for this regular polygon shape.
	 * @return The number of sides
	 */
	public final native int getSides() /*-{
		return this.getSides();
	}-*/;
	
	/**
	 * Assigns a number of sides.
	 * @param sides A new number of sides.
	 */
	public final native void setSides(int sides) /*-{
		this.setSides(sides);
	}-*/;
	
	/**
	 * Animate a linear transition of this regular polygon shape.
	 * @param target Another regular polygon shape - defines the characteristics that the current regular polygon shape will have at the end of the animation
	 * @param duration The time it will take for the animation to complete, in seconds
	 * @return An object for controlling the transition.
	 */
	public final Transition transitionTo(RegularPolygon target, double duration) {
		return transitionTo(target, duration, null, null);
	}
	
	/**
	 * Animate a transition of this regular polygon shape.
	 * @param target Another regular polygon shape - defines the characteristics that the current regular polygon shape will have at the end of the animation
	 * @param duration The time it will take for the animation to complete, in seconds
	 * @param ease An easing function that defines how the transition will take place
	 * @param callback A function that will be called at the end of the animation
	 * @return An object for controlling the transition.
	 */
	public final Transition transitionTo(RegularPolygon target, double duration, EasingFunction ease, Runnable callback) {
		StringBuffer sb = new StringBuffer();
		if (this.getRadius() != target.getRadius()) sb.append("radius:").append(target.getRadius()).append(",");
		if (this.getSides() != target.getSides()) sb.append("sides:").append(target.getSides()).append(",");
		return transitionToShape(target, sb, duration, ease, callback);
	}
}
