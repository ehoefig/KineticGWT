package net.edzard.kinetic;

import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Image;

/**
 * A fill style using an image as a pattern.
 * @author Ed
 */
public class PatternFillStyle implements FillStyle {
	
	/** The image to use */
	private Image image;
	
	/** How to repeat the image */ 
	private RepetitionType repetition;
	
	/** Offset of the image in relation to the encapsulating shape */
	private Vector2d offset;
	
	/**
	 * Parametrized Ctor for pattern fills.
	 * Beware: underlying library does not allow the use of inlining of image data. Always use pictures constructed from straight URLs!
	 * @param image The image to use as a pattern. 
	 */
	public PatternFillStyle(Image image) {
		super();
		this.image = image;
		this.repetition = RepetitionType.NO_REPEAT;
		this.offset = new Vector2d(0, 0);
	}
	
	/**
	 * Parametrized Ctor for pattern fills.
	 * Beware: underlying library does not allow the use of inlining of image data. Always use pictures constructed from straight URLs!
	 * @param image The image to use as a pattern. 
	 * @param repetition Defines how the image should be repeated
	 */
	public PatternFillStyle(Image image, RepetitionType repetition) {
		super();
		this.image = image;
		this.repetition = repetition;
		this.offset = new Vector2d(0, 0);
	}
	
	/**
	 * Parametrized Ctor for pattern fills.
	 * Beware: underlying library does not allow the use of inlining of image data. Always use pictures constructed from straight URLs!
	 * @param image The image to use as a pattern. 
	 * @param repetition Defines how the image should be repeated
	 * @param offset Offset of the image in relation to encapsulating shape
	 */
	public PatternFillStyle(Image image, RepetitionType repetition, Vector2d offset) {
		super();
		this.image = image;
		this.repetition = repetition;
		this.offset = offset;
	}
	
	/**
	 * Parametrized Ctor for pattern fills.
	 * @param res The image resource to use as a pattern. 
	 */
	public PatternFillStyle(ImageResource res) {
		this(new Image(res.getSafeUri()));
	}
	
	/**
	 * Parametrized Ctor for pattern fills.
	 * @param res The image resource to use as a pattern. 
	 * @param repetition Defines how the image should be repeated
	 */
	public PatternFillStyle(ImageResource res, RepetitionType repetition) {
		this(new Image(res.getSafeUri()), repetition);
	}
	
	/**
	 * Parametrized Ctor for pattern fills.
	 * @param src The image resource to use as a pattern. 
	 * @param repetition Defines how the image should be repeated
	 * @param offset Offset of the image in relation to encapsulating shape
	 */
	public PatternFillStyle(ImageResource res, RepetitionType repetition, Vector2d offset) {
		this(new Image(res.getSafeUri()), repetition, offset);
	}

	/**
	 * Retrieve the employed image.
	 * @return The image
	 */
	public Image getImage() {
		return image;
	}

	/**
	 * Assign an image.
	 * @param image The image to use
	 */
	public void setImage(Image image) {
		this.image = image;
	}
	
	/**
	 * Assign an image resource.
	 * @param res The image resource to use
	 */
	public void setImage(ImageResource res) {
		this.image = new Image(res.getSafeUri());
	}

	/** 
	 * Retrieve the repetition type.
	 * The repetition type controls how an image is repeated.
	 * @return The repetition type
	 */
	public RepetitionType getRepetition() {
		return repetition;
	}

	/**
	 * Assign a repetition type.
	 * The repetition type controls how an image is repeated.
	 * @param repetition A repetition type
	 */
	public void setRepetition(RepetitionType repetition) {
		this.repetition = repetition;
	}

	/**
	 * Retrieve the image offset.
	 * @return The image offset relative to encapsulating shape coordinates
	 */
	public Vector2d getOffset() {
		return offset;
	}

	/**
	 * Assign an image offset.
	 * @param offset An image offset relative to encapsulating shape coordinates
	 */
	public void setOffset(Vector2d offset) {
		this.offset = offset;
	}
}
