package net.edzard.kinetic;

import java.util.List;
import java.util.Map;

import com.google.gwt.resources.client.ImageResource;

/**
 * A sprite shape.
 * Sprites display animation sequences. Animation sequences have an identifying name and consist of a sequence of frames.
 * Frames are defined using cropping areas on a single, large image.
 * @author Ed
 */
public class Sprite extends Shape {
	
	/** Protected default Ctor to keep GWT happy */ 
	protected Sprite() { }
	
	/**
	 * Retrieve the sprite image.
	 * @return The sprite image
	 */
	public final native com.google.gwt.user.client.ui.Image getImage() /*-{
		return @com.google.gwt.user.client.ui.Image::new(Lcom/google/gwt/dom/client/Element;)(this.getImage())
	}-*/;
	
	/**
	 * Assigns a sprite image.
	 * @param res A resource referring to the image to use
	 */
	public final void setImage(ImageResource res) {
		com.google.gwt.user.client.ui.Image img = new com.google.gwt.user.client.ui.Image(res.getSafeUri());
		setImage(img);
	}

	/**
	 * Assigns a sprite image.
	 * @param img An image to use. Does not support picture inlining.
	 */
	private final native void setImage(com.google.gwt.user.client.ui.Image img) /*-{
		this.setImage(img.@com.google.gwt.user.client.ui.Image::getElement()());
	}-*/;
	
	/**
	 * Retrieve the name of the currently playing animation sequence.
	 * @return The animation sequence's name
	 */
	public final native String getCurrentAnimationKey() /*-{
		return this.getAnimation();
	}-*/;

	/**
	 * Play a different animation sequence.
	 * @param key An existing animation sequence name
	 */
	public final native void setCurrentAnimationKey(String key) /*-{
		this.setAnimation(key);
	}-*/;
	
	/**
	 * Retrieve the animation sequence definitions.
	 * @return A map of animation sequences. Each sequence consists of an ordered list of frames (cropping areas referring to the image)
	 */
	public final native Map<String, List<Box2d>> getFrames() /*-{
		var result = @java.util.HashMap::new()();
		var animations = this.getAnimations();
		for (var name in animations) {
			var anim = @java.util.ArrayList::new()();
			for (var i=0; i < animations[name].length; ++i) {
				var frame = animations[name][i];
				var box = @net.edzard.kinetic.Box2d::new(DDDD)(frame.x, frame.y, frame.x + frame.width, frame.y + frame.height);
				anim.@java.util.ArrayList::add(Ljava/lang/Object;)(box);
			}
			result.@java.util.HashMap::put(Ljava/lang/Object;Ljava/lang/Object;)(name, anim);
		}
		return result;
	}-*/;
	
	/**
	 * Assign the animation sequence definitions.
	 * @param animationFrames A map of animation sequences. Each sequence consists of an ordered list of frames (cropping areas referring to the image)
	 */
	public final native void setFrames(Map<String, List<Box2d>> animationFrames) /*-{
		var anims = {};
		
		// Iterate over animations
		var animIt = animationFrames.@java.util.Map::keySet()().@java.util.Set::iterator()();
		while (animIt.@java.util.Iterator::hasNext()()) {
			var name = animIt.@java.util.Iterator::next()();
			anims[name] = [];
			
			// Iterate over frame lists
			var boxIt = animationFrames.@java.util.Map::get(Ljava/lang/Object;)(name).@java.util.List::iterator()();
			while (boxIt.@java.util.Iterator::hasNext()()) {
				var box = boxIt.@java.util.Iterator::next()();
				anims[name].push({
					x: box.@net.edzard.kinetic.Box2d::left,
            		y: box.@net.edzard.kinetic.Box2d::top,
            		width: box.@net.edzard.kinetic.Box2d::right - box.@net.edzard.kinetic.Box2d::left,
            		height: box.@net.edzard.kinetic.Box2d::bottom - box.@net.edzard.kinetic.Box2d::top	
				});
			}
		}
		
		this.setAnimations(anims);
	}-*/;
	
	/**
	 * Retrieve the frame rate.
	 * The frame rate defines how many frames should be displayed per second.
	 * @return The current frame rate
	 */
	public final native int getFrameRate() /*-{
		return this.attrs.frameRate;
	}-*/;
	
	/**
	 * Assign the frame rate.
	 * The frame rate defines how many frames should be displayed per second.
	 * @param rate A frame rate
	 */
	public final native void setFrameRate(int rate) /*-{
		this.attrs.frameRate = rate;
	}-*/;
	
	/**
	 * Start the sprite's animation. 
	 */
	public final native void start() /*-{
		return this.start();
	}-*/;
	
	/**
	 * Stop the sprite's animation.
	 */
	public final native void stop() /*-{
		return this.stop();
	}-*/;

	/**
	 * Animate a linear transition of this sprite shape.
	 * @param target Another sprite shape - defines the characteristics that the current sprite shape will have at the end of the animation
	 * @param duration The time it will take for the animation to complete, in seconds
	 * @return An object for controlling the transition.
	 */
	public final Transition transitionTo(Sprite target, double duration) {
		return transitionTo(target, duration, null, null);
	}
	
	/**
	 * Animate a transition of this sprite shape.
	 * The kineticjs framework does not seem to be able to animate the sprite's framerate.
	 * @param target Another sprite shape - defines the characteristics that the current sprite shape will have at the end of the animation
	 * @param duration The time it will take for the animation to complete, in seconds
	 * @param ease An easing function that defines how the transition will take place
	 * @param callback A function that will be called at the end of the animation
	 * @return An object for controlling the transition.
	 */
	public final Transition transitionTo(Sprite target, double duration, EasingFunction ease, Runnable callback) {
		StringBuffer sb = new StringBuffer();
		if (this.getFrameRate() != target.getFrameRate()) sb.append("frameRate:").append(target.getFrameRate()).append(",");
		return transitionToShape(target, sb, duration, ease, callback);
	}
	
}
