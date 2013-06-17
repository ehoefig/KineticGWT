# KineticGWT [![Build Status](https://secure.travis-ci.org/neothemachine/KineticGWT.png)](http://travis-ci.org/neothemachine/KineticGWT)

KineticGWT is a wrapper of Eric Drowell's excellent [kinetic.js](http://www.kineticjs.com/) library for [Google Web Toolkit](https://developers.google.com/web-toolkit/) (GWT).

## How to use

1. Add the following dependencies to your pom.xml:

		<dependency>
			<groupId>net.edzard</groupId>
			<artifactId>kineticgwt</artifactId>
			<version>0.9.1</version>
		</dependency>
		<dependency>
			<groupId>net.edzard</groupId>
			<artifactId>kineticgwt</artifactId>
			<version>0.9.1</version>
			<classifier>sources</classifier>
		</dependency>
		
2. Add the following to your .gwt.xml file:

		<inherits name="net.edzard.kinetic"/>
		

## Code sample

		// Kinetic needs a special div in the DOM
		Element div = DOM.createDiv();
		RootPanel.getBodyElement().appendChild(div);
		
		// Setup stage
		Stage stage = Kinetic.createStage(div, 400, 400);
		Layer layer = Kinetic.createLayer();
		stage.add(layer);
		
		Rectangle c = Kinetic.createRectangle(new Box2d(10, 10, 200, 200)); 
		layer.add(c);
		stage.draw();