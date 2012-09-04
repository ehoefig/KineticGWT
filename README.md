KineticGWT is a wrapper of Eric Drowell's excellent [kinetic.js](http://www.kineticjs.com/) library for [Google Web Toolkit](https://developers.google.com/web-toolkit/) (GWT).

How to use
==========

1. Add the following dependency to your pom.xml:

		<dependency>
			<groupId>net.edzard</groupId>
			<artifactId>kineticgwt</artifactId>
			<version>0.91</version>
		</dependency>
		
2. Add the following to your .gwt.xml file:

		<inherits name="net.edzard.kinetic"/>
			
3. Add the following to your HTML file:

		<script type="text/javascript" src="..projname../kinetic-v4.0.1.js"></script> 
		

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