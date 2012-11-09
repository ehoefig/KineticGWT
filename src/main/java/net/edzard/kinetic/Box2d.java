package net.edzard.kinetic;

/**
 * A data quadruple.
 * Used for, e.g. rectangles or bounding boxes.
 * @author Ed
 */
public class Box2d {

	/** The left side value */
	public double left;
	
	/** The top side value */
	public double top;
	
	/** The right side value */
	public double right;
	
	/** The bottom side value */
	public double bottom;
	
	/**
	 * Standard Ctor.
	 * Initializes all fields with {@link Double#NaN}.
	 */
	public Box2d() {
		this.left = this.top = this.right = this.bottom = Double.NaN;
	}
	
	/**
	 * Parametrized Ctor.
	 * @param left Value for the left side
	 * @param top Value for the top side
	 * @param right Value for the right side
	 * @param bottom Value for the bottom side
	 */
	public Box2d(double left, double top, double right, double bottom) {
		this.left = left;
		this.top = top;
		this.right = right;
		this.bottom = bottom;
	}
	
	/**
	 * Creates a box given by its position and size.
	 * @param position
	 * @param size Size as width and height. 
	 */
	public Box2d(Vector2d position, Vector2d size) {
		this.left = position.x;
		this.top = position.y;
		this.right = left + size.x;
		this.bottom = top + size.y;
	}
	
	public final double getWidth() {
		return this.right - this.left;
	}
	
	public final double getHeight() {
		return this.bottom - this.top;
	}

	/**
	 * Check if a point is within the bounds of the box.
	 * Takes unset boundaries (fields assigned with {@link Double#NaN}) into account. 
	 * @param point The point to evaluate
	 * @return True, if the given point is within or on the boundaries of the box. False, otherwise.
	 */
	public final boolean isInside(Vector2d point) {
		if (((left != Double.NaN) && (left <= point.x)) &&
			((top != Double.NaN) && (top <= point.y)) &&
			((right != Double.NaN) && (right >= point.x)) &&
			((bottom != Double.NaN) && (bottom >= point.y))) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Corrects the box by some offset value.
	 * @param offset The offset value to use for correction
	 */
	public final void correctOffset(Vector2d offset) {
		this.left -= offset.x;
		this.top -= offset.y;
		this.right -= offset.x;
		this.bottom -= offset.y;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("[(");
		sb.append(left).append(",").append(top).append(")").append(" x (").append(right).append(",").append(bottom).append(")]");
		return sb.toString();
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Box2d other = (Box2d) obj;
		if (bottom != other.bottom)
			return false;
		if (left != other.left)
			return false;
		if (right != other.right)
			return false;
		if (top != other.top)
			return false;
		return true;
	}
}
