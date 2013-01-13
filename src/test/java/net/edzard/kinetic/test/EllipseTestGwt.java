package net.edzard.kinetic.test;

import net.edzard.kinetic.Ellipse;
import net.edzard.kinetic.Kinetic;
import net.edzard.kinetic.Layer;
import net.edzard.kinetic.Stage;
import net.edzard.kinetic.Vector2d;

import com.google.gwt.dom.client.Element;
import com.google.gwt.junit.client.GWTTestCase;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.RootPanel;

public class EllipseTestGwt extends GWTTestCase {

	private Stage stage;
	private Layer layer;
	
	@Override
	public String getModuleName() {
		return "net.edzard.kinetic";
	}

	@Override
	protected void gwtSetUp() throws Exception {
		Element div = DOM.createDiv();
		RootPanel.getBodyElement().appendChild(div);
		this.stage = Kinetic.createStage(div, 400, 400);
		layer = Kinetic.createLayer(this.stage);
	}

	private final static Vector2d position = new Vector2d(100,100);
	private final static Vector2d originalRadius = new Vector2d(23,23);
	private final static Vector2d changedRadius = new Vector2d(23,23);
	
	public void testChangeOfRadius() {
		
		// Create an ellipse
		final Ellipse e = Kinetic.createEllipse(position, originalRadius);
		layer.add(e);
		assertEquals("Creation method for Ellipse object does not set proper radius", originalRadius, e.getRadius());
		
		// Change radius
		e.setRadius(changedRadius);
		assertEquals("Could not properly change radius on Ellipse object",changedRadius, e.getRadius());
	}	
}
