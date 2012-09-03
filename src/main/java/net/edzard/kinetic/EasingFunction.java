package net.edzard.kinetic;

/**
 * Defines the way that transitions take place.
 * The default transition behaviour is linear, but there are many other functions to choose from.
 * @author Ed
 */
public enum EasingFunction {
	
	LINEAR, 
	EASE_IN, 
	EASE_OUT, 
	EASE_IN_OUT, 
	BACK_EASE_IN, 
	BACK_EASE_OUT, 
	BACK_EASE_IN_OUT, 
	ELASTIC_EASE_IN,
	ELASTIC_EASE_OUT,
	ELASTIC_EASE_IN_OUT,
	BOUNCE_EASE_IN,
	BOUNCE_EASE_OUT,
	BOUNCE_EASE_IN_OUT,
	STRONG_EASE_IN,
	STRONG_EASE_OUT,
	STRONG_EASE_IN_OUT;

	/**
	 * Retrieve a string from the enumeration literal.
	 * The string literal is in the format expected by kineticjs
	 */
	@Override
	public String toString() {
		return super.toString().replace("_", "-").toLowerCase();
	}
	
	/**
	 * Retrieve an enumeration literal for a string.
	 * @param str The string (as used by kineticjs)
	 * @return An easing function
	 */
	public static EasingFunction fromValue(final String str) {
		String s = str.replace("-", "_");
		s = s.toUpperCase();
		return valueOf(s);
	}
}
