package net.edzard.kinetic;

/**
 * Base class for all visible objects.
 * Contains functionality for:
 * <ul>
 * <li>Mouse and touch position detection
 * <li>Managing paint properties (stroke colour, width, fills, line joins, shadow)
 * </ul>
 * @author Ed
 *
 */
public abstract class Shape extends Node {

	/**
	 * Defines the way that to meeting lines are joined.
	 * @author Ed
	 */
	public enum LineJoin {
		MITER,
		ROUND,
		BEVEL
	}
	
	/**
	 * Proetected CTOR keeps GWT happy
	 */
	protected Shape() {}
	
	/**
	 * The shape will not use a stroke outline.
	 */
	public final native void clearStroke() /*-{
		this.setStroke(null);
	}-*/;

	/**
	 * Retrieve the outline stroke's colour
	 * @return The colour
	 */
	public final native Colour getStroke() /*-{
		return @net.edzard.kinetic.Colour::new(Ljava/lang/String;)(this.getStroke());
	}-*/;

	/**
	 * Assign an outline stroke colour.
	 * @param colour The colour
	 */
	public final native void setStroke(Colour colour) /*-{
		this.setStroke(colour.@net.edzard.kinetic.Colour::toString()());
	}-*/;
	
	/**
	 * Retrieve the outline stroke's width.
	 * @return The stroke width
	 */
	public final native double getStrokeWidth() /*-{
		if (this.getStrokeWidth() != null) return this.getStrokeWidth();
		else return 0;
	}-*/;

	/**
	 * Assign an outline stroke's width.
	 * @param width
	 */
	public final native void setStrokeWidth(double width) /*-{
		this.setStrokeWidth(width);
	}-*/;

	/**
	 * Retrieve the line join type.
	 * @return The line join type
	 */
	public final native LineJoin getLineJoin() /*-{
		if (this.getLineJoin() != null) return @net.edzard.kinetic.Shape.LineJoin::valueOf(Ljava/lang/String;)(this.getLineJoin().toUpperCase());
		else return null;
	}-*/;

	/**
	 * Assign a line join type.
	 * @param type Line join type
	 */
	public final native void setLineJoin(LineJoin type) /*-{
		this.setLineJoin(type.@net.edzard.kinetic.Shape.LineJoin::toString()().toLowerCase());
	}-*/;

	/**
	 * Get the current shadow used for the shape.
	 * @return The shadow definition
	 */
	public final native Shadow getShadow() /*-{
		if (this.getShadow() != null) {
			var shadow = @net.edzard.kinetic.Shadow::new()();
			if(this.getShadow().color != null)
	 			shadow.@net.edzard.kinetic.Shadow::setColour(Lnet/edzard/kinetic/Colour;)(@net.edzard.kinetic.Colour::new(Ljava/lang/String;)(this.getShadow().color));
			if(this.getShadow().blur != null) 
				shadow.@net.edzard.kinetic.Shadow::setBlur(D)(this.getShadow().blur);
			if(this.getShadow().offset != null) 
				shadow.@net.edzard.kinetic.Shadow::setOffset(Lnet/edzard/kinetic/Vector2d;)(@net.edzard.kinetic.Vector2d::new(DD)(this.getShadow().offset.x, this.getShadow().offset.y));
			if(this.getShadow().alpha != null) 
				shadow.@net.edzard.kinetic.Shadow::setAlpha(D)(this.getShadow().alpha);					
			return shadow;
		} else return null;
	}-*/;
	
	/**
	 * Assign a shadow to the shape.
	 * @param shadow A shadow definition
	 */
	public final native void setShadow(Shadow shadow) /*-{
		this.setShadow({
            color: shadow.@net.edzard.kinetic.Shadow::getColour()().@net.edzard.kinetic.Colour::toString()(),
            blur: shadow.@net.edzard.kinetic.Shadow::getBlur()(),
            offset: [shadow.@net.edzard.kinetic.Shadow::getOffset()().@net.edzard.kinetic.Vector2d::x, 
            		 shadow.@net.edzard.kinetic.Shadow::getOffset()().@net.edzard.kinetic.Vector2d::y],
            alpha: shadow.@net.edzard.kinetic.Shadow::getAlpha()()
          });
	}-*/;
	
	/**
	 * Removes the shadow of this shape.
	 */
	public final native void clearShadow() /*-{
		this.attrs.shadow = undefined;
	}-*/;
	
	/**
	 * Clears the shape's fill style
	 */
//	public final native void clearFill() /*-{
//		this.setFill(null);
//	}-*/;

	/**
	 * Retrieve the shape's fill style.
	 * @return The fill style
	 */
	public final native FillStyle getFill() /*-{
		
		// Is a fill style assigned?
		if (typeof(this.getFill()) == "undefined") return null;
		
		// Determine fill style
		if (typeof(this.getFill()) == "string") { 
			
			// Is a solid colour
			return @net.edzard.kinetic.Colour::new(Ljava/lang/String;)(this.getFill());	
		
		} else if (typeof(this.getFill()) == "object") { // gradient or pattern
			if (typeof(this.getFill().image) != "undefined") {
				
				// Is a pattern
				return @net.edzard.kinetic.PatternFillStyle::new(Lcom/google/gwt/user/client/ui/Image;Lnet/edzard/kinetic/RepetitionType;Lnet/edzard/kinetic/Vector2d;)(
					@com.google.gwt.user.client.ui.Image::new(Lcom/google/gwt/dom/client/Element;)(this.getFill().image),
					@net.edzard.kinetic.RepetitionType::fromValue(Ljava/lang/String;)(this.getFill().repeat),
					@net.edzard.kinetic.Vector2d::new(DD)(this.getFill().offset.x, this.getFill().offset.y)
				);
				
			} else if (typeof(this.getFill().start.radius) != "undefined") {
				
				// Is a radial gradient
				var start = this.attrs.fill.start;
				var end = this.attrs.fill.end; 
				var gradient =  @net.edzard.kinetic.RadialGradientFillStyle::new(Lnet/edzard/kinetic/Vector2d;DLnet/edzard/kinetic/Vector2d;D)(
					@net.edzard.kinetic.Vector2d::new(DD)(start.x, start.y),
					start.radius,
					@net.edzard.kinetic.Vector2d::new(DD)(end.x, end.y),
					end.radius
				);
				var colourStops = this.attrs.fill.colorStops;
				for (i=0; i < colourStops.length; i+=2) {
					gradient.@net.edzard.kinetic.RadialGradientFillStyle::setColourStop(DLnet/edzard/kinetic/Colour;)(
						colourStops[i],
						@net.edzard.kinetic.Colour::new(Ljava/lang/String;)(colourStops[i+1])
					);
				}
				return gradient;
				
			} else {
				
				// Is a linear gradient
				var start = this.attrs.fill.start;
				var end = this.attrs.fill.end; 
				var gradient =  @net.edzard.kinetic.LinearGradientFillStyle::new(Lnet/edzard/kinetic/Vector2d;Lnet/edzard/kinetic/Vector2d;)(
					@net.edzard.kinetic.Vector2d::new(DD)(start.x, start.y),
					@net.edzard.kinetic.Vector2d::new(DD)(end.x, end.y)
				);
				var colourStops = this.attrs.fill.colorStops;
				for (i=0; i < colourStops.length; i+=2) {
					gradient.@net.edzard.kinetic.LinearGradientFillStyle::setColourStop(DLnet/edzard/kinetic/Colour;)(
						colourStops[i],
						@net.edzard.kinetic.Colour::new(Ljava/lang/String;)(colourStops[i+1])
					);
				}
				return gradient;
			}
		}
	}-*/;
	
	/**
	 * Assign a solid colour fill to the shape.
	 * @param colour The colour to use
	 */
	public final native void setFill(Colour colour) /*-{
		this.setFill(colour.@net.edzard.kinetic.Colour::toString()());
	}-*/;
	
	/**
	 * Assign an image pattern fill to the shape.
	 * @param pattern The image pattern
	 */
	// TODO: Wait for fix from Kinetic guy (3.9.7 seems to be buggy when setting a pattern fill on a previously solid filled shape)
	public final native void setFill(PatternFillStyle pattern) /*-{
		 this.attrs.fill = {
			image: pattern.@net.edzard.kinetic.PatternFillStyle::getImage()().@com.google.gwt.user.client.ui.Image::getElement()(),
			offset: {x: pattern.@net.edzard.kinetic.PatternFillStyle::getOffset()().@net.edzard.kinetic.Vector2d::x, 
            		 y: pattern.@net.edzard.kinetic.PatternFillStyle::getOffset()().@net.edzard.kinetic.Vector2d::y},
            repeat: pattern.@net.edzard.kinetic.PatternFillStyle::getRepetition()().@net.edzard.kinetic.RepetitionType::toString()()	 
          };
	}-*/;
	
	/**
	 * Assign a linear gradient fill to the shape.
	 * @param linearGradient The linear gradient fill style
	 */
	public final native void setFill(LinearGradientFillStyle linearGradient) /*-{
		
		// Create array of colour stops
		var theColourStops = [];
        var stopList = linearGradient.@net.edzard.kinetic.LinearGradientFillStyle::getColourStopPositions()();
        for (i=0; i < stopList.@java.util.List::size()(); ++i) {
        	var stop = stopList.@java.util.List::get(I)(i).@java.lang.Double::doubleValue()();
        	theColourStops.push(stop);
        	theColourStops.push(linearGradient.@net.edzard.kinetic.LinearGradientFillStyle::getColourforStopPosition(D)(stop).@net.edzard.kinetic.Colour::toString()());
        }
		
		this.attrs.fill = ({
			start: {
				x: linearGradient.@net.edzard.kinetic.LinearGradientFillStyle::getStart()().@net.edzard.kinetic.Vector2d::x, 
	            y: linearGradient.@net.edzard.kinetic.LinearGradientFillStyle::getStart()().@net.edzard.kinetic.Vector2d::y
	        },
	        end: {
				x: linearGradient.@net.edzard.kinetic.LinearGradientFillStyle::getEnd()().@net.edzard.kinetic.Vector2d::x, 
	            y: linearGradient.@net.edzard.kinetic.LinearGradientFillStyle::getEnd()().@net.edzard.kinetic.Vector2d::y
	        },
       		colorStops: theColourStops
		});
	}-*/;
	
	/**
	 * Assign a radial gradient fill to the shape.
	 * @param radialGradient A radial gradient fill style
	 */
	public final native void setFill(RadialGradientFillStyle radialGradient) /*-{
		
		// Create array of colour stops
		var theColourStops = [];
        var stopList = radialGradient.@net.edzard.kinetic.RadialGradientFillStyle::getColourStopPositions()();
        for (i=0; i < stopList.@java.util.List::size()(); ++i) {
        	var stop = stopList.@java.util.List::get(I)(i).@java.lang.Double::doubleValue()();
        	theColourStops.push(stop);
        	theColourStops.push(radialGradient.@net.edzard.kinetic.RadialGradientFillStyle::getColourforStopPosition(D)(stop).@net.edzard.kinetic.Colour::toString()());
        }
		
		this.attrs.fill = ({
			start: {
				x: radialGradient.@net.edzard.kinetic.RadialGradientFillStyle::getStart()().@net.edzard.kinetic.Vector2d::x, 
	            y: radialGradient.@net.edzard.kinetic.RadialGradientFillStyle::getStart()().@net.edzard.kinetic.Vector2d::y,
	            radius: radialGradient.@net.edzard.kinetic.RadialGradientFillStyle::getStartRadius()()
	        },
	        end: {
				x: radialGradient.@net.edzard.kinetic.RadialGradientFillStyle::getEnd()().@net.edzard.kinetic.Vector2d::x, 
	            y: radialGradient.@net.edzard.kinetic.RadialGradientFillStyle::getEnd()().@net.edzard.kinetic.Vector2d::y,
	            radius: radialGradient.@net.edzard.kinetic.RadialGradientFillStyle::getEndRadius()()
	        },
       		colorStops: theColourStops
		});
	}-*/;
	
	/**
	 * Animate a transition of the shape.
	 * Used internally to compose transitions.
	 * Don't use directly - use methods exposed by specialized shapes.
	 * @param target The target node (has to be the same type of node as the one on which this method is called)
	 * @param sb The composition buffer for the transition configuration
	 * @param duration The duration of the transition
	 * @param ease An easing function
	 * @param callback Will be called at the end of the transition
	 * @return An object to control the transition animation
	 */
	final Transition transitionToShape(Shape target, StringBuffer sb, double duration, EasingFunction ease, Runnable callback) {
		if (this.getStrokeWidth() != target.getStrokeWidth()) sb.append("strokeWidth:").append(target.getStrokeWidth()).append(",");
		return transitionToNode(target, sb, duration, ease, callback);
	}

	/**
	 * Check if a point is within the shape.
	 * @param point The coordinate to check
	 * @return True, if within the shape
	 */
	final native boolean intersects(Vector2d point) /*-{
		return this.intersects({
			x: point.@net.edzard.kinetic.Vector2d::x,
            y: point.@net.edzard.kinetic.Vector2d::y
          });
	}-*/;
	
	/**
	 * Set a custom drawing callback function.
	 * @param fct Will be called whenever Kinetic decides to redraw the shape
	 */
	// TODO: find out if this substitutes default drawing behaviour or is called in addition to it. 
	public final native void setDrawingFunction(Drawable fct) /*-{
		this.setDrawFunc(function(frame) {
          	fct.@net.edzard.kinetic.Drawable::draw(Lnet/edzard/kinetic/Frame;)(
          		@net.edzard.kinetic.Frame::new(DDD)(frame.lastTime, frame.time, frame.timeDiff)
          	);
        });
	}-*/; 
}
