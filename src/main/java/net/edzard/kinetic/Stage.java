package net.edzard.kinetic;

import java.util.List;

/**
 * Central class for drawing with Kinetic.
 * The stage contains everything that is drawn. It consists of layers, which in turn contain the shapes.
 * @author Ed
 * @see Layer
 */
public class Stage extends Container {
	
	/**
	 * Callback interface for receiveing a data URL string.
	 * @author Ed
	 */
	public interface DataUrlTarget {
		/**
		 * Receive a data URL string.
		 * @param url The data URL string
		 */
		public void receive(String url);
	}
	
	/** Protected default Ctor keeps GWT happy */
	protected Stage() {}

	/**
	 * Add a new layer to the stage.
	 * @param layer The new layer
	 */
	public final native void add(final Layer layer) /*-{
	    this.add(layer);
	  }-*/;

	/**
	 * Clears the stage.
	 * All layers are cleared. 
	 */
	public final native void clear() /*-{
		this.clear();
	}-*/;
	
	/**
	 * Resets the stage to it's default state.
	 */
	public final native void reset() /*-{
		this.reset();
	}-*/;
	
	/**
	 * Starts any animation on this stage.
	 */
	public final native void start() /*-{
		this.start();
	}-*/;
	
	/**
	 * Stops any animation on this stage.
	 */
	public final native void stop() /*-{
		this.stop();
	}-*/;

	/**
	 * Triggers a drawing operation of the complete stage.
	 */
	public final native void draw() /*-{
		this.draw();
	}-*/;
	
	/**
	 * Retrieve the user position.
	 * This is either a mouse or a touch position. 
	 * @return The last user position
	 */
	public final native Vector2d getUserPosition() /*-{
		var pos = this.getUserPosition(); //TODO: Why does it have a parameter (evt)?
		if (pos != null) return @net.edzard.kinetic.Vector2d::new(DD)(pos.x, pos.y);
		else return null;
	}-*/;

	/**
	 * Get all shapes that intersect with a given point.
	 * This works across layers
	 * @param position Position to check
	 * @return A list of shapes
	 */
	public final native List<Shape> getIntersections(Vector2d position) /*-{
		var intersections = this.getIntersections({x: position.@net.edzard.kinetic.Vector2d::x, y: position.@net.edzard.kinetic.Vector2d::y});
		var result = @java.util.ArrayList::new()();
		for (i=0; i < intersections.length; ++i) {
			result.@java.util.ArrayList::add(Ljava/lang/Object;)(intersections[i]);
		}
		return result;
	}-*/;
	
	/**
	 * Retrieve the size of the stage.
	 * @return The stage's size (x component is width, y component is height)
	 */
	public final Vector2d getSize() {
		return new Vector2d(getWidth(), getHeight());
	}
	
	/**
	 * Assign new size to stage.
	 * @param size The stage's new size (x component is width, y component is height)
	 */
	public final void setSize(Vector2d size) {
		setWidth((int)size.x);
		setHeight((int)size.y);
	}
	
	/**
	 * Retrieve the stage's width.
	 * @return The horizontal extent of the stage
	 */
	public final native int getWidth()  /*-{
		return this.getWidth();
	}-*/;
	
	/**
	 * Assign the stage's width.
	 * @param width A new horizontal extent for the stage
	 */
	public final native void setWidth(int width) /*-{
		this.setWidth(width);
	}-*/; 

	/**
	 * Retrieve the stage's height.
	 * @return The vertical extent of the stage
	 */
	public final native int getHeight()  /*-{
		return this.getHeight();
	}-*/;
	
	/**
	 * Assign the stage's height.
	 * @param height A new vertical extent for the stage
	 */
	public final native void setHeight(int height) /*-{
		this.setHeight(height);
	}-*/; 
	
	/**
	 * Animate a linear transition of this stage object.
	 * @param target Another stage object - defines the characteristics that the current stage object will have at the end of the animation
	 * @param duration The time it will take for the animation to complete, in seconds
	 * @return An object for controlling the transition.
	 */
	public final Transition transitionTo(Stage target, double duration) {
		return transitionTo(target, duration, null, null);
	}
	
	/**
	 * Animate a transition of this stage object.
	 * @param target Another stage object - defines the characteristics that the current stage object will have at the end of the animation
	 * @param duration The time it will take for the animation to complete, in seconds
	 * @param ease An easing function that defines how the transition will take place
	 * @param callback A function that will be called at the end of the animation
	 * @return An object for controlling the transition.
	 */
	// TODO: test animate height and width of stage
	public final Transition transitionTo(Stage target, double duration, EasingFunction ease, Runnable callback) {
		StringBuffer sb = new StringBuffer();
		if (this.getWidth() != target.getWidth()) sb.append("width:").append(target.getWidth()).append(",");
		if (this.getHeight() != target.getHeight()) sb.append("height:").append(target.getHeight()).append(",");
		return transitionToNode(target, sb, duration, ease, callback);
	}
	
	/**
	 * Retrieve a URL to the stage's data.
	 * The data url will refer to a PNG image
	 * The data url will be passed by means of a callback
	 * @param callback A callback handler that will receive the data url
	 */
	public final native void toDataURL(DataUrlTarget callback) /*-{
		this.toDataURL(function(dataUrl, mimeType, quality) {
		    callback.@net.edzard.kinetic.Stage.DataUrlTarget::receive(Ljava/lang/String;)(dataUrl);
		});
	}-*/; 
	
	/**
	 * Write the current stage definition to JSON.
	 * Doesn't serialize functions and images. These need to be written manually.
	 * @return A JSON representation of the stage
	 */ 
	public final native String toJSON()  /*-{
		return this.toJSON();
	}-*/;

	/**
	 * Read a stage definition from JSON.
	 * Doesn't read images and functions. These have to be read manually.
	 * @param json A definition (Obtained through a call to {@link Stage#toJSON()}
	 */
	public final native void fromJSON(String json)  /*-{
		return this.load(json);
	}-*/;
	
	/**
	 * Retrieves the throttle value for animations on this stage object.
	 * The throttle value influences how often drawing operations are executed.
	 * @return The throttle value in milliseconds.
	 */
	public final native int getThrottle()  /*-{
		return this.getThrottle();
	}-*/;
	
	/**
	 * Assign a throttle value for animation on this stage object.
	 * The throttle value influences how often drawing operations are executed.
	 * @param throttle The throttle value in milliseconds.
	 */
	public final native void setThrottle(int throttle) /*-{
		this.setThrottle(throttle);
	}-*/; 
}
