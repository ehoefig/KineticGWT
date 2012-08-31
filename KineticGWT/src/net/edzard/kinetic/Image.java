package net.edzard.kinetic;

import com.google.gwt.resources.client.ImageResource;

/**
 * An image shape.
 * @author Ed
 */
public class Image extends Shape {

	/** Protected ctor keeps GWT happy */
	protected Image() {}
	
	/**
	 * Retrieve the image object of the image shape.
	 * @return The image object
	 */
	public final native com.google.gwt.user.client.ui.Image getImage() /*-{
		return @com.google.gwt.user.client.ui.Image::new(Lcom/google/gwt/dom/client/Element;)(this.getImage())
	}-*/;
	
	/**
	 * Assign an image resource to this image shape.
	 * Automatically sets the image extents.
	 * @param res The resource to use for the image
	 */
	public final void setImage(ImageResource res) {
		com.google.gwt.user.client.ui.Image img = new com.google.gwt.user.client.ui.Image(res.getSafeUri());
		setImage(img);
		setWidth(res.getWidth());
		setHeight(res.getHeight());
	}

	/**
	 * Assign an image object to thus image shape.
	 * @param img The image object to use. Does not support picture inlining, so be careful where you get the picture from.
	 */
	// Does not support picture inlining
	private final native void setImage(com.google.gwt.user.client.ui.Image img) /*-{
		this.setImage(img.@com.google.gwt.user.client.ui.Image::getElement()());
	}-*/;
	
	/**
	 * Retrieve the image shape extents.
	 * @return The image shape extents. The <emph>x</emph> component contains the horizontal size, whereas the <emph>y</emph> component contains the vertical size. Surprise. 
	 */
	public final Vector2d getSize() {
		return new Vector2d(getWidth(), getHeight());
	}
	
	/**
	 * Assign the image shape extents.
	 * @param size The image extents. The <emph>x</emph> component contains the horizontal size, whereas the <emph>y</emph> component contains the vertical size.
	 */
	public final void setSize(Vector2d size) {
		setWidth(size.x);
		setHeight(size.y);
	}
	
	/**
	 * Retrieve the horizontal extent of the image shape.
	 * @return The image width
	 */
	private final native double getWidth() /*-{
		return this.getWidth();
	}-*/;

	/**
	 * Assign the horizontal extent of the image shape.
	 * @return The image width
	 */
	private final native void setWidth(double width) /*-{
		this.setWidth(width);
	}-*/;

	/**
	 * Retrieve the vertical extent of the image shape.
	 * @return The image heigth
	 */
	private final native double getHeight() /*-{
		return this.getHeight();
	}-*/;
	
	/**
	 * Assign the vertical extent of the image shape.
	 * @return The image height
	 */
	private final native void setHeight(double height) /*-{
		this.setHeight(height);
	}-*/;
	
	/**
	 * Retrieve the cropping area for the image shape.
	 * @return The cropping area. The area is defined in coordinates relative to the image shape origin.
	 */
	public final native Box2d getCrop() /*-{
		var box = @net.edzard.kinetic.Box2d::new()();
		box.@net.edzard.kinetic.Box2d::left = this.getCrop().x;
		box.@net.edzard.kinetic.Box2d::top = this.getCrop().y;
		box.@net.edzard.kinetic.Box2d::right = this.getCrop().x + this.getCrop().width;
		box.@net.edzard.kinetic.Box2d::bottom = this.getCrop().y + this.getCrop().height;
		return box;
	}-*/;

	/**
	 * Assing a cropping area to the image shape.
	 * @param box The cropping area. The area is defined in coordinates relative to the image shape origin.
	 */
	public final native void setCrop(Box2d box) /*-{
		this.setCrop({
			x: box.@net.edzard.kinetic.Box2d::left,
			y: box.@net.edzard.kinetic.Box2d::top,
			width: box.@net.edzard.kinetic.Box2d::right - box.@net.edzard.kinetic.Box2d::left,
			height: box.@net.edzard.kinetic.Box2d::bottom - box.@net.edzard.kinetic.Box2d::top
		});
	}-*/;
	
	/**
	 * Animate a linear transition of this image shape.
	 * @param target Another image shape - defines the characteristics that the current image shape will have at the end of the animation
	 * @param duration The time it will take for the animation to complete, in seconds
	 * @return An object for controlling the transition.
	 */
	public final Transition transitionTo(Image target, double duration) {
		return transitionTo(target, duration, null, null);
	}
	
	/**
	 * Animate a transition of this image shape.
	 * Transition of cropping area will only work if cropping area has been set.
	 * @param target Another image shape - defines the characteristics that the current image shape will have at the end of the animation
	 * @param duration The time it will take for the animation to complete, in seconds
	 * @param ease An easing function that defines how the transition will take place
	 * @param callback A function that will be called at the end of the animation
	 * @return An object for controlling the transition.
	 */
	public final Transition transitionTo(Image target, double duration, EasingFunction ease, Runnable callback) {
		StringBuffer sb = new StringBuffer();
		
		if (this.getWidth() != target.getWidth()) sb.append("width:").append(target.getWidth()).append(",");
		if (this.getHeight() != target.getHeight()) sb.append("height:").append(target.getHeight()).append(",");
		
		Box2d crop = target.getCrop();
		if (!Double.isNaN(crop.right) && !Double.isNaN(crop.bottom)) {
			if (this.getCrop() != target.getCrop()) {
				sb.append("crop:{x:").append(crop.left).append(",").append("y:").append(crop.top).append(",");
				sb.append("width:").append(crop.right - crop.left).append(",").append("height:").append(crop.bottom - crop.top).append("},");
			}
		}
		return transitionToShape(target, sb, duration, ease, callback);
	}
}
