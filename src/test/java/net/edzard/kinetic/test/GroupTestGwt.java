package net.edzard.kinetic.test;

import java.util.List;

import net.edzard.kinetic.Circle;
import net.edzard.kinetic.Group;
import net.edzard.kinetic.Kinetic;
import net.edzard.kinetic.Layer;
import net.edzard.kinetic.Node;
import net.edzard.kinetic.Stage;
import net.edzard.kinetic.Vector2d;

import com.google.gwt.dom.client.Element;
import com.google.gwt.junit.client.GWTTestCase;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.RootPanel;

public class GroupTestGwt extends GWTTestCase {

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

	private final static Vector2d origin1 = new Vector2d(10,10);
	private final static String name1 = "foo";
	private final static Vector2d origin2 = new Vector2d(20,20);
	private final static String name2 = "bar";
	private final static double radius = 5;
	
	/**
	 * Check if we can access the children of a group
	 */
	public void testGetChildren() {	
				
		// Create a group
		final Group group = Kinetic.createGroup();
		
		final Circle c1 = Kinetic.createCircle(origin1, radius);
		c1.setName(name1);
		group.add(c1);
		
		final Circle c2 = Kinetic.createCircle(origin2, radius);
		c2.setName(name2);
		group.add(c2);
		
		layer.add(group);
		//stage.draw();	// TODO: calls to "draw()" crash the test system
		
		// Check children
		List<Node> children = group.getChildren();
		assertEquals("Wrong name", name1, children.get(0).getName());
		assertEquals("Wrong name", name2, children.get(1).getName());
	}	
}
