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
	
	/**
	 * Identifies mouse buttons
	 * @author Ed
	 */
	public enum Button {
		LEFT,
		MIDDLE,
		RIGHT;
		public static Button fromInteger(int i) {
			switch (i) {
			case 1: return MIDDLE;
			case 2: return RIGHT;
			default: return LEFT;
			}
		}
	}
	
	/** Holds the current event's type */
	private Type type;
	
	/** Identifies the mouse button (if any) */
	private Button button;
	
	/** Holds the shape that the current event emanated from */
	private Shape shape;
	
	/** Horizontal position of mouse */
	public final int x;

	/** Vertical position of mouse */
	public final int y;
	

	/**
	 * Parmetrized Ctor.
	 * @param type An event type
	 */
	public Event(Type type, Button button, int x, int y) {
		this.type = type;
		this.button = button;
		this.x = x;
		this.y = y;
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
	 * Get a mouse button that was pressed.
	 * Returned value is only valid for mouse events.
	 * @return A button identifier
	 */
	public Button getButton() {
		return button;
	}

	/**
	 * Set the shape that this event emanates from.
	 * @param shape The shape
	 */
	public void setShape(Shape shape) {
		this.shape = shape;
	}
	
	/**
	 * Retrieve the event's position.
	 * This is a convenience method for accessing the position as a vector object.
	 * @return The position of the pointing device at event creation time 
	 */
	public Vector2d getPosition() {
		return new Vector2d(x,y);
	}
}
