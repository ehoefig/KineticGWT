This fork transforms KineticGWT into a proper Maven project, so that it
is easily reusable as a module.

How to use
==========

1. Add the following dependency to your pom.xml:

		<dependency>
			<groupId>net.edzard</groupId>
			<artifactId>kineticgwt</artifactId>
			<version>0.0.1-SNAPSHOT</version>
		</dependency>
		
2. Add the following to your .gwt.xml file:

		<inherits name="net.edzard.kinetic"/>
			
3. Add the following to your HTML file:

		<script type="text/javascript" src="..projname../kinetic-v3.10.5.js"></script> 
		

Code sample
===========

		// Kinetic needs a special div in the DOM
		Element div = DOM.createDiv();
		div.setId(Kinetic.stageId);
		RootPanel.getBodyElement().appendChild(div);
		
		// Setup stage
		Stage stage = Kinetic.createStage(400, 400);
		Layer layer = Kinetic.createLayer();
		stage.add(layer);
		
		Rectangle c = Kinetic.createRectangle(new Box2d(10, 10, 200, 200)); 
		layer.add(c);
		stage.draw();