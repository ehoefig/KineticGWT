package net.edzard.kinetic;

/**
 * A text shape.
 * Used for writing text. Text formatting options are limited.
 * There does not seem to be a wrap-around option for text boxes.
 * @author Ed
 */
// TODO: Use same strategy for doing all of the enumeration literal conversions...
// TODO: test the alignment values (are they properly converted to lowercase / uppercase?
public class Text extends Shape {

	/**
	 * Font style for a text.
	 * @author Ed
	 */
	public enum FontStyle {
		
		/** Normal styling - not bold and not italic */
		NORMAL,
		/** Bold font */
		BOLD,
		/** Italic Font */
		ITALIC;
		
		/**
		 * Retrieve a kineticjs compatible string of the enumeration literal.
		 * @return The literal string
		 */
		public String toString() {
			return super.toString().toLowerCase();
		}
	}
	
	/**
	 * Horizontal alignment options for text.
	 * @author Ed
	 */
	public enum HorizontalAlignment {
		/** Align text on the left side */
		LEFT,
		/** Align text in the center */
		CENTER,
		/** Align text on the right side */
		RIGHT
	}
	
	/**
	 * Vertical alignment options for text. 
	 * @author Ed
	 */
	public enum VerticalAlignment {
		/** Align text on the top side */
		TOP,
		/** Align text in the middle */
		MIDDLE,
		/** Align text on the bottom side */
		BOTTOM
	}
	
	/** Protected default Ctor keeps GWT happy */
	protected Text() {}
	
	/**
	 * Retrieve the text string to display by this shape.
	 * @return The text string
	 */
	public final native String getText() /*-{
		return this.getText();
	}-*/;

	/**
	 * Assign a text string to display by this shape.
	 * @param text A text string
	 */
	public final native void setText(String text) /*-{
		this.setText(text);
	}-*/;
	
	/**
	 * Retrieve the font size used by this text shape.
	 * @return The font size
	 */
	public final native int getFontSize() /*-{
		return this.getFontSize();
	}-*/;
	
	/**
	 * Assign the font size used by this text shape.
	 * @param size A font size
	 */
	public final native void setFontSize(int size) /*-{
		this.setFontSize(size);
	}-*/;
	
	/**
	 * Retrieve the font family used by this text shape.
	 * @return The font family (e.g. Arial)
	 */
	public final native String getFontFamily() /*-{
		return this.getFontFamily();
	}-*/;
	
	/**
	 * Assign the font family used by this text shape.
	 * @param font The font family (e.g. Arial)
	 */
	public final native void setFontFamily(String font) /*-{
		this.setFontFamily(font);
	}-*/;
	
	/**
	 * Retrieve the current font style used by this text shape.
	 * @return The font style
	 */
	public final native FontStyle getFontStyle() /*-{
		if (this.getFontStyle() != null) return @net.edzard.kinetic.Text.FontStyle::valueOf(Ljava/lang/String;)(this.getFontStyle().toUpperCase());
		else return null;
	}-*/;
	
	/**
	 * Assign a font style to this text shape.
	 * @param style A font style
	 */
	public final native void setFontStyle(FontStyle style) /*-{
		this.setFontStyle(style.@net.edzard.kinetic.Text.FontStyle::toString()());
	}-*/;
	
	/**
	 * Retrieve the current text fill colour used by this text shape.
	 * The text fill colour controls the colour of the letters.
	 * @return The text fill colour
	 */
	public final native Colour getTextFill() /*-{
		return @net.edzard.kinetic.Colour::new(Ljava/lang/String;)(this.getTextFill());
	}-*/;

	/**
	 * Assign a text fill colour to this text shape.
	 * The text fill colour controls the colour of the letters.
	 * @param fill The text fill colour to set
	 */
	public final native void setTextFill(Colour fill) /*-{
		this.setTextFill(fill.toString());
	}-*/;
	
	/**
	 * Retrieve the current stroke colour used by the text shape.
	 * The text stroke defines the coulor of the outline of the text.
	 * @return The text stroke colour
	 */
	public final native Colour getTextStroke() /*-{
		return @net.edzard.kinetic.Colour::new(Ljava/lang/String;)(this.getTextStroke());
	}-*/;
	
	/**
	 * Assign a text stroke colour to this text shape.
	 * The text stroke defines the coulor of the outline of the text.
	 * @param stroke A text stroke colour
	 */
	public final native void setTextStroke(Colour stroke) /*-{
		this.setTextStroke(stroke.toString());
	}-*/;
	
	/**
	 * Retrieve the text stroke width used by this text shape.
	 * The text stroke width defines the width of the text's outline.
	 * @return The stroke width
	 */
	public final native double getTextStrokeWidth() /*-{
		if (this.getTextStrokeWidth() == null) return 0;
		else return this.getTextStrokeWidth();
	}-*/;
	
	/**
	 * Assigns a text stroke width for this text shape.
	 * The text stroke width defines the width of the text's outline.
	 * @param width A text stroke width
	 */
	public final native void setTextStrokeWidth(double width) /*-{
		this.setTextStrokeWidth(width);
	}-*/;
	
	/**
	 * Retrieve the horizontal alignment for this text shape.
	 * @return The horizontal alignment
	 */
	public final native HorizontalAlignment getHorizontalAlignment() /*-{
		if (this.getAlign() != null) return @net.edzard.kinetic.Text.HorizontalAlignment::valueOf(Ljava/lang/String;)(this.getAlign().toUpperCase());
		else return null;
	}-*/;
	
	/**
	 * Assign a horizontal alignment to the text shape.
	 * @param align A horizontal alignment
	 */
	public final native void setHorizontalAlignment(HorizontalAlignment align) /*-{
		this.setAlign(align.@net.edzard.kinetic.Text.HorizontalAlignment::toString()().toLowerCase());
	}-*/;
	
	/**
	 * Retrieve the padding size for this text shape.
	 * @return The padding size
	 */
	public final native double getPadding() /*-{
		return this.getPadding();
	}-*/;
	
	/**
	 * Assign a padding size to this text shape.
	 * @param padding A padding size
	 */
	public final native void setPadding(double padding) /*-{
		this.setPadding(amount);
	}-*/;
	
	/**
	 * Retrieve the width of this text shape.
	 * @return The width
	 */
	public final native double getWidth() /*-{
		if (this.getWidth() == "auto") return 0;
		else return this.getWidth();
	}-*/;
	
	/**
	 * Set the width of this text shape.
	 * @param width The width
	 */
	public final native void setWidth(double width) /*-{
		this.setWidth(width);
	}-*/;
	
	/**
	 * Retrieve Vertical extents of the text.
	 * @return The text height in pixels
	 */
	public final native int getTextHeight() /*-{
		return this.getTextHeight();
	}-*/;
	
	/**
	 * Retrieve the horizontal extents of the text.
	 * @return The text width in pixels
	 */
	public final native int getTextWidth() /*-{
		return this.getTextWidth();
	}-*/;
	
	/**
	 * Retrieve height of the logical box around the text.
	 * @return The box height
	 */
	public final native double getBoxHeight() /*-{
		return this.getBoxHeight();
	}-*/;
	
	/**
	 * Retrieve width of the logical box around the text.
	 * @return The box width
	 */
	public final native int getBoxWidth() /*-{
		return this.getBoxWidth();
	}-*/;
	
	/**
	 * Animate a linear transition of this text shape.
	 * @param target Another text shape - defines the characteristics that the current text shape will have at the end of the animation
	 * @param duration The time it will take for the animation to complete, in seconds
	 * @return An object for controlling the transition.
	 */
	public final Transition transitionTo(Text target, double duration) {
		return transitionTo(target, duration, null, null);
	}
	
	/**
	 * Animate a transition of this text shape.
	 * @param target Another text shape - defines the characteristics that the current text shape will have at the end of the animation
	 * @param duration The time it will take for the animation to complete, in seconds
	 * @param ease An easing function that defines how the transition will take place
	 * @param callback A function that will be called at the end of the animation
	 * @return An object for controlling the transition.
	 */
	public final Transition transitionTo(Text target, double duration, EasingFunction ease, Runnable callback) {
		StringBuffer sb = new StringBuffer();
		if (this.getFontSize() != target.getFontSize()) sb.append("fontSize:").append(target.getFontSize()).append(",");
		if (this.getTextStrokeWidth() != target.getTextStrokeWidth()) sb.append("textStrokeWidth:").append(target.getTextStrokeWidth()).append(",");
		if (this.getPadding() != target.getPadding()) sb.append("padding:").append(target.getPadding()).append(",");
		if (this.getWidth() != target.getWidth()) sb.append("width:").append(target.getWidth()).append(",");
		return transitionToShape(target, sb, duration, ease, callback);
	}
}
