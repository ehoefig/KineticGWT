package net.edzard.kinetic;

/**
 * Defines signature for drawing callbacks. 
 * Used with custom drawing functions.
 * @author Ed
 */
public interface Drawable {
	
	/**
	 * Called when the custom drawing should take place.
	 * @param frame Gives some timing information 
	 */
	public void draw(Frame frame);
}
