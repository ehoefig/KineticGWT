package net.edzard.kinetic.test;

import net.edzard.kinetic.Kinetic;

import com.google.gwt.dom.client.Element;
import com.google.gwt.junit.client.GWTTestCase;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.RootPanel;

public class StageGwtTest extends GWTTestCase {

	@Override
	public String getModuleName() {
		return "net.edzard.kinetic";
	}

	
	
	@Override
	protected void gwtSetUp() throws Exception {
		
		// Kinetic needs a special div in the DOM
		Element div = DOM.createDiv();
		div.setId(Kinetic.stageId);
		RootPanel.getBodyElement().appendChild(div);
		
	}



	public void testSimple() {
		Kinetic.createStage(400, 400);
		assertTrue(true);
	}	
}
