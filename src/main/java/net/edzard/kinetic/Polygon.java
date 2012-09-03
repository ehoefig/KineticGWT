package net.edzard.kinetic;

import java.util.List;

/**
 * A polygon shape.
 * Polygons are defined by an arbitrary number of points.
 * @author Ed
 */
public class Polygon extends Shape {
	
	/** Protected default Ctor keeps GWT happy */
	protected Polygon() {}
	
	/**
	 * Retrieve a single point of the polygon shape definition.
	 * @param num The index number of the point to retrieve. There are no boundary checks implemented...
	 * @return The position of the point in shape coordinates
	 */
	public final native Vector2d getPoint(int num) /*-{
		var v = this.getPoints()[num];
		return @net.edzard.kinetic.Vector2d::new(DD)(v.x, v.y);
	}-*/;
	
	/**
	 * Change a point already contained in the polygon shape.
	 * @param num The index number of the point to change. It has to exist.
	 * @param position The new position to assign
	 */
	public final native void setPoint(int num, Vector2d position) /*-{
		var vCurrent = this.getPoints()[num];
		vCurrent.x = position.@net.edzard.kinetic.Vector2d::x;
		vCurrent.y = position.@net.edzard.kinetic.Vector2d::y;
	}-*/;
	
	/**
	 * Retrieve the polygon shape definition as a list of points. 
	 * @return A list of points
	 */
	public final native List<Vector2d> getPoints()  /*-{
		var resultList = @java.util.ArrayList::new()();
		var currentPoints = this.getPoints(); // Have to be in [{x,y},{x,y},...] form
		for (var i=0; i < currentPoints.length; ++i) {
			var vec = @net.edzard.kinetic.Vector2d::new(DD)(currentPoints[i].x, currentPoints[i].y);
			resultList.@java.util.ArrayList::add(Ljava/lang/Object;)(vec);
		} 
		return resultList;
	}-*/;

	/**
	 * Set the polygon shape using a number of points.
	 * @param givenPoints A list of points
	 */
	public final native void setPoints(List<Vector2d> givenPoints) /*-{
		var points = [];
		var it = givenPoints.@java.util.List::iterator()();
		while (it.@java.util.Iterator::hasNext()()) {
			var vec = it.@java.util.Iterator::next()();
			points.push({
				x: vec.@net.edzard.kinetic.Vector2d::x,
				y: vec.@net.edzard.kinetic.Vector2d::y
			});
		}  
		this.setPoints(points);
	}-*/;
	
	/**
	 * Animate a linear transition of this polygon shape.
	 * @param target Another polygon shape - defines the characteristics that the current polygon shape will have at the end of the animation
	 * @param duration The time it will take for the animation to complete, in seconds
	 * @return An object for controlling the transition.
	 */
	public final Transition transitionTo(Polygon target, double duration) {
		return transitionTo(target, duration, null, null);
	}
	
	/**
	 * Animate a transition of this polygon shape.
	 * @param target Another polygon shape - defines the characteristics that the current polygon shape will have at the end of the animation
	 * @param duration The time it will take for the animation to complete, in seconds
	 * @param ease An easing function that defines how the transition will take place
	 * @param callback A function that will be called at the end of the animation
	 * @return An object for controlling the transition.
	 */
	// Delegates to shape (no special properties to animate)
	public final Transition transitionTo(Polygon target, double duration, EasingFunction ease, Runnable callback) {
		StringBuffer sb = new StringBuffer();
		return transitionToShape(target, sb, duration, ease, callback);
	}
}
