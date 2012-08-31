package net.edzard.kinetic;

/**
 * Defines properties for a shadow.
 * Shadows can be assigned to any shape.
 * @author Ed
 * @see Shapes
 */
public class Shadow {

	/** The shadows's colour (default: black) */
	private Colour colour;
	/** The shadow's gaussian blur (default 10) */
	private double blur;
	/** The shadow's offset (default 5x5) */
	private Vector2d offset;
	/** The shadow's alpha value (default 0.75) */
	private double alpha;
	
	/**
	 * Default Ctor.
	 */
	public Shadow() {
		colour = Colour.black;
		blur = 10;
		offset = new Vector2d(5,5);
		alpha = 0.75;
	}
	
	/**
	 * Parametrized Ctor.
	 * @param colour Shadow colour
	 * @param blur Gaussian blur
	 * @param offset Offset in relation to shape
	 * @param alpha Transparency of the shadow (0 is fully transparent, 1 is fully opaque)
	 */
	public Shadow(Colour colour, double blur, Vector2d offset, double alpha) {
		this.colour = colour;
		this.blur = blur;
		this.offset = offset;
		this.alpha = alpha;
	}

	/**
	 * Retrieve the shadow's colour.
	 * @return The colour value
	 */
	public Colour getColour() {
		return colour;
	}

	/**
	 * Assign the shadow colour.
	 * @param colour A colour value
	 */
	public void setColour(Colour colour) {
		this.colour = colour;
	}

	/** 
	 * Retrieve the shadow's gaussian blur.
	 * @return The blur value
	 */
	public double getBlur() {
		return blur;
	}
	
	/**
	 * Assign the shadow's gaussian blur.
	 * @param blur A new blur value
	 */
	public void setBlur(double blur) {
		this.blur = blur;
	}

	/**
	 * Retrieve the shadow's offset.
	 * @return The offset value, relative to shape
	 */
	public Vector2d getOffset() {
		return offset;
	}

	/**
	 * Assign the shadow's offset.
	 * @param offset An offset value relative to the shape
	 */
	public void setOffset(Vector2d offset) {
		this.offset = offset;
	}

	/**
	 * Retrieve the shadow's alpha value.
	 * @return The alpha value
	 */
	public double getAlpha() {
		return alpha;
	}

	/**
	 * Assign the shadow's alpha value.
	 * @param alpha A new alpha value
	 */
	public void setAlpha(double alpha) {
		this.alpha = alpha;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Shadow [colour=" + colour + ", blur=" + blur + ", offset="
				+ offset + ", alpha=" + alpha + "]";
	}
	
	
}
