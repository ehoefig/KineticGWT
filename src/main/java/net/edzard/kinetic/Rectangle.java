package net.edzard.kinetic;

/**
 * A rectangular shape.
 * @author Ed
 */
public class Rectangle extends Shape {

	/** Protected default Ctor keeps GWT happy */ 
	protected Rectangle() {}
	
	public final native Box2d getSize() /*-{
		box = @net.edzard.kinetic.Box2d::new()();
		box.@net.edzard.kinetic.Box2d::left = this.getX();
		box.@net.edzard.kinetic.Box2d::top = this.getY();
		box.@net.edzard.kinetic.Box2d::right = this.getX() + this.getWidth();
		box.@net.edzard.kinetic.Box2d::bottom = this.getY() + this.getHeight();
		return box;
	}-*/;
	
	/**
	 * Retrieve the rectangle shape width.
	 * @return The width
	 */
	public final native double getWidth() /*-{
		return this.getWidth();
	}-*/;

	/**
	 * Assign the rectangle shape width.
	 * @param width A width value
	 */
	public final native void setWidth(double width) /*-{
		this.setWidth(width);
	}-*/;

	/**
	 * Retrieve the rectangle shape height.
	 * @return The width
	 */
	public final native double getHeight() /*-{
		return this.getHeight();
	}-*/;

	/**
	 * Assign the rectangle shape height.
	 * @param height A height value
	 */
	public final native void setHeight(double height) /*-{
		this.setHeight(height);
	}-*/;
	
	/**
	 * Retrieve the rectangle shape corner radius.
	 * @return The corner radius
	 */
	public final native double getCornerRadius() /*-{
		return this.getCornerRadius();
	}-*/;
	
	/**
	 * Assign the rectangle shape corner radius.
	 * Yes, we have rounded corners. :-)
	 * @param radius A radius for the rounding of corners
	 */
	public final native void setCornerRadius(double radius) /*-{
		this.setCornerRadius(radius);
	}-*/;
	 
	/**
	 * Animate a linear transition of this rectangle shape.
	 * @param target Another rectangle shape - defines the characteristics that the current rectangle shape will have at the end of the animation
	 * @param duration The time it will take for the animation to complete, in seconds
	 * @return An object for controlling the transition.
	 */
	public final Transition transitionTo(Rectangle target, double duration) {
		return transitionTo(target, duration, null, null);
	}
	
	/**
	 * Animate a transition of this rectangle shape.
	 * @param target Another rectangle shape - defines the characteristics that the current rectangle shape will have at the end of the animation
	 * @param duration The time it will take for the animation to complete, in seconds
	 * @param ease An easing function that defines how the transition will take place
	 * @param callback A function that will be called at the end of the animation
	 * @return An object for controlling the transition.
	 */
	public final Transition transitionTo(Rectangle target, double duration, EasingFunction ease, Runnable callback) {
		StringBuffer sb = new StringBuffer();
		if (this.getWidth() != target.getWidth()) sb.append("width:").append(target.getWidth()).append(",");
		if (this.getHeight() != target.getHeight()) sb.append("height:").append(target.getHeight()).append(",");
		if (this.getCornerRadius() != target.getCornerRadius()) sb.append("cornerRadius:").append(target.getCornerRadius()).append(",");
		return transitionToShape(target, sb, duration, ease, callback);
	}
}
