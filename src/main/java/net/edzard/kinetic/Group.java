package net.edzard.kinetic;

/**
 * Enables grouping of nodes.
 * The resulting group has a common coordinate system and transformation matrix.
 * Also, event handling is possible.
 * @author Ed
 */
public class Group extends Container {

	/** Protected ctor keeps GWT happy */
	protected Group() {}
	
	/**
	 * Animate a linear transition of this group.
	 * @param target Another group - defines the characteristics that the current group will have at the end of the animation
	 * @param duration The time it will take for the animation to complete, in seconds
	 * @return An object for controlling the transition.
	 */
	// Delegates to node (no special properties to animate)
	public final Transition transitionTo(Group target, double duration) {
		StringBuffer sb = new StringBuffer();
		return transitionToNode(target, sb, duration, null, null);
	}
	
	/**
	 * Animate a transition of this group.
	 * @param target Another group - defines the characteristics that the current group will have at the end of the animation
	 * @param duration The time it will take for the animation to complete, in seconds
	 * @param ease An easing function that defines how the transition will take place
	 * @param callback A function that will be called at the end of the animation
	 * @return An object for controlling the transition.
	 */
	// Delegates to node (no special properties to animate)
	public final Transition transitionTo(Group target, double duration, EasingFunction ease, Runnable callback) {
		StringBuffer sb = new StringBuffer();
		return transitionToNode(target, sb, duration, ease, callback);
	}
}
