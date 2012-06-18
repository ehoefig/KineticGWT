package net.edzard.kinetic;

/**
 * A RGBA colour value.
 * Used for defining all sorts of colours using red, green, blue and alpha (opacity) components.
 * @author Ed
 */
public class Colour implements FillStyle {
	
	/** The separate red component */
	private int red;
	
	/** The separate green component */
	private int green;
	
	/** The separate blue component */
	private int blue;
	
	/** The separate alpha component */
	private int alpha;
	
	/**
	 * Retrieve the red component.
	 * @return The red value
	 */
	public int getRed() {
		return red;
	}

	/**
	 * Set the red component.
	 * @param red The new value
	 */
	public void setRed(int red) {
		if (red > 255) this.red = 255; else if (red < 0) this.red = 0; else this.red =red;
	}

	/**
	 * Retrieve the green component.
	 * @return The green value
	 */
	public int getGreen() {
		return green;
	}

	/**
	 * Set the green component.
	 * @param green The new value
	 */
	public void setGreen(int green) {
		if (green > 255) this.green = 255; else if (green < 0) this.green = 0; else this.green = green;
	}

	/**
	 * Retrieve the blue component.
	 * @return The blue value
	 */
	public int getBlue() {
		return blue;
	}

	/**
	 * Set the blue component.
	 * @param blue The new value
	 */
	public void setBlue(int blue) {
		if (blue > 255) this.blue = 255; else if (blue < 0) this.blue = 0; else this.blue = blue;	
	}

	/**
	 * Retrieve the alpha component.
	 * @return The alpha value
	 */
	public int getAlpha() {
		return alpha;
	}

	/**
	 * Set the alpha component.
	 * @param alpha The new value
	 */
	public void setAlpha(int alpha) {
		this.alpha = alpha;
	}
	
	/** 
	 * Parametrized Ctor.
	 * Alpha is set to 255;
	 * @param red Red component (0..255)
	 * @param green Green component (0..255)
	 * @param blue Blue component (0..255)
	 */
	public Colour(int red, int green, int blue) {
		this.red = red;
		this.green = green;
		this.blue = blue;
		this.alpha = 255;
		if (red > 255) this.red = 255; else if (red < 0) this.red = 0;
		if (green > 255) this.green = 255; else if (green < 0) this.green = 0;
		if (blue > 255) this.blue = 255; else if (blue < 0) this.blue = 0;		
	}

	/** 
	 * Parametrized Ctor with separate components.
	 * @param red Red component (0..255)
	 * @param green Green component (0..255)
	 * @param blue Blue component (0..255)
	 * @param alpha Alpha component (0..255)
	 */
	public Colour(int red, int green, int blue, int alpha) {
		this.red = red;
		this.green = green;
		this.blue = blue;
		this.alpha = alpha;
		if (red > 255) this.red = 255; else if (red < 0) this.red = 0;
		if (green > 255) this.green = 255; else if (green < 0) this.green = 0;
		if (blue > 255) this.blue = 255; else if (blue < 0) this.blue = 0;	
		if (alpha > 255) this.alpha = 255; else if (alpha < 0) this.alpha = 0;	
	}

	/**
	 * Parametrized Ctor from a single webcolour string.
	 * @param webColour A colour string (e.g., '#FF0000')
	 */
	public Colour(final String webColour) {
		
		if (webColour.startsWith("#")) {
		
			// This is a web colour a la #RRGGBB
			
			red = Integer.parseInt(webColour.substring(1, 3), 16);
			if (red > 255) red = 255; else if (red < 0) red = 0;
			
			green = Integer.parseInt(webColour.substring(3, 5), 16);
			if (green > 255) green = 255; else if (green < 0) green = 0;
			
			blue = Integer.parseInt(webColour.substring(5, 7), 16);
			if (blue > 255) blue = 255; else if (blue < 0) blue = 0;
			
			alpha = 255;
			
		} else if (webColour.startsWith("rgba")) {
			
			// This is a RGBA quadruple
			int pos = webColour.indexOf(",", 0);
			red = Integer.parseInt(webColour.substring(5, pos));
			if (red > 255) red = 255; else if (red < 0) red = 0;
			int oldPos = pos;
			
			pos = webColour.indexOf(",", pos+1);
			green = Integer.parseInt(webColour.substring(oldPos+1, pos));
			if (green > 255) green = 255; else if (green < 0) green = 0;
			oldPos = pos;
			
			pos = webColour.indexOf(",", pos+1);
			blue = Integer.parseInt(webColour.substring(oldPos+1, pos));
			if (blue > 255) blue = 255; else if (blue < 0) blue = 0;
			oldPos = pos;
			
			pos = webColour.indexOf(")", pos+1);
			alpha = Integer.parseInt(webColour.substring(oldPos+1, pos));
			if (alpha > 255) alpha = 255; else if (alpha < 0) alpha = 0;
			oldPos = pos;
			
		} else {
			
			// This is a colour name
			
			final Colour col = ColourPalette.valueOf(webColour).opaque();
			this.red = col.red;
			this.green = col.green;
			this.blue = col.blue;
		}
	}
	
	/**
	 * Create a web colour code (#RRGGBB) from the three separate RGB components.
	 * @return A web colour code
	 */
	public String toRGBString() {
		// This code could become more elegant by using String.format 
		// Unfortunately, GWT does not support it.
		final StringBuilder sb = new StringBuilder("#");
		sb.append(red < 16? "0":"").append(Integer.toHexString(red));
		sb.append(green < 16? "0":"").append(Integer.toHexString(green));
		sb.append(blue < 16? "0":"").append(Integer.toHexString(blue));
		return sb.toString();
	}
	
	/**
	 * Create RGBA quadruple from the four separate RGBA components.
	 * @return A RGBA quadruple
	 */
	@Override
	public String toString() {
		return new StringBuilder("rgba(").append(red).append(",").append(green).append(",").append(blue).append(",").append(alpha).append(")").toString();
	}
}
