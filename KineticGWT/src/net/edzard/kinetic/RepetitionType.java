package net.edzard.kinetic;

/**
 * Defines the repetition of images when used as fill patterns.
 * @author Ed
 */
public enum RepetitionType {
	
	/** The image will not be repeated */
	NO_REPEAT,
	/** The image will be repeated both in horizontal, as well as vertical direction */
	REPEAT,
	/** The image will be repeated in horizontal direction */
	REPEAT_X,
	/** The image will be repeated in vertical direction */
	REPEAT_Y;

	/**
	 * Create a kineticjs-compatible string
	 * @return a string for use with kineticjs
	 */
	@Override
	public String toString() {
		switch(this) {
		case NO_REPEAT: return "no-repeat";
		case REPEAT: return "repeat";
		case REPEAT_X: return "repeat-x";
		case REPEAT_Y: return "repeat-y";
		default: return null;
		}
	}
	
	/**
	 * Create a repetition type enumeration literal from a kineticjs string.
	 * @param str A kineticjs string describing the repetition type
	 * @return An enumeration literal
	 */
	public static RepetitionType fromValue(final String str) {
		String s = str.replace("-", "_");
		s = s.toUpperCase();
		return valueOf(s);
	}
	
}
