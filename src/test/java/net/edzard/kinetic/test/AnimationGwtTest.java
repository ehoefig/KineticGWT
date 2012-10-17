package net.edzard.kinetic.test;

import net.edzard.kinetic.Animation;
import net.edzard.kinetic.Circle;
import net.edzard.kinetic.Drawable;
import net.edzard.kinetic.Frame;
import net.edzard.kinetic.Kinetic;
import net.edzard.kinetic.Layer;
import net.edzard.kinetic.Stage;
import net.edzard.kinetic.Vector2d;

import com.google.gwt.dom.client.Element;
import com.google.gwt.junit.client.GWTTestCase;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.RootPanel;

public class AnimationGwtTest extends GWTTestCase {

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

	private Vector2d pos1 = new Vector2d(100,100);
	private Vector2d pos2 = new Vector2d(111,111);
	
	public void testAnimatingPosition() {
		
		final Circle e = Kinetic.createCircle(pos1, 10);
		
		final Animation animation = Kinetic.createAnimation(layer, new Drawable() {
			@Override
			public void draw(Frame frame) {
				e.setPosition(pos2);
				assertEquals("Position cannot be set", pos2, e.getPosition());
			}
		});
		
		assertEquals("Position cannot be set", pos1, e.getPosition());
		animation.start();
		layer.draw();
		animation.stop();
		assertEquals("Animated position does not match", pos2, e.getPosition());
	}	
}
