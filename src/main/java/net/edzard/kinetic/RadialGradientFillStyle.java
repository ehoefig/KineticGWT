package net.edzard.kinetic;

/**
 * Radial gradient fill style.
 * Radial gradients define a colour transition between two circles. 
 * @author Ed
 */
public class RadialGradientFillStyle extends LinearGradientFillStyle {

	/** The start radius of the gradient */
	private double startRadius;
	/** The end radius of the gradient */
	private double endRadius;
	
	/**
	 * Parametrized Ctor.
	 * @param startPos The start position for the first circle
	 * @param startRadius The radius of the first circle
	 * @param endPos The position of the second circle
	 * @param endRadius The radius of the second circle
	 */
	public RadialGradientFillStyle(Vector2d startPos, double startRadius, Vector2d endPos, double endRadius) {
		super(startPos, endPos);
		this.startRadius = startRadius;
		this.endRadius = endRadius;
	}

	/**
	 * Retrieve the start radius for the gradient.
	 * @return The start radius
	 */
	public double getStartRadius() {
		return startRadius;
	}

	/**
	 * Retrieve the end radius for the gradient.
	 * @return The end radius
	 */
	public double getEndRadius() {
		return endRadius;
	}

}
