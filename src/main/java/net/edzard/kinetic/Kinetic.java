package net.edzard.kinetic;

import java.util.List;
import java.util.Map;

import net.edzard.kinetic.Line.LineCap;
import net.edzard.kinetic.Shape.LineJoin;

import com.google.gwt.dom.client.Element;
import com.google.gwt.resources.client.ImageResource;

/**
 * Factory class for creating Kinetic objects.
 * Use methods from this class to create Kinetic objects. This class has some default settings that can be overridden. 
 * Once overriden, all subsequently created objects will use the new defaults.
 * @author Ed
 */
public class Kinetic {
	
	/** Default stroke width (1 pixel) */
	public static double defaultStrokeWidth = 1.0;
	/** Default fill colour (white) */
	public static String defaultFillColour = Colour.white.toString();
	/** Default stroke colour (black) */
	public static String defaultStrokeColour = Colour.black.toString();
	
	/** Default fill colour for text (black) */
	public static String defaultTextFillColour = Colour.black.toString();
	
	/** Default line cap style (ROUND) */
	public static String defaultLineCap = LineCap.ROUND.toString();
	/** Default line join style (ROUND) */
	public static String defaultLineJoin = LineJoin.ROUND.toString();
	
	/** Default font family (Arial) */
	public static String defaultFontFamily = "Arial";
	/** Default font size (14) */
	public static int defaultFontSize = 12;
	/** Default font style (normal) */
	public static String defaultFontStyle = Text.FontStyle.NORMAL.toString(); 
	/** Default dragability == Is a node dragable? (true) */ 
	public static boolean defaultDragability = true;

	/**
	 * Create a new stage object.
	 * @param stageContainer The DOM element that Kinetic should use
	 * @param stageWidth The stage's horizontal extent
	 * @param stageHeight The stage's vertical extent
	 * @return A stage object.
	 * @see Stage
	 */
	public static native Stage createStage(Element stageContainer, int stageWidth, int stageHeight) /*-{
	    return new $wnd.Kinetic.Stage({
	        container: stageContainer,
	        width: stageWidth,
	        height: stageHeight
		});
	}-*/;
	  
	/**
	 * Create a layer object.
	 * The layer will be independent and needs to be added to a stage.
	 * @return A new layer object
	 * @see Layer
	 */
	public static native Layer createLayer() /*-{
	    return new $wnd.Kinetic.Layer();
	}-*/;
	
	/**
	 * Create a layer object.
	 * This method also adds the layer to a given stage.
	 * @param stage The stage to add the layer to
	 * @return A new layer object
	 * @see Layer
	 */
	public static Layer createLayer(Stage stage) {
		final Layer layer = Kinetic.createLayer();
		stage.add(layer);
		return layer;
	}
	  
	/**
	 * Create a circle shape.
	 * @param position The initial position
	 * @param r The radius of the circle
	 * @return The circle shape
	 * @see Circle
	 */
	public static native Circle createCircle(Vector2d position, double r) /*-{
	    return new $wnd.Kinetic.Circle({
          x: position.@net.edzard.kinetic.Vector2d::x,
          y: position.@net.edzard.kinetic.Vector2d::y,
          radius: r,
		  fill: @net.edzard.kinetic.Kinetic::defaultFillColour,
          stroke: @net.edzard.kinetic.Kinetic::defaultStrokeColour,
          strokeWidth: @net.edzard.kinetic.Kinetic::defaultStrokeWidth,
          lineJoin: @net.edzard.kinetic.Kinetic::defaultLineJoin,
          draggable: @net.edzard.kinetic.Kinetic::defaultDragability
        });
	}-*/;
	
	/**
	 * Create an ellipse shape.
	 * @param position The initial position
	 * @param radius The radius of the elipse (x and y component)
	 * @return The ellipse shape
	 * @see Ellipse
	 */
	public static native Ellipse createEllipse(Vector2d position, Vector2d radius) /*-{
	    return new $wnd.Kinetic.Ellipse({
          x: position.@net.edzard.kinetic.Vector2d::x,
          y: position.@net.edzard.kinetic.Vector2d::y,
          radius: {x: radius.@net.edzard.kinetic.Vector2d::x, y: radius.@net.edzard.kinetic.Vector2d::y},
		  fill: @net.edzard.kinetic.Kinetic::defaultFillColour,
          stroke: @net.edzard.kinetic.Kinetic::defaultStrokeColour,
          strokeWidth: @net.edzard.kinetic.Kinetic::defaultStrokeWidth,
          lineJoin: @net.edzard.kinetic.Kinetic::defaultLineJoin,
          draggable: @net.edzard.kinetic.Kinetic::defaultDragability
        });
	}-*/;
	
	
	/**
	 * Create a rectangle shape.
	 * @param position The initial position and extent.
	 * @return The rectangle shape
	 * @see Rectangle
	 */
	public static native Rectangle createRectangle(Box2d position) /*-{
	    return new $wnd.Kinetic.Rect({
	      x: position.@net.edzard.kinetic.Box2d::left,
	      y: position.@net.edzard.kinetic.Box2d::top,
	      width: position.@net.edzard.kinetic.Box2d::right - position.@net.edzard.kinetic.Box2d::left,
	      height: position.@net.edzard.kinetic.Box2d::bottom - position.@net.edzard.kinetic.Box2d::top,
		  fill: @net.edzard.kinetic.Kinetic::defaultFillColour,
          stroke: @net.edzard.kinetic.Kinetic::defaultStrokeColour,
          strokeWidth: @net.edzard.kinetic.Kinetic::defaultStrokeWidth,
          lineJoin: @net.edzard.kinetic.Kinetic::defaultLineJoin,          
          draggable: @net.edzard.kinetic.Kinetic::defaultDragability
	    });
	}-*/;
	
	/**
	 * Create an image shape.
	 * @param position The initial position
	 * @param img The image to use (no inlined image urls)
	 * @return An image shape
	 * @see Image
	 */
	public static native Image createImage(Vector2d position, com.google.gwt.user.client.ui.Image img) /*-{
	    return new $wnd.Kinetic.Image({
	      x: position.@net.edzard.kinetic.Vector2d::x,
	      y: position.@net.edzard.kinetic.Vector2d::y,
	      width: img.@com.google.gwt.user.client.ui.Image::getWidth()(),
	      height: img.@com.google.gwt.user.client.ui.Image::getHeight()(),
	      image: img.@com.google.gwt.user.client.ui.Image::getElement()(),
	      draggable: @net.edzard.kinetic.Kinetic::defaultDragability
	    });
	}-*/;

	/**
	 * Create an image shape.
	 * @param position The initial position
	 * @param img The image resource to use
	 * @return An image shape
	 */
	public static native Image createImage(Vector2d position, ImageResource res) /*-{
		img = @com.google.gwt.user.client.ui.Image::new(Lcom/google/gwt/safehtml/shared/SafeUri;)(res.@com.google.gwt.resources.client.ImageResource::getSafeUri()()); 
	    return new $wnd.Kinetic.Image({
	      x: position.@net.edzard.kinetic.Vector2d::x,
	      y: position.@net.edzard.kinetic.Vector2d::y,
	      width: img.@com.google.gwt.user.client.ui.Image::getWidth()(),
	      height: img.@com.google.gwt.user.client.ui.Image::getHeight()(),
	      image: img.@com.google.gwt.user.client.ui.Image::getElement()(),
	      draggable: @net.edzard.kinetic.Kinetic::defaultDragability
	    });
	}-*/;
	
	/**
	 * Create a sprite shape.
	 * @param position The initial position
	 * @param img The image to use for the sprite frames
	 * @param animationKey The initial animation key
	 * @param frames Definition of the animation sequences using croping boxes on the given image
	 * @return A sprite object
	 * @see Sprite
	 */
	public static Sprite createSprite(Vector2d position, com.google.gwt.user.client.ui.Image img, String animationKey, Map<String, List<Box2d>> frames) {
		Sprite s = createSprite(position, img, animationKey);
		s.setFrames(frames);
		return s;
	}
	
	/**
	 * Create a sprite shape without the animation sequence definition.
	 * @param position The initial position
	 * @param img The image to use for the sprite frames
	 * @param animationKey The initial animation key
	 * @return A sprite object
	 * @see Sprite
	 */
	private static native Sprite createSprite(Vector2d position, com.google.gwt.user.client.ui.Image img, String animationKey) /*-{
    return new $wnd.Kinetic.Sprite({
      x: position.@net.edzard.kinetic.Vector2d::x,
      y: position.@net.edzard.kinetic.Vector2d::y,
      width: img.@com.google.gwt.user.client.ui.Image::getWidth()(),
      height: img.@com.google.gwt.user.client.ui.Image::getHeight()(),
      image: img.@com.google.gwt.user.client.ui.Image::getElement()(),
      animation: animationKey,
      draggable: @net.edzard.kinetic.Kinetic::defaultDragability
    });
    }-*/;
	
	/**
	 * Create a sprite shape.
	 * @param position The initial position
	 * @param res The image resource to use for the sprite frames
	 * @param animationKey The initial animation key
	 * @param frames Definition of the animation sequences using croping boxes on the given image
	 * @return A sprite object
	 * @see Sprite
	 */
	public static Sprite createSprite(Vector2d position, ImageResource res, String animationKey, Map<String, List<Box2d>> frames) {
		Sprite s = createSprite(position, res, animationKey);
		s.setFrames(frames);
		return s;
	}
	
	/**
	 * Create a sprite shape without the animation sequence definition.
	 * @param position The initial position
	 * @param res The image resource to use for the sprite frames
	 * @param animationKey The initial animation key
	 * @param frames Definition of the animation sequences using croping boxes on the given image
	 * @return A sprite object
	 * @see Sprite
	 */
	private static native Sprite createSprite(Vector2d position, ImageResource res, String animationKey) /*-{
		img = @com.google.gwt.user.client.ui.Image::new(Lcom/google/gwt/safehtml/shared/SafeUri;)(res.@com.google.gwt.resources.client.ImageResource::getSafeUri()()); 
	    return new $wnd.Kinetic.Sprite({
	      x: position.@net.edzard.kinetic.Vector2d::x,
	      y: position.@net.edzard.kinetic.Vector2d::y,
	      width: img.@com.google.gwt.user.client.ui.Image::getWidth()(),
	      height: img.@com.google.gwt.user.client.ui.Image::getHeight()(),
	      image: img.@com.google.gwt.user.client.ui.Image::getElement()(),
	      animation: animationKey,
	      draggable: @net.edzard.kinetic.Kinetic::defaultDragability
	    });
	}-*/;
	
	/**
	 * Create a text shape.
	 * @param position The initial position
	 * @param aText The text
	 * @return A text shape
	 * @see Text
	 */
	public static native Text createText(Vector2d position, String aText) /*-{
	    return new $wnd.Kinetic.Text({
		  x: position.@net.edzard.kinetic.Vector2d::x,
		  y: position.@net.edzard.kinetic.Vector2d::y,
		  text: aText,
		  textFill: @net.edzard.kinetic.Kinetic::defaultTextFillColour,
		  fontStyle: @net.edzard.kinetic.Kinetic::defaultFontStyle,
		  fontSize: @net.edzard.kinetic.Kinetic::defaultFontSize,
		  fontFamily: @net.edzard.kinetic.Kinetic::defaultFontFamily,
		  draggable: @net.edzard.kinetic.Kinetic::defaultDragability
	    });
	}-*/;

	/**
	 * Create a text shape that follows a SVG path.
	 * A SVG path string is made up from path commands (see <a href="http://www.w3.org/TR/SVG/paths.html">W3C SVG 1.1 TR</a>).
	 * @param position The initial position
	 * @param aText The text
	 * @param d The SVG path string
	 * @return A text path shape
	 * @see PathSVG
	 */
	public static native TextPath createTextPath(Vector2d position, String aText, String d) /*-{
	    return new $wnd.Kinetic.TextPath({
	      x: position.@net.edzard.kinetic.Vector2d::x,
	      y: position.@net.edzard.kinetic.Vector2d::y,
	      text: aText,
	      textFill: @net.edzard.kinetic.Kinetic::defaultTextFillColour,
		  fontStyle: @net.edzard.kinetic.Kinetic::defaultFontStyle,
		  fontSize: @net.edzard.kinetic.Kinetic::defaultFontSize,
		  fontFamily: @net.edzard.kinetic.Kinetic::defaultFontFamily,
	      data: d,
	      draggable: @net.edzard.kinetic.Kinetic::defaultDragability
	    });
	}-*/;
	
	/**
	 * Create a line shape.
	 * The line will consist of only two points.
	 * Use {@link Line#setPoints(List)} to set more than two.
	 * @param start The start point
	 * @param end The end point
	 * @return A line object
	 * @see Line
	 */
	public static native Line createLine(Vector2d start, Vector2d end) /*-{
		return new $wnd.Kinetic.Line({
			points: [start.@net.edzard.kinetic.Vector2d::x, start.@net.edzard.kinetic.Vector2d::y, 
					 end.@net.edzard.kinetic.Vector2d::x, end.@net.edzard.kinetic.Vector2d::y],
          	stroke:  @net.edzard.kinetic.Kinetic::defaultStrokeColour,
          	strokeWidth: @net.edzard.kinetic.Kinetic::defaultStrokeWidth,
          	lineCap: @net.edzard.kinetic.Kinetic::defaultLineCap,
          	lineJoin: @net.edzard.kinetic.Kinetic::defaultLineJoin,
			draggable: @net.edzard.kinetic.Kinetic::defaultDragability
		});
	}-*/;
	
	/**
	 * Create a line shape.
	 * The line will consist of a number of points.
	 * @param points
	 * @return A line object
	 * @see Line
	 */
	public static native Line createLine(List<Vector2d> lineDefinition) /*-{

		// Create line
		var line = new $wnd.Kinetic.Line({
          	stroke:  @net.edzard.kinetic.Kinetic::defaultStrokeColour,
          	strokeWidth: @net.edzard.kinetic.Kinetic::defaultStrokeWidth,
          	lineCap: @net.edzard.kinetic.Kinetic::defaultLineCap,
          	lineJoin: @net.edzard.kinetic.Kinetic::defaultLineJoin,
			draggable: @net.edzard.kinetic.Kinetic::defaultDragability
		});

		// Set points
		var points = [];
		var it = lineDefinition.@java.util.List::iterator()();
		while (it.@java.util.Iterator::hasNext()()) {
			var vec = it.@java.util.Iterator::next()();
			points.push({
				x: vec.@net.edzard.kinetic.Vector2d::x,
				y: vec.@net.edzard.kinetic.Vector2d::y
			});
		}  
		line.setPoints(points);
		return line;
	}-*/;
	
	/**
	 * Create a polygonal shape.
	 * The created polygon will be a triangle.
	 * Use {@link Polygon#setPoints(List)} to set different shape points.
	 * @param a First point
	 * @param b Second point
	 * @param c Third point
	 * @return A triangular polagon shape
	 * @see Polygon
	 */
	public static native Line createPolygon(Vector2d a, Vector2d b, Vector2d c) /*-{
		return new $wnd.Kinetic.Polygon({
			points: [{x: a.@net.edzard.kinetic.Vector2d::x, y: a.@net.edzard.kinetic.Vector2d::y}, 
					 {x: b.@net.edzard.kinetic.Vector2d::x, y: b.@net.edzard.kinetic.Vector2d::y},
					 {x: c.@net.edzard.kinetic.Vector2d::x, y: c.@net.edzard.kinetic.Vector2d::y}],
	      	fill: @net.edzard.kinetic.Kinetic::defaultFillColour,
	      	stroke:  @net.edzard.kinetic.Kinetic::defaultStrokeColour,
	      	strokeWidth: @net.edzard.kinetic.Kinetic::defaultStrokeWidth,
	      	lineJoin: @net.edzard.kinetic.Kinetic::defaultLineJoin,
			draggable: @net.edzard.kinetic.Kinetic::defaultDragability
			});
	}-*/;
	
	/**
	 * Create a regular polygon shape.
	 * @param position The initial position
	 * @param r The radius
	 * @param s The number of sides
	 * @return A regular polygon shape
	 * @see RegularPolygon
	 */
	public static native RegularPolygon createRegularPolygon(Vector2d position, double r, int s) /*-{
	    return new $wnd.Kinetic.RegularPolygon({
	      x: position.@net.edzard.kinetic.Vector2d::x,
	      y: position.@net.edzard.kinetic.Vector2d::y,
	      radius: r,
	      sides: s,
		  fill: @net.edzard.kinetic.Kinetic::defaultFillColour,
	      stroke: @net.edzard.kinetic.Kinetic::defaultStrokeColour,
	      strokeWidth: @net.edzard.kinetic.Kinetic::defaultStrokeWidth,
	      lineJoin: @net.edzard.kinetic.Kinetic::defaultLineJoin,
	      draggable: @net.edzard.kinetic.Kinetic::defaultDragability
	    });
	}-*/;
	
	/**
	 * Create a shape that is defined by a SVG path string.
	 * A SVG path string is made up from path commands (see <a href="http://www.w3.org/TR/SVG/paths.html">W3C SVG 1.1 TR</a>).
	 * @param position The initial position
	 * @param d The SVG path string
	 * @return A SVG path shape
	 * @see PathSVG
	 */
	public static native PathSVG createPathSVG(Vector2d position, String d) /*-{
	    return new $wnd.Kinetic.Path({
	      x: position.@net.edzard.kinetic.Vector2d::x,
	      y: position.@net.edzard.kinetic.Vector2d::y,
	      data: d,
		  fill: @net.edzard.kinetic.Kinetic::defaultFillColour,
	      stroke: @net.edzard.kinetic.Kinetic::defaultStrokeColour,
	      strokeWidth: @net.edzard.kinetic.Kinetic::defaultStrokeWidth,
	      lineJoin: @net.edzard.kinetic.Kinetic::defaultLineJoin,
	      draggable: @net.edzard.kinetic.Kinetic::defaultDragability
	    });
	}-*/;
	
	/**
	 * Create a star shape.
	 * @param position The initial position
	 * @param innerR The inner radius of the star
	 * @param outerR The outer radius of the star
	 * @param num The number of points
	 * @return A star shape
	 * @see Star
	 */
	public static native Star createStar(Vector2d position, double innerR, double outerR, int num) /*-{
	    return new $wnd.Kinetic.Star({
	      x: position.@net.edzard.kinetic.Vector2d::x,
	      y: position.@net.edzard.kinetic.Vector2d::y,
	      innerRadius: innerR,
	      outerRadius: outerR,
	      numPoints: num,
		  fill: @net.edzard.kinetic.Kinetic::defaultFillColour,
	      stroke: @net.edzard.kinetic.Kinetic::defaultStrokeColour,
	      strokeWidth: @net.edzard.kinetic.Kinetic::defaultStrokeWidth,
	      lineJoin: @net.edzard.kinetic.Kinetic::defaultLineJoin,
	      draggable: @net.edzard.kinetic.Kinetic::defaultDragability
	    });
	}-*/;
	
	/**
	 * Create a custom shape.
	 * Custom shapes are defined using {@link Path} objects.
	 * @param position The initial position
	 * @return An undefined custom shape. A path still has to be set.
	 * @see CustomShape
	 */
	public static native CustomShape createCustomShape(Vector2d position) /*-{
	    return new $wnd.Kinetic.Shape({
	      x: position.@net.edzard.kinetic.Vector2d::x,
	      y: position.@net.edzard.kinetic.Vector2d::y,
		  fill: @net.edzard.kinetic.Kinetic::defaultFillColour,
	      stroke: @net.edzard.kinetic.Kinetic::defaultStrokeColour,
	      strokeWidth: @net.edzard.kinetic.Kinetic::defaultStrokeWidth,
	      lineJoin: @net.edzard.kinetic.Kinetic::defaultLineJoin,
	      drawFunc: function(context) {
	      	if (this.path != null) {
	      		
	      		// Prepare context
	      		//var context = this.getContext();
	      		
	      		// Iterate over commands
		      	var it = this.path.@net.edzard.kinetic.Path::getCommands()().@java.util.List::iterator()();
				while (it.@java.util.Iterator::hasNext()()) {
					var cmd = it.@java.util.Iterator::next()();
					
					// Process command by type
					switch (cmd.@net.edzard.kinetic.Path.Command::type) {
						
						// BEGIN PATH
						case @net.edzard.kinetic.Path.CommandType::BEGIN: 
							context.beginPath(); 
							break;
						
						// MOVE TO
						case @net.edzard.kinetic.Path.CommandType::MOVE:
							var vec = cmd.@net.edzard.kinetic.Path.MoveToCommand::getPosition()();
							context.moveTo(vec.@net.edzard.kinetic.Vector2d::x, vec.@net.edzard.kinetic.Vector2d::y);
							break;
								
						// CLOSE PATH
						case @net.edzard.kinetic.Path.CommandType::CLOSE: 
							context.closePath();
							break;							
							
						// LINE TO
						case @net.edzard.kinetic.Path.CommandType::LINE:
							var vec = cmd.@net.edzard.kinetic.Path.LineToCommand::getPosition()();
							context.lineTo(vec.@net.edzard.kinetic.Vector2d::x, vec.@net.edzard.kinetic.Vector2d::y);
							break;
							
						// QUADRATIC CURVE
						case @net.edzard.kinetic.Path.CommandType::QUADRATIC:
							var pos = cmd.@net.edzard.kinetic.Path.QuadraticCurveCommand::getPosition()();
							var cp = cmd.@net.edzard.kinetic.Path.QuadraticCurveCommand::getControlPoint()();
							context.quadraticCurveTo(
								cp.@net.edzard.kinetic.Vector2d::x, cp.@net.edzard.kinetic.Vector2d::y,
								pos.@net.edzard.kinetic.Vector2d::x, pos.@net.edzard.kinetic.Vector2d::y
							);
							break;
						
						// BEZIER CURVE
						case @net.edzard.kinetic.Path.CommandType::BEZIER:
							var pos = cmd.@net.edzard.kinetic.Path.BezierCurveCommand::getPosition()();
							var cp1 = cmd.@net.edzard.kinetic.Path.BezierCurveCommand::getControlPoint1()();
							var cp2 = cmd.@net.edzard.kinetic.Path.BezierCurveCommand::getControlPoint2()();
							context.bezierCurveTo(
								cp1.@net.edzard.kinetic.Vector2d::x, cp1.@net.edzard.kinetic.Vector2d::y,
								cp2.@net.edzard.kinetic.Vector2d::x, cp2.@net.edzard.kinetic.Vector2d::y,
								pos.@net.edzard.kinetic.Vector2d::x, pos.@net.edzard.kinetic.Vector2d::y
							);
							break;
							
						// ARCTO
						case @net.edzard.kinetic.Path.CommandType::ARCTO:
							var pos1 = cmd.@net.edzard.kinetic.Path.ArcToCommand::getPosition1()();
							var pos2 = cmd.@net.edzard.kinetic.Path.ArcToCommand::getPosition2()();
							var radius = cmd.@net.edzard.kinetic.Path.ArcToCommand::getRadius()();
							context.arcTo(
								pos1.@net.edzard.kinetic.Vector2d::x, pos1.@net.edzard.kinetic.Vector2d::y,
								pos2.@net.edzard.kinetic.Vector2d::x, pos2.@net.edzard.kinetic.Vector2d::y,
								radius
							);
							break;
						
						// ARC
						case @net.edzard.kinetic.Path.CommandType::ARC:
							var pos = cmd.@net.edzard.kinetic.Path.ArcCommand::getPosition()();
							var radius = cmd.@net.edzard.kinetic.Path.ArcCommand::getRadius()();
							var startAngle = cmd.@net.edzard.kinetic.Path.ArcCommand::getStartAngle()();
							var endAngle = cmd.@net.edzard.kinetic.Path.ArcCommand::getEndAngle()();
							var clockwise = cmd.@net.edzard.kinetic.Path.ArcCommand::isClockwise()();
							context.arc(
								pos.@net.edzard.kinetic.Vector2d::x, pos.@net.edzard.kinetic.Vector2d::y,
								radius, startAngle, endAngle, !clockwise
							);
							break;
						
						// RECT
						case @net.edzard.kinetic.Path.CommandType::RECT:
							var box = cmd.@net.edzard.kinetic.Path.RectCommand::getBox();
							context.rect(
								box.@net.edzard.kinetic.Box2d::left, box.@net.edzard.kinetic.Box2d::top,
								box.@net.edzard.kinetic.Box2d::right - box.@net.edzard.kinetic.Box2d::left, 
								box.@net.edzard.kinetic.Box2d::bottom - box.@net.edzard.kinetic.Box2d::top
							);
							break;
						
						// TODO: ELLIPSE?
 
					};
				}
				
				// Stroke and fill
				if (this.getFill() != null) this.fill(context);
				if (this.getStroke() != null) this.stroke(context);
	      	}
	      },
	      draggable: @net.edzard.kinetic.Kinetic::defaultDragability
	    });
	}-*/;

	/**
	 * Create a shape group.
	 * @return An empty group
	 * @see Group
	 */
	public static native Group createGroup() /*-{
	    return new $wnd.Kinetic.Group({
	      draggable: @net.edzard.kinetic.Kinetic::defaultDragability
	    });
	}-*/;
	
	/**
	 * Create a shape group.
	 * @param position The initial position
	 * @param rot The initial rotation
	 * @return A shape group with the given transformation assigned
	 * @see Group
	 */
	public static native Group createGroup(Vector2d position, double rot) /*-{
	    return new $wnd.Kinetic.Group({
	      x: position.@net.edzard.kinetic.Vector2d::x,
	      y: position.@net.edzard.kinetic.Vector2d::y,
	      rotation: rot,
	      draggable: @net.edzard.kinetic.Kinetic::defaultDragability
	    });
	}-*/;
	
	/**
	 * Create an Animation.
	 * @param context The context node (a layer)
	 * @param fct A custom drawing function
	 * @return An object that can be used to control the animation
	 */
	public static native Animation createAnimation(Node context, Drawable fct) /*-{
	    return new $wnd.Kinetic.Animation({
	     func: function(frame) {
            fct.@net.edzard.kinetic.Drawable::draw(Lnet/edzard/kinetic/Frame;)(@net.edzard.kinetic.Frame::new(DDD)(frame.lastTime, frame.time, frame.timeDiff));
          },
          node: context
	    });
	}-*/;
}
