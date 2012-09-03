package net.edzard.kinetic;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

/**
 * Stores a two-dimensional value.
 * Used for positions and sizes (horizontal and vertical extents).
 * @author Ed
 */
public class Vector2d {

	/** Unit vector in direction of x axis */
	public static final Vector2d xUnit = new Vector2d(1,0);
	
	/** Unit vector in direction of y axis */
	public static final Vector2d yUnit = new Vector2d(0,1);
	
	/** Origin vector (0,0) */
	public static final Vector2d origin = new Vector2d(0,0);
	
	
	/** The horizontal component */
	public double x;
	/** The vertical component */
	public double y;
	
	/**
	 * Default Ctor.
	 * Both components are initialized with {@link Double#NaN}.
	 */
	public Vector2d() {
		this.x = this.y = Double.NaN;
	}
	
	/**
	 * Parametrized Ctor.
	 * Initializes vector with separate components
	 * @param x Initial x component value
	 * @param y Initial y component value
	 */
	public Vector2d(double x, double y) {
		set(x,y);
	}
	
	/**
	 * Parametrized Ctor.
	 * Initializes vector with another vector.
	 * @param other The other vector
	 */
	public Vector2d(final Vector2d other) {
		this.x = other.x;
		this.y = other.y;
	}
	
	/**
	 * Serialization Ctor.
	 * @param val A serialized vector. Either an array with two components or an object with x and y properties.
	 */
	public Vector2d(final JSONValue val) {
		JSONObject obj = val.isObject();
		if (obj != null) {
			// Is object
			this.x = obj.get("x").isNumber().doubleValue();
			this.y = obj.get("y").isNumber().doubleValue();
		} else {
			final JSONArray array = val.isArray();
			if (array != null) {
				// Is array
				this.x = array.get(0).isNumber().doubleValue();
				this.y = array.get(1).isNumber().doubleValue();
			} else {
				// Not object or array
				this.x = this.y = Double.NaN;
			}
		}
	}

	/**
	 * Serialize vector to JSON.
	 * @return A JSON object with x and y properties.
	 */
	public JSONValue toJson() {
		final JSONObject result = new JSONObject();
		result.put("x", new JSONNumber(this.x));
		result.put("y", new JSONNumber(this.y));
		return result;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("(");
		sb.append(x).append(",").append(y).append(")");
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
		Vector2d other = (Vector2d) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	/**
	 * Assigns new values to this vectors components.
	 * @param x A new x component
	 * @param y A new y component
	 */
	public final void set(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Assigns new values to this vectors components.
	 * @param newValue A vector that defines the new values
	 */
	public final void set(Vector2d newValue) {
		this.x = newValue.x;
		this.y = newValue.y;
	}

	/**
	 * Subtract a given vector from this one.
	 * @param other The other vector.
	 */
	public final void sub(Vector2d other) {
		 this.x -= other.x;
	     this.y -= other.y;
	}

	/**
	 * Add a given vector to this one.
	 * @param other The other vector.
	 */
	public final void add(Vector2d other) {
		 this.x += other.x;
	     this.y += other.y;
	}

	/**
	 * Add a given vector to this one.
	 * @param x x component of the other vector
	 * @param y y component of the other vector
	 */
	public final void add(double x, double y) {
		 this.x += x;
	     this.y += y;
	}
	
	/**
	 * Normalizes the length of vector to 1, while keeping the direction.
	 */
	public final void normalize() {
		double n = 1.0/Math.sqrt(this.x*this.x + this.y*this.y);
        this.x *= n;
        this.y *= n;
	}

	/**
	 * Scale the vector's length.
	 * This keeps the direction, but alters the vector's length.
	 * @param amount The amount to scale the vector.
	 */
	public final void scale(double amount) {
		this.x *= amount;
		this.y *= amount;
	}
	
	/**
	 * Get the angle between this vector and another one.
	 * @param other The second vector
	 * @return The angle between them
	 */
	public final double angle(final Vector2d other) {
		return Math.acos((x*other.x + y*other.y) /
		((Math.sqrt(x*x+y*y))*Math.sqrt(other.x*other.x+other.y*other.y)));
	}
	
	/**
	 * Calculate the distance between this point and a given one.
	 * @param other Another vector
	 * @return The distance between the two points
	 */
	public final double distanceTo(final Vector2d other) {
		return Math.sqrt((other.x-x)*(other.x-x) + (other.y-y)*(other.y-y));
	}
}
