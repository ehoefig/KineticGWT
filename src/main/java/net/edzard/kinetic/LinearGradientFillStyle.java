package net.edzard.kinetic;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * A linear gradient fill style.
 * The liner gradient is filled from a start to an end position.
 * Along this line, so-called "colour stops" can be set, which influence how the colour is changed along the gradient.
 * For example: Setting a colour stop with black at start position and a colour stop with white at the end position will lead
 * to a gradient which goes through all shades of grey. They can be more than two colour stops assigned to a gradient.
 * @author Ed

 */
public class LinearGradientFillStyle extends GradientFillStyle {

	/** The gradient's start position */
	private Vector2d start;
	
	/** The gradient's end position */
	private Vector2d  end;
	
	/** Holds definitions of the colour stops */
	private TreeMap<Double, Colour> colourStops;

	/**
	 * Parametrized Ctor.
	 * @param start The start position of the gradient.
	 * @param end The end position of the gradient.
	 */
	public LinearGradientFillStyle(Vector2d start, Vector2d end) {
		super();
		this.start = start;
		this.end = end;
		this.colourStops = new TreeMap<Double, Colour>();
	}
	
	/**
	 * Retrieve the gradient's start position.
	 * @return The start position
	 */
	public Vector2d getStart() {
		return start;
	}
	
	/**
	 * Assign the gradient's start position.
	 * @param start The start position
	 */
	public void setStart(Vector2d start) {
		this.start = start;
	}

	/**
	 * Retrieve the gradient's end position.
	 * @return The end position
	 */
	public Vector2d getEnd() {
		return end;
	}

	/**
	 * Assign the gradient's end position.
	 * @param start The end position
	 */
	public void setEnd(Vector2d end) {
		this.end = end;
	}
	
	/**
	 * Add an new colour stop.
	 * @param where A number between 0..1 that defines a value between start and end position.
	 * @param colour The colour that the gradient should have at this position.
	 */
	public void setColourStop(double where, Colour colour) {
		this.colourStops.put(where, colour);
	}
	
	/**
	 * Retrieve positions of all colour stops.
	 * @return A list of positions
	 */
	public List<Double> getColourStopPositions() {
		return new ArrayList<Double>(colourStops.keySet());
	}
	
	/**
	 * Retrieve colour value for a given colour stop position.
	 * @param position The position to retrieve the value for
	 * @return The colour value at that colour stop position
	 */
	public Colour getColourforStopPosition(double position) {
		return colourStops.get(position);
	}
	
	/*
	public String getColourStopsAsJSString() {
		final StringBuffer sb = new StringBuffer("[");
		for (Map.Entry<Double, Colour> stop: colourStops.entrySet()) {
			sb.append(stop.getKey()).append(",").append(stop.getValue().toString());
		}		
		sb.append("]");
		return sb.toString();
	}
	*/
}
