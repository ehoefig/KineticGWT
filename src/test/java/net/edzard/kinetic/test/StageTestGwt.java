package net.edzard.kinetic.test;

import net.edzard.kinetic.Kinetic;

import com.google.gwt.dom.client.Element;
import com.google.gwt.junit.client.GWTTestCase;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.RootPanel;

public class StageTestGwt extends GWTTestCase {

	private Element stageEl;
	
	@Override
	public String getModuleName() {
		return "net.edzard.kinetic";
	}

	
	@Override
	protected void gwtSetUp() throws Exception {
		
		// Kinetic needs a special div in the DOM
		stageEl = DOM.createDiv();
		RootPanel.getBodyElement().appendChild(stageEl);
		
	}



	public void testSimple() {
		Kinetic.createStage(stageEl, 400, 400);
		assertTrue(true);
	}	
}
