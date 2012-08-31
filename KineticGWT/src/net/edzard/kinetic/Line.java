package net.edzard.kinetic;

import java.util.ArrayList;
import java.util.List;

/**
 * A line object.
 * Consists of a number of points, which are connected using straight lines.
 * Lines can have a style (e.g. they can be dashed).
 * @author Ed
 */
public class Line extends Polygon {	// Makes sense from code re-use point of view: Polygon defines "points"

	/**
	 * Pre-defined line styles.
	 * @author Ed
	 */
	public enum LineStyle {
		
		/** A continuous line  style */
		NORMAL (),
		
		/** A dashed line style */
		DASHED (20,15),
		
		/** A dotted line style */
		DOTS (1, 15);
		
		/** Holds the definition of the dashes */
		List<Integer> dashes = new ArrayList<Integer>();
		
		/** 
		 * Parametrized Ctor.
		 * @param dashes Initialize with a certain setting of dashes 
		 */
		LineStyle(int... dashes) {
			for (int i: dashes) this.dashes.add(i);
		}
	}

	/**
	 * Line cap definitions.
	 * They control how line ends are displayed.
	 * @author Ed
	 */
	public enum LineCap {
		
		/** A 'butted' style */
		BUTT,
		
		/** A 'round' style */
		ROUND,
		
		/** A 'square' style */
		SQUARE
	}
	
	/** Protected Ctor keeps GWT happy */
	protected Line() {}
	
	/**
	 * Retrieve first point of the line shape.
	 * Convenience method. 
	 * @return The first point of the line
	 */
	public final native Vector2d getStart() /*-{
		var v = this.getPoints()[0];
		return @net.edzard.kinetic.Vector2d::new(DD)(v.x, v.y);
	}-*/;
	
	/**
	 * Assign new position to first point on line.
	 * @param position A new position value
	 */
	public final native void setStart(Vector2d position) /*-{
		var vCurrent = this.getPoints()[0];
		vCurrent.x = position.@net.edzard.kinetic.Vector2d::x;
		vCurrent.y = position.@net.edzard.kinetic.Vector2d::y;
	}-*/;
	
	/**
	 * Retrieve the last point of the line shape.
	 * Convenience method.
	 * @return The last point of the line
	 */
	public final native Vector2d getEnd() /*-{
		var points = this.getPoints();
		var v = points[points.length - 1];
		return @net.edzard.kinetic.Vector2d::new(DD)(v.x, v.y);
	}-*/;
	
	/**
	 * Assign new position to last point on line.
	 * @param position A new position value
	 */
	public final native void setEnd(Vector2d position) /*-{
		var points = this.getPoints();
		var vCurrent = points[points.length - 1];
		vCurrent.x = position.@net.edzard.kinetic.Vector2d::x;
		vCurrent.y = position.@net.edzard.kinetic.Vector2d::y;
	}-*/;
	
	/**
	 * Retrieve the line cap definition for this line shape.
	 * @return The line cap style
	 */
	public final native LineCap getLineCap() /*-{
		if (this.getLineCap() != null) return @net.edzard.kinetic.Line.LineCap::valueOf(Ljava/lang/String;)(this.getLineCap().toUpperCase());
		else return null;
	}-*/;
	
	/**
	 * Assign a line cap definition for this line shape.
	 * @param lc The line cap style
	 */
	public final native void setLineCap(LineCap lc) /*-{
		this.setLineCap(lc.@net.edzard.kinetic.Line.LineCap::toString()().toLowerCase());
	}-*/;
	
	/**
	 * Retrieve definition of the line style.
	 * Line styles are defined by a list of numbers defining the length of a dash, followed by the length of a gap.
	 * @return The current line style definition
	 */
	public final native List<Integer> getDashes()  /*-{
		var result = @java.util.ArrayList::new()();
		var dashes = this.getDashArray();
		for (var i=0; i < dashes.length; ++i) {
			result.@java.util.ArrayList::add(Ljava/lang/Object;)(@java.lang.Integer::new(Ljava/lang/String;)(dashes[i].toString()));
		}
		return result;
	}-*/;
	
	/**
	 * Assign line style definitions
	 * @param dashes The line style: a list of numbers defining the length of a dash, followed by the length of a gap.
	 */
	public final native void setDashes(List<Integer> dashes) /*-{
		var d = [];
		for (var i=0; i < dashes.@java.util.List::size()(); ++i) {
			d.push(dashes.@java.util.List::get(I)(i).@java.lang.Integer::intValue()());
		}
		this.setDashArray(d);
	}-*/;
	
	/**
	 * Assign a pre-defined line style definition.
	 * @param style The pre-defined line style
	 */
	public final void setLineStyle(LineStyle style) {
		setDashes(style.dashes);
	}
	
	/**
	 * Animate a linear transition of this line shape.
	 * @param target Another line shape - defines the characteristics that the current line shape will have at the end of the animation
	 * @param duration The time it will take for the animation to complete, in seconds
	 * @return An object for controlling the transition.
	 */
	public final Transition transitionTo(Line target, double duration) {
		return transitionTo(target, duration, null, null);
	}
	
	/**
	 * Animate a transition of this line shape.
	 * @param target Another line shape - defines the characteristics that the current line shape will have at the end of the animation
	 * @param duration The time it will take for the animation to complete, in seconds
	 * @param ease An easing function that defines how the transition will take place
	 * @param callback A function that will be called at the end of the animation
	 * @return An object for controlling the transition.
	 */
	// Delegates to shape (no special properties to animate)
	public final Transition transitionTo(Line target, double duration, EasingFunction ease, Runnable callback) {
		StringBuffer sb = new StringBuffer();
		return transitionToShape(target, sb, duration, ease, callback);
	}
}
