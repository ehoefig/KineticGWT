package net.edzard.kinetic;

/**
 * A RGBA colour value.
 * Used for defining all sorts of colours using red, green, blue and alpha (opacity) components.
 * @author Ed
 */
public class Colour implements FillStyle {
	
	public static final Colour aliceblue 		= new Colour(240,248,255);
	public static final Colour antiquewhite		= new Colour(250,235,215);
	public static final Colour aqua    			= new Colour(  0,255,255);
	public static final Colour aquamarine		= new Colour(127,255,212);
	public static final Colour azure   			= new Colour(240,255,255);
	public static final Colour beige   			= new Colour(245,245,220);
	public static final Colour bisque  			= new Colour(255,228,196);
	public static final Colour black   			= new Colour(  0,  0,  0);
	public static final Colour blanchedalmond	= new Colour(255,235,205);
	public static final Colour blue    			= new Colour(  0,  0,255);
	public static final Colour blueviolet		= new Colour(138, 43,226);
	public static final Colour brown   			= new Colour(165, 42, 42);
	public static final Colour burlywood 		= new Colour(222,184,135);
	public static final Colour cadetblue 		= new Colour( 95,158,160);
	public static final Colour chartreuse		= new Colour(127,255,  0);
	public static final Colour chocolate 		= new Colour(210,105, 30);
	public static final Colour coral   			= new Colour(255,127, 80);
	public static final Colour cornflowerblue	= new Colour(100,149,237);
	public static final Colour cornsilk			= new Colour(255,248,220);
	public static final Colour crimson 			= new Colour(220, 20, 60);
	public static final Colour darkblue			= new Colour(  0,  0,139);
	public static final Colour darkcyan			= new Colour(  0,139,139);
	public static final Colour darkgoldenrod	= new Colour(184,134, 11);
	public static final Colour darkgray			= new Colour(169,169,169);
	public static final Colour darkgreen 		= new Colour(  0,100,  0);
	public static final Colour darkkhaki 		= new Colour(189,183,107);
	public static final Colour darkmagenta 		= new Colour(139,  0,139);
	public static final Colour darkolivegreen	= new Colour( 85,107, 47);
	public static final Colour darkorange		= new Colour(255,140,  0);
	public static final Colour darkorchid		= new Colour(153, 50,204);
	public static final Colour darkred 			= new Colour(139,  0,  0);
	public static final Colour darksalmon		= new Colour(233,150,122);
	public static final Colour darkseagreen		= new Colour(143,188,143);
	public static final Colour darkslateblue	= new Colour( 72, 61,139);
	public static final Colour darkslategray	= new Colour( 47, 79, 79);
	public static final Colour darkturquoise	= new Colour(  0,206,209);
	public static final Colour darkviolet		= new Colour(148,  0,211);
	public static final Colour deeppink			= new Colour(255, 20,147);
	public static final Colour deepskyblue 		= new Colour(  0,191,255);
	public static final Colour dimgray 			= new Colour(105,105,105);
	public static final Colour dodgerblue		= new Colour( 30,144,255);
	public static final Colour firebrick 		= new Colour(178, 34, 34);
	public static final Colour floralwhite 		= new Colour(255,250,240);
	public static final Colour forestgreen 		= new Colour( 34,139, 34);
	public static final Colour fuchsia 			= new Colour(255,  0,255);
	public static final Colour gainsboro 		= new Colour(220,220,220);
	public static final Colour ghostwhite		= new Colour(248,248,255);
	public static final Colour gold    			= new Colour(255,215,  0);
	public static final Colour goldenrod 		= new Colour(218,165, 32);
	public static final Colour gray    			= new Colour(128,128,128);
	public static final Colour green   			= new Colour(  0,128,  0);
	public static final Colour greenyellow 		= new Colour(173,255, 47);
	public static final Colour honeydew			= new Colour(240,255,240);
	public static final Colour hotpink 			= new Colour(255,105,180);
	public static final Colour indianred 		= new Colour(205, 92, 92);
	public static final Colour indigo  			= new Colour( 75,  0,130);
	public static final Colour ivory   			= new Colour(255,255,240);
	public static final Colour khaki   			= new Colour(240,230,140);
	public static final Colour lavender			= new Colour(230,230,250);
	public static final Colour lavenderblush	= new Colour(255,240,245);
	public static final Colour lawngreen 		= new Colour(124,252,  0);
	public static final Colour lemonchiffon		= new Colour(255,250,205);
	public static final Colour lightblue 		= new Colour(173,216,230);
	public static final Colour lightcoral		= new Colour(240,128,128);
	public static final Colour lightcyan 		= new Colour(224,255,255);
	public static final Colour lightgoldenrodyellow= new Colour(250,250,210);
	public static final Colour lightgreen		= new Colour(144,238,144);
	public static final Colour lightgrey		= new Colour(211,211,211);
	public static final Colour lightpink 		= new Colour(255,182,193);
	public static final Colour lightsalmon	 	= new Colour(255,160,122);
	public static final Colour lightseagreen	= new Colour( 32,178,170);
	public static final Colour lightskyblue		= new Colour(135,206,250);
	public static final Colour lightslategray	= new Colour(119,136,153);
	public static final Colour lightsteelblue	= new Colour(176,196,222);
	public static final Colour lightyellow 		= new Colour(255,255,224);
	public static final Colour lime    			= new Colour(  0,255,  0);
	public static final Colour limegreen 		= new Colour( 50,205, 50);
	public static final Colour linen   			= new Colour(250,240,230);
	public static final Colour maroon  			= new Colour(128,  0,  0);
	public static final Colour mediumaquamarine	= new Colour(102,205,170);
	public static final Colour mediumblue		= new Colour(  0,  0,205);
	public static final Colour mediumorchid		= new Colour(186, 85,211);
	public static final Colour mediumpurple		= new Colour(147,112,219);
	public static final Colour mediumseagreen	= new Colour( 60,179,113);
	public static final Colour mediumslateblue	= new Colour(123,104,238);
	public static final Colour mediumspringgreen= new Colour(  0,250,154);
	public static final Colour mediumturquoise	= new Colour( 72,209,204);
	public static final Colour mediumvioletred	= new Colour(199, 21,133);
	public static final Colour midnightblue		= new Colour( 25, 25,112);
	public static final Colour mintcream 		= new Colour(245,255,250);
	public static final Colour mistyrose 		= new Colour(255,228,225);
	public static final Colour moccasin			= new Colour(255,228,181);
	public static final Colour navajowhite 		= new Colour(255,222,173);
	public static final Colour navy    			= new Colour(  0,  0,128);
	public static final Colour oldlace 			= new Colour(253,245,230);
	public static final Colour olive   			= new Colour(128,128,  0);
	public static final Colour olivedrab 		= new Colour(107,142, 35);
	public static final Colour orange  			= new Colour(255,165,  0);
	public static final Colour orangered 		= new Colour(255, 69,  0);
	public static final Colour orchid  			= new Colour(218,112,214);
	public static final Colour palegoldenrod	= new Colour(238,232,170);
	public static final Colour palegreen 		= new Colour(152,251,152);
	public static final Colour paleturquoise	= new Colour(175,238,238);
	public static final Colour palevioletred	= new Colour(219,112,147);
	public static final Colour papayawhip		= new Colour(255,239,213);
	public static final Colour peachpuff 		= new Colour(255,218,185);
	public static final Colour peru    			= new Colour(205,133, 63);
	public static final Colour pink    			= new Colour(255,192,203);
	public static final Colour plum    			= new Colour(221,160,221);
	public static final Colour powderblue		= new Colour(176,224,230);
	public static final Colour purple  			= new Colour(128,  0,128);
	public static final Colour red     			= new Colour(255,  0,  0);
	public static final Colour rosybrown 		= new Colour(188,143,143);
	public static final Colour royalblue 		= new Colour( 65,105,225);
	public static final Colour saddlebrown 		= new Colour(139, 69, 19);
	public static final Colour salmon  			= new Colour(250,128,114);
	public static final Colour sandybrown		= new Colour(244,164, 96);
	public static final Colour seagreen			= new Colour( 46,139, 87);
	public static final Colour seashell			= new Colour(255,245,238);
	public static final Colour sienna  			= new Colour(160, 82, 45);
	public static final Colour silver  			= new Colour(192,192,192);
	public static final Colour skyblue 			= new Colour(135,206,235);
	public static final Colour slateblue 		= new Colour(106, 90,205);
	public static final Colour slategray 		= new Colour(112,128,144);
	public static final Colour snow    			= new Colour(255,250,250);
	public static final Colour springgreen	 	= new Colour(  0,255,127);
	public static final Colour steelblue 		= new Colour( 70,130,180);
	public static final Colour tan     			= new Colour(210,180,140);
	public static final Colour teal    			= new Colour(  0,128,128);
	public static final Colour thistle 			= new Colour(216,191,216);
	public static final Colour tomato  			= new Colour(255, 99, 71);
	public static final Colour turquoise 		= new Colour( 64,224,208);
	public static final Colour violet  			= new Colour(238,130,238);
	public static final Colour wheat   			= new Colour(245,222,179);
	public static final Colour white   			= new Colour(255,255,255);
	public static final Colour whitesmoke		= new Colour(245,245,245);
	public static final Colour yellow  			= new Colour(255,255,  0);
	public static final Colour yellowgreen	 	= new Colour(154,205, 50);
		
	public static final Colour fubGreen			= new Colour(169,208, 39);
	public static final Colour fubBlue			= new Colour(  0, 51,102);
	public static final Colour fubLightBlue		= new Colour(161,155,255);
	public static final Colour quicksilver		= new Colour(230,230,230);
	
	/** The separate red component */
	private int redComponent;
	
	/** The separate green component */
	private int greenComponent;
	
	/** The separate blue component */
	private int blueComponent;
	
	/** The separate alpha component */
	private int alphaComponent;
	
	/**
	 * Retrieve the red component.
	 * @return The red value
	 */
	public int getRed() {
		return redComponent;
	}

	/**
	 * Set the red component.
	 * @param red The new value
	 */
	public void setRed(int red) {
		if (red > 255) this.redComponent = 255; else if (red < 0) this.redComponent = 0; else this.redComponent =red;
	}

	/**
	 * Retrieve the green component.
	 * @return The green value
	 */
	public int getGreen() {
		return greenComponent;
	}

	/**
	 * Set the green component.
	 * @param green The new value
	 */
	public void setGreen(int green) {
		if (green > 255) this.greenComponent = 255; else if (green < 0) this.greenComponent = 0; else this.greenComponent = green;
	}

	/**
	 * Retrieve the blue component.
	 * @return The blue value
	 */
	public int getBlue() {
		return blueComponent;
	}

	/**
	 * Set the blue component.
	 * @param blue The new value
	 */
	public void setBlue(int blue) {
		if (blue > 255) this.blueComponent = 255; else if (blue < 0) this.blueComponent = 0; else this.blueComponent = blue;	
	}

	/**
	 * Retrieve the alpha component.
	 * @return The alpha value
	 */
	public int getAlpha() {
		return alphaComponent;
	}

	/**
	 * Set the alpha component.
	 * @param alpha The new value
	 */
	public void setAlpha(int alpha) {
		this.alphaComponent = alpha;
	}
	
	/**
	 * Retrieve a colour with an alpha value.
	 * @param alpha Defines the transparency (0 is transparent and 255 is opaque)
	 * @return a translucent colour
	 */
	public Colour alpha(int alpha) {
		return new Colour(this.redComponent, this.greenComponent, this.blueComponent, alpha);
	}
	
	/** 
	 * Parametrized Ctor.
	 * Alpha is set to 255;
	 * @param red Red component (0..255)
	 * @param green Green component (0..255)
	 * @param blue Blue component (0..255)
	 */
	public Colour(int red, int green, int blue) {
		this.redComponent = red;
		this.greenComponent = green;
		this.blueComponent = blue;
		this.alphaComponent = 255;
		if (red > 255) this.redComponent = 255; else if (red < 0) this.redComponent = 0;
		if (green > 255) this.greenComponent = 255; else if (green < 0) this.greenComponent = 0;
		if (blue > 255) this.blueComponent = 255; else if (blue < 0) this.blueComponent = 0;		
	}

	/** 
	 * Parametrized Ctor with separate components.
	 * @param red Red component (0..255)
	 * @param green Green component (0..255)
	 * @param blue Blue component (0..255)
	 * @param alpha Alpha component (0..255)
	 */
	public Colour(int red, int green, int blue, int alpha) {
		this.redComponent = red;
		this.greenComponent = green;
		this.blueComponent = blue;
		this.alphaComponent = alpha;
		if (red > 255) this.redComponent = 255; else if (red < 0) this.redComponent = 0;
		if (green > 255) this.greenComponent = 255; else if (green < 0) this.greenComponent = 0;
		if (blue > 255) this.blueComponent = 255; else if (blue < 0) this.blueComponent = 0;	
		if (alpha > 255) this.alphaComponent = 255; else if (alpha < 0) this.alphaComponent = 0;	
	}

	/**
	 * Parametrized Ctor from a single webcolour string.
	 * @param webColour A colour string (e.g., '#FF0000')
	 */
	public Colour(final String webColour) {
		
		if (webColour.startsWith("#")) {
		
			// This is a web colour a la #RRGGBB
			
			redComponent = Integer.parseInt(webColour.substring(1, 3), 16);
			if (redComponent > 255) redComponent = 255; else if (redComponent < 0) redComponent = 0;
			
			greenComponent = Integer.parseInt(webColour.substring(3, 5), 16);
			if (greenComponent > 255) greenComponent = 255; else if (greenComponent < 0) greenComponent = 0;
			
			blueComponent = Integer.parseInt(webColour.substring(5, 7), 16);
			if (blueComponent > 255) blueComponent = 255; else if (blueComponent < 0) blueComponent = 0;
			
			alphaComponent = 255;
			
		} else if (webColour.startsWith("rgba")) {
			
			// This is a RGBA quadruple
			int pos = webColour.indexOf(",", 0);
			redComponent = Integer.parseInt(webColour.substring(5, pos));
			if (redComponent > 255) redComponent = 255; else if (redComponent < 0) redComponent = 0;
			int oldPos = pos;
			
			pos = webColour.indexOf(",", pos+1);
			greenComponent = Integer.parseInt(webColour.substring(oldPos+1, pos));
			if (greenComponent > 255) greenComponent = 255; else if (greenComponent < 0) greenComponent = 0;
			oldPos = pos;
			
			pos = webColour.indexOf(",", pos+1);
			blueComponent = Integer.parseInt(webColour.substring(oldPos+1, pos));
			if (blueComponent > 255) blueComponent = 255; else if (blueComponent < 0) blueComponent = 0;
			oldPos = pos;
			
			pos = webColour.indexOf(")", pos+1);
			alphaComponent = Integer.parseInt(webColour.substring(oldPos+1, pos));
			if (alphaComponent > 255) alphaComponent = 255; else if (alphaComponent < 0) alphaComponent = 0;
			oldPos = pos;
		} // else {
//			
//			// This is a colour name
//			
//			final Colour col = ColourPalette.valueOf(webColour).opaque();
//			this.redComponent = col.redComponent;
//			this.greenComponent = col.greenComponent;
//			this.blueComponent = col.blueComponent;
//		}
	}	
	
	/**
	 * Create a web colour code (#RRGGBB) from the three separate RGB components.
	 * @return A web colour code
	 */
	public String toRGBString() {
		// This code could become more elegant by using String.format 
		// Unfortunately, GWT does not support it.
		final StringBuilder sb = new StringBuilder("#");
		sb.append(redComponent < 16? "0":"").append(Integer.toHexString(redComponent));
		sb.append(greenComponent < 16? "0":"").append(Integer.toHexString(greenComponent));
		sb.append(blueComponent < 16? "0":"").append(Integer.toHexString(blueComponent));
		return sb.toString();
	}
	
	/**
	 * Create RGBA quadruple from the four separate RGBA components.
	 * @return A RGBA quadruple
	 */
	@Override
	public String toString() {
		return new StringBuilder("rgba(").append(redComponent).append(",").append(greenComponent).append(",").append(blueComponent).append(",").append(alphaComponent).append(")").toString();
	}
}
