package net.edzard.kinetic;

/**
 * Used to communicate input events.
 * @author Ed
 */
public class Event {

	/**
	 * The event's type.
	 * @author Ed
	 */
	public enum Type {
		MOUSEOVER,
		MOUSEOUT,
		MOUSEMOVE,
		MOUSEDOWN,
		MOUSEUP,
		CLICK,
		DBLCLICK,
		DRAGSTART,
		DRAGMOVE,
		DRAGEND,
		TOUCHSTART,
		TOUCHMOVE,
		TOUCHEND,
		TAP,
		DBLTAP
	}
	
	/** Holds the current event's type */
	private Type type;
	
	/** Holds the shape that the current event emanated from */
	private Shape shape;
	
	/**
	 * Parmetrized Ctor.
	 * @param type An event type
	 */
	public Event(Type type) {
		this.type = type;
	}

	/**
	 * Retrieve the event's type.
	 * @return The type
	 */
	public final Type getType() {
		return type;
	}

	/**
	 * Assign a new type to this event.
	 * @param type The new type
	 */
	public final void setType(Type type) {
		this.type = type;
	}

	/**
	 * Get the shape that this event emanated from.
	 * @return The shape
	 */
	public Shape getShape() {
		return shape;
	}

	/**
	 * Set the shape that this event emanates from.
	 * @param shape The shape
	 */
	public void setShape(Shape shape) {
		this.shape = shape;
	}
}
