package net.edzard.kinetic.test;

import net.edzard.kinetic.Circle;
import net.edzard.kinetic.Kinetic;
import net.edzard.kinetic.Layer;
import net.edzard.kinetic.Stage;
import net.edzard.kinetic.Vector2d;

import com.google.gwt.dom.client.Element;
import com.google.gwt.junit.client.GWTTestCase;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.RootPanel;

public class ShapeTestGwt extends GWTTestCase {

	@Override
	public String getModuleName() {
		return "net.edzard.kinetic";
	}
	
	Stage stage;
	Layer layer;
	
	@Override
	protected void gwtSetUp() throws Exception {
		
		// Kinetic needs a special div in the DOM
		Element div = DOM.createDiv();
		RootPanel.getBodyElement().appendChild(div);
		
		// Setup stage
		stage = Kinetic.createStage(div, 400, 400);
		layer = Kinetic.createLayer();
		stage.add(layer);
	}
	
	private final static Vector2d origin = new Vector2d(10,10);
	private final static Vector2d outlier = new Vector2d(50,50);
	private final static double radius = 5;

	/**
	 * Tests if shape can identify a point inside it, as well as an outlying point.
	 */
	// TODO: does not work with current test system setup
	public void testIntersects() {
		
		// Create a circle
		Circle c = Kinetic.createCircle(origin, radius); 
		layer.add(c);
		stage.draw();	// TODO: This has an issue
		
		// Check for a point in the circle
		assertTrue("Point should intersect shape", c.intersects(origin));	// TODO: As well as this
		
		// Check for a point outside of the circle
		assertFalse("Point should not intersect shape", c.intersects(outlier));
	}	
}
