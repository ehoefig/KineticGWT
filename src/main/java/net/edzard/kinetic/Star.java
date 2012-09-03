package net.edzard.kinetic;

/**
 * A star shape.
 * Stars are defined by an outer and inner radius and a number of points. 
 * @author Ed
 */
public class Star extends Shape {

	/** Protected default Ctor keeps GWT happy */
	protected Star() {}
	
	/**
	 * Retrieve the outer radius of this star shape.
	 * @return The outer radius
	 */
	public final native double getOuterRadius() /*-{
		return this.getOuterRadius();
	}-*/;

	/**
	 * Assign the outer radius of this star shape.
	 * @param radius An outer radius value
	 */
	public final native void setOuterRadius(double radius) /*-{
		this.setOuterRadius(radius);
	}-*/;
	
	/**
	 * Retrieve the inner radius of this star shape.
	 * @return The inner radius
	 */	
	public final native double getInnerRadius() /*-{
		return this.getInnerRadius();
	}-*/;
	
	/**
	 * Assign the inner radius of this star shape.
	 * @param radius An inner radius value
	 */
	public final native void setInnerRadius(double radius) /*-{
		this.setInnerRadius(radius);
	}-*/;
	
	/**
	 * Retrieve the number of points for this star shape.
	 * @return The number of points
	 */
	public final native int getNumPoints() /*-{
		return this.getNumPoints();
	}-*/;
	
	/**
	 * Assign a number of points for this star shape.
	 * @param number A number of points
	 */
	public final native void setNumPoints(int number) /*-{
		this.setNumPoints(number);
	}-*/;
	
	/**
	 * Animate a linear transition of this star shape.
	 * @param target Another star shape - defines the characteristics that the current star shape will have at the end of the animation
	 * @param duration The time it will take for the animation to complete, in seconds
	 * @return An object for controlling the transition.
	 */
	public final Transition transitionTo(Star target, double duration) {
		return transitionTo(target, duration, null, null);
	}
	
	/**
	 * Animate a transition of this star shape.
	 * @param target Another star shape - defines the characteristics that the current star shape will have at the end of the animation
	 * @param duration The time it will take for the animation to complete, in seconds
	 * @param ease An easing function that defines how the transition will take place
	 * @param callback A function that will be called at the end of the animation
	 * @return An object for controlling the transition.
	 */
	public final Transition transitionTo(Star target, double duration, EasingFunction ease, Runnable callback) {
		StringBuffer sb = new StringBuffer();
		if (this.getInnerRadius() != target.getInnerRadius()) sb.append("innerRadius:").append(target.getInnerRadius()).append(",");
		if (this.getOuterRadius() != target.getOuterRadius()) sb.append("outerRadius:").append(target.getOuterRadius()).append(",");
		if (this.getNumPoints() != target.getNumPoints()) sb.append("numPoints:").append(target.getNumPoints()).append(",");
		return transitionToShape(target, sb, duration, ease, callback);
	}
}
