package net.edzard.kinetic.test;

import net.edzard.kinetic.Kinetic;
import net.edzard.kinetic.Layer;
import net.edzard.kinetic.Stage;
import net.edzard.kinetic.Text;
import net.edzard.kinetic.Vector2d;

import com.google.gwt.dom.client.Element;
import com.google.gwt.junit.client.GWTTestCase;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.RootPanel;

public class TextTestGwt extends GWTTestCase {

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
	private final static String text = "FooBar 4711";
	private final static double paddingIncrement = 23.23;
	
	/**
	 * Tests changing of padding.
	 */
	public void testChangeOfPadding() {
		
		// Create a text object
		final Text t = Kinetic.createText(position, text);
		System.out.println(t);
		layer.add(t);

		// Change padding
		final double padding = t.getPadding();
		t.setPadding(padding + paddingIncrement);
		assertEquals("Could not properly change padding on Text object", padding + paddingIncrement, t.getPadding(), 0.0000001);
	}	
}
