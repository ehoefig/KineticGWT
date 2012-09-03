package net.edzard.kinetic.test;

import net.edzard.kinetic.Circle;
import net.edzard.kinetic.Ellipse;
import net.edzard.kinetic.Kinetic;
import net.edzard.kinetic.Layer;
import net.edzard.kinetic.Stage;
import net.edzard.kinetic.Vector2d;

import com.google.gwt.dom.client.Element;
import com.google.gwt.junit.client.GWTTestCase;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.RootPanel;

public class NodeGwtTest extends GWTTestCase {

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
		div.setId(Kinetic.stageId);
		RootPanel.getBodyElement().appendChild(div);
		
		// Setup stage
		stage = Kinetic.createStage(400, 400);
		layer = Kinetic.createLayer();
		stage.add(layer);
	}

	public void testCreationZOrder() {
		for (int i=0; i < 3; ++i) {
			Ellipse c = Kinetic.createCircle(new Vector2d(10,10), 5); 
			layer.add(c);
			assertEquals(i, c.getZIndex());	
		}
	}	
}
