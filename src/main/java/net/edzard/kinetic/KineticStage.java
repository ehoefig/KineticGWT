package net.edzard.kinetic;

import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;

/**
 * Wrapper for a Kinetic Stage to be easily used as Widget, also within UiBinder.
 * @author maik
 *
 */
public class KineticStage extends Composite {

	private final Stage stage;
	
	@UiConstructor
	public KineticStage(int width, int height) {
		HTMLPanel panel = new HTMLPanel("");
		initWidget(panel);
		stage = Kinetic.createStage(panel.getElement(), width, height);
	}
	
	/**
	 * Gets the underlying Stage object with which 
	 * @return
	 */
	public Stage getNativeStage() {
		return stage;
	}
	
	public int getWidth() {
		return stage.getWidth();
	}
	
	public int getHeight() {
		return stage.getHeight();
	}
	
	public void setWidth(int width) {
		stage.setWidth(width);
	}
	
	public void setHeight(int height) {
		stage.setHeight(height);
	}
	
	// TODO could add remaining wrapper methods (introduce Stage interface then)
	//       then we might not need access to the native stage anymore and get a nice interface
	//       but then this class should be renamed to Stage and the current Stage should
	//       become something else
	
}
