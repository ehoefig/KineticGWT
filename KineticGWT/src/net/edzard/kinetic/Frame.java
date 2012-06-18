package net.edzard.kinetic;

/**
 * Encapsulates timing information.
 * Used for custom drawing functions. Necessary for properly timed animations.
 * @author Ed
 */
public class Frame {
	
	/** The last frame's timestamp (ms) */
	private double lastTime;
	
	/** The current frame's timestamp (ms) */
	private double time;
	
	/** Difference between last frame's and this frame's timestamp (ms) */
	private double timeDiff;

	/**
	 * Parametrized Ctor.
	 * @param lastTime Timestamp of last frame (milliseconds)
	 * @param time Timestamp of current frame (milliseconds)
	 * @param timeDiff Difference between time stamps (milliseconds)
	 */
	public Frame(double lastTime, double time, double timeDiff) {
		super();
		this.lastTime = lastTime;
		this.time = time;
		this.timeDiff = timeDiff;
	}

	/**
	 * Get last frame's timestamp.
	 * @return The previous timestamp in milliseconds
	 */
	public double getLastTime() {
		return lastTime;
	}

	/**
	 * Get current frame's timestamp.
	 * @return The current time in milliseconds
	 */
	public double getTime() {
		return time;
	}

	/**
	 * Get difference between last and current frame's timestamps.
	 * @return The difference in milliseconds
	 */
	public double getTimeDiff() {
		return timeDiff;
	}
}