package net.edzard.kinetic;

import java.util.Arrays;
import java.util.List;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Base class for all of the Kinetic classes.
 * Contains functionality for:
 * <ul>
 * <li>Event handling
 * <li>Naming
 * <li>Positioning, Rotation and Scaling
 * <li>Visibility
 * </ul>
 * @author Ed
 */
public abstract class Node extends JavaScriptObject {
	
	/**
	 * Defines signature for event callbacks 
	 * @author Ed
	 */
	public interface EventListener {

		/**
		 * Handles an event.
		 * Called by Kinetic.
		 * @param evt The event received
		 * @return True, if the event should be processed further by bubbling up in the hierarchy. False, if bubbling should stop. 
		 */
		public boolean handle(Event evt);
	}
	
	/**
	 * Constraints freedom of direction for dragging operations.
	 * @author Ed
	 */
	public enum DragConstraint {
		/** Full freedom of direction */
		NONE,
		/** Only horizontally dragable*/
		HORIZONTAL,
		/** Only vertically dragable*/
		VERTICAL
	}

	/**
	 * Protected Ctor.
	 * Makes JSNI (GWT) happy
	 */
	protected Node() {}
	
	public native final Layer getLayer() /*-{
		return this.getLayer();
	}-*/;
	
	public native final Node getParent() /*-{
		return this.getParent();
	}-*/;
	
	/**
	 * Retrieve the node's absolute opacity.
	 * @return A value between 0 and 1. 0 is complete transparency and 1 is complete opaque.
	 */
	public native final double getAbsoluteOpacity() /*-{
		return this.getAbsoluteOpacity();
	}-*/;
	
	/**
	 * Retrieve the node's absolute position.
	 * @return The position
	 */
	public native final Vector2d getAbsolutePosition() /*-{
		var pos = this.getAbsolutePosition();
		return @net.edzard.kinetic.Vector2d::new(DD)(pos.x, pos.y);
	}-*/;
	
	/**
	 * Set the node's absolute position.
	 * @param position The position
	 */
	public final native void setAbsolutePosition(final Vector2d position) /*-{
		this.setAbsolutePosition(position.@net.edzard.kinetic.Vector2d::x, position.@net.edzard.kinetic.Vector2d::y);
	}-*/;
	
	/**
	 * Retrieve the node's absolute Z index.
	 * @return The z index
	 */
	public native final double getAbsoluteZIndex() /*-{
		return this.getAbsoluteZIndex();
	}-*/;
	
	/**
	 * Retrieve the node's position relative to container.
	 * @return The position
	 */
	public native final Vector2d getPosition() /*-{
		var pos = this.getPosition();
		return @net.edzard.kinetic.Vector2d::new(DD)(pos.x, pos.y);
	}-*/;

	
	/**
	 * Set the node's position relative to container.
	 * @param position The position
	 */
	public final native void setPosition(final Vector2d position) /*-{
		this.setPosition(position.@net.edzard.kinetic.Vector2d::x, position.@net.edzard.kinetic.Vector2d::y);
	}-*/;
	
	/**
	 * Set the node's position relative to container.
	 * @param x A horizontal position
	 * @param y A vertical position
	 */
	public final native void setPosition(double x, double y) /*-{
		this.setPosition(x,y);
	}-*/;
	
	/**
	 * Get horizontal position relative to container.
	 * @return The horizontal position
	 */
	public final native double getX() /*-{
		return this.getX();
	}-*/;

	/**
	 * Set horizontal position relative to container.
	 * @param x The horizontal position
	 */
	public final native void setX(double x) /*-{
		this.setX(x);
	}-*/;

	/**
	 * Get vertical position relative to container.
	 * @param x The vertical position
	 */
	public final native double getY() /*-{
		return this.getY();
	}-*/;

	/**
	 * Set the vertical position relative to container.
	 * @param y The vertical position
	 */
	public final native void setY(double y) /*-{
		this.setY(y);
	}-*/;
	
	/**
	 * Makes this node visible.
	 * Used in conjunction with {@link #hide()}
	 */
	public final native void show() /*-{
		this.show();
	}-*/;
	
	/**
	 * Hides this node.
	 * Used in conjunction with {@link #show()}
	 */
	public final native void hide() /*-{
		this.hide();
	}-*/;
	
	/**
	 * Checks visibility of the node.
	 * @return True, if node is visible.
	 */
	public final native boolean isVisible() /*-{
		return this.isVisible();
	}-*/;
	
	/**
	 * Move the node's position relative to container.
	 * @param position The position
	 */
	public final native void move(final Vector2d position) /*-{
		this.move(position.@net.edzard.kinetic.Vector2d::x, position.@net.edzard.kinetic.Vector2d::y);
	}-*/;
	
	/**
	 * Move the node's position relative to container.
	 * @param x A horizontal position
	 * @param y A vertical position
	 */
	public final native void move(double x, double y) /*-{
		this.move(x,y);
	}-*/;
	
	/**
	 * Moves the node to the highest Z position.
	 * It will be in front of all of the other nodes on a given layer.
	 * Node needs to belong to a layer.
	 */
	public final native void moveToTop() /*-{
		this.moveToTop();
	}-*/;

	/**
	 * Moves the node to the lowest Z position.
	 * It will be behind all of the other nodes on a given layer.
	 * Node needs to belong to a layer.
	 */
	public final native void moveToBottom() /*-{
		this.moveToBottom();
	}-*/;

	/**
	 * Increases the Z position of the node.
	 * Node needs to belong to a layer.
	 */
	public final native void moveUp() /*-{
		this.moveUp();
	}-*/;

	/**
	 * Decreases the Z position of the node.
	 * Node needs to belong to a layer.
	 */
	public final native void moveDown() /*-{
		this.moveDown();
	}-*/;

	/**
	 * Get the current Z position of the node relative to the container.
	 * Node needs to belong to a layer.
	 * @return The Z position
	 */
	public final native int getZIndex() /*-{
		return this.getZIndex();
	}-*/;

	/**
	 * Sets the Z position of the node.
	 * Node needs to belong to a layer.
	 * @param z A new Z position
	 */
	public final native void setZIndex(int z) /*-{
		this.setZIndex(z);
	}-*/;

		
	/**
	 * Enable or disable event handling.
	 * @param listening True, if events should be handled. False, otherwise.
	 */
	public final native void setListening(boolean listening) /*-{
		this.setListening(listening);
	}-*/;
	
	/**
	 * Check if events are handled.
	 * @return True, if events are handled
	 */
	public final native boolean isListening() /*-{
		return this.getListening();
	}-*/;

	/**
	 * Retrieve a node's unique identifier.
	 * @return The identifier or <emph>null</emph> if not set.
	 */
	public final native String getID() /*-{
		return this.getAttrs().id;
	}-*/;
	
	/**
	 * Set a unique identifier for this node.
	 * @param newID An identifier.
	 */
	public final native void setID(String newID) /*-{
		this.getAttrs().id = newID;
	}-*/;

	/**
	 * Retrieve a node's name.
	 * @return The name or <emph>null</emph> if not set.
	 */	
	public final native String getName() /*-{
		return this.getAttrs().name;
	}-*/;

	/**
	 * Set a name for this node.
	 * Names do not have to be unique - two nodes with the same name can exist.
	 * @param newName A name.
	 */
	public final native void setName(String newName) /*-{
		this.getAttrs().name = newName;
	}-*/;
	
	/**
	 * Retrieve the opacity of the complete node.
	 * @return A value between 0 and 1. 0 is complete transparency and 1 is complete opaque.
	 */
	public final native double getOpacity() /*-{
		return this.getOpacity();
	}-*/;

	/**
	 * Set the opacity of the complete node.
	 * @param opacity A value between 0 and 1. 0 is complete transparency and 1 is complete opaque.
	 */
	public final native void setOpacity(double opacity) /*-{
		this.setOpacity(opacity);
	}-*/;

	/**
	 * Retrieve the node's scaling.
	 * @return The two scaling components. The x component holds the horizontal scale, while y holds the vertical scale.
	 */
	public final native Vector2d getScale() /*-{
		return @net.edzard.kinetic.Vector2d::new(DD)(this.getScale().x, this.getScale().y);
	}-*/;

	/**
	 * Set scaling for the node.
	 * @param scale The two scaling components. The x component holds the horizontal scale, while y holds the vertical scale.
	 */
	public final native void setScale(Vector2d scale) /*-{
		this.setScale([scale.@net.edzard.kinetic.Vector2d::x, scale.@net.edzard.kinetic.Vector2d::y]);
	}-*/;
	
	/**
	 * Retrieve the node's rotation in radians.
	 * @return The rotation
	 */
	public final native double getRotation() /*-{
		return this.getRotation();
	}-*/;

	/**
	 * Set the node's rotation. 
	 * @param rot The rotation in radians
	 */
	public final native void setRotation(double rot) /*-{
		this.setRotation(rot);
	}-*/;
	
	/**
	 * Retrieve the node's center offset.
	 * The center offset is used during transformations (positioning, scaling, rotation)
	 * @return The center offset
	 */
	public final native Vector2d getOffset() /*-{
		return @net.edzard.kinetic.Vector2d::new(DD)(this.getOffset().x, this.getOffset().y);
	}-*/;

	/**
	 * Assign the node's center offset.
	 * The center offset is used during transformations (positioning, scaling, rotation)
	 * @param offset The node center's offset
	 */
	public final native void setOffset(Vector2d offset) /*-{
		this.setOffset([offset.@net.edzard.kinetic.Vector2d::x, offset.@net.edzard.kinetic.Vector2d::y]);
	}-*/;
	
	/**
	 * Enable or disable dragging of the node.  
	 * @param drag True, if the node should be dragable. False, if not.
	 */
	public final native void setDraggable(boolean drag) /*-{
		this.setDraggable(drag);
	}-*/;

	/**
	 * Checks if a node can be dragged.
	 * @return True, in case that the node can be dragged. False, otherwise.
	 */
	public final native boolean isDraggable() /*-{
		return this.getAttrs().draggable;
	}-*/;

	/**
	 * Receive the drag constraints for this node.
	 * @return One of the possible drag constraints.
	 */
	public final native DragConstraint getDragConstraint() /*-{
		if (this.getDetectionType() != null) 
			return @net.edzard.kinetic.Node.DragConstraint::valueOf(Ljava/lang/String;)(this.getDragConstraint().toUpperCase());
		else return null;
	}-*/;

	/**
	 * Assign drag constraints to this node.
	 * @param type One of the possible drag constraints
	 */
	public final native void setDragConstraint(DragConstraint type) /*-{
		this.setDragConstraint(type.@net.edzard.kinetic.Node.DragConstraint::toString()().toLowerCase());
	}-*/;
	
	/**
	 * Retrieve the drag bounds for this node.
	 * @return The drag bounds as two points (left/top and right/bottom) in node coordination space
	 */
	public final native Box2d getDragBounds() /*-{
		var bounds = this.getDragBounds();
		if (bounds != null) {
			box = @net.edzard.kinetic.Box2d::new()();
			if (bounds.left != null) box.@net.edzard.kinetic.Box2d::left = bounds.left;
			if (bounds.top != null) box.@net.edzard.kinetic.Box2d::top = bounds.top;
			if (bounds.right != null) box.@net.edzard.kinetic.Box2d::right = bounds.right;
			if (bounds.bottom != null) box.@net.edzard.kinetic.Box2d::bottom = bounds.bottom;
			return box;
		} else return null;
	}-*/;

	/** 
	 * Assign drag bounds for this node.
	 * @param box The drag bounds as two points (left/top and right/bottom) in node coordination space
	 */
	public final native void setDragBounds(Box2d box) /*-{
		var bounds = {};
		if (box.@net.edzard.kinetic.Box2d::left != @java.lang.Double::NaN) bounds.left = box.@net.edzard.kinetic.Box2d::left;
		if (box.@net.edzard.kinetic.Box2d::top != @java.lang.Double::NaN) bounds.top = box.@net.edzard.kinetic.Box2d::top;
		if (box.@net.edzard.kinetic.Box2d::right != @java.lang.Double::NaN) bounds.right = box.@net.edzard.kinetic.Box2d::right;
		if (box.@net.edzard.kinetic.Box2d::bottom != @java.lang.Double::NaN) bounds.bottom = box.@net.edzard.kinetic.Box2d::bottom;
		this.setDragBounds(bounds);
	}-*/;	
	
	/**
	 * Clear the node's drag bounds.
	 */
	public final native void clearDragBounds() /*-{
		this.setDragBounds(null);
	}-*/;
	
	/**
	 * Add an event listener to the node.
	 * @param type A single event type to listen for.
	 * @param handler The handler.
	 */
	public final void addEventListener(Event.Type type, EventListener handler) {
		addEventListener(Arrays.asList(type), handler);
	}
	
	/**
	 * Create a list of event types as strings.
	 * Used internally to interface with Javascript.
	 * @param eventTypes The event types
	 * @return A string of the event types
	 */
	private final static String createEventTypeString(List<Event.Type> eventTypes) {
		final StringBuffer sb = new StringBuffer();
		for (Event.Type type: eventTypes) {
			sb.append(type.toString().toLowerCase()).append(" ");
		}
		return sb.toString().trim();
	}
	
	/**
	 * Add a multi-event listener to the node.
	 * @param eventTypes A number of events to listen to
	 * @param handler The handler.
	 */
	// Seems to be buggy in kineticjs. Always getting mousemove events
	// TODO Maik: It's not buggy, it just fails and then creates too many events due to the failure.
	//             the evt variable is directly from the browser, not from kineticjs, that's why there's
	//             a mismatch between event types
	//             Touch also needs to be handled differently if evt should be used.
	//       quick fix: ignore evt object
	public final native void addEventListener(List<Event.Type> eventTypes, EventListener handler) /*-{	
		this.on(@net.edzard.kinetic.Node::createEventTypeString(Ljava/util/List;)(eventTypes), function(evt) {
//			if (evt != null) {
//				console.log(evt.type);
//				var javaEvt = @net.edzard.kinetic.Event::new(Lnet/edzard/kinetic/Event$Type;Lnet/edzard/kinetic/Event$Button;II)(
//					@net.edzard.kinetic.Event.Type::valueOf(Ljava/lang/String;)(evt.type.toUpperCase()),
//					@net.edzard.kinetic.Event.Button::fromInteger(I)(evt.button),
//					evt.offsetX,
//					evt.offsetY
//				);
//				javaEvt.@net.edzard.kinetic.Event::setShape(Lnet/edzard/kinetic/Shape;)(evt.shape);
//				var bubble = handler.@net.edzard.kinetic.Node.EventListener::handle(Lnet/edzard/kinetic/Event;)(javaEvt);
//				evt.cancelBubble = !bubble;
//			} else {
				handler.@net.edzard.kinetic.Node.EventListener::handle(Lnet/edzard/kinetic/Event;)(null);
//			}
		});
	}-*/;
	
	/**
	 * Remove an event listener from the node.
	 * @param type The event Type to stop listening to
	 */
	public final void removeEventListener(Event.Type type) {
		removeEventListener(Arrays.asList(type));
	}
	

	/**
	 * Remove an event listener from the node.
	 * @param eventTypes A numebr of event types to stop listening to
	 */
	// Might be buggy in Kineticjs 	
	public final native void removeEventListener(List<Event.Type> eventTypes) /*-{
		this.off(@net.edzard.kinetic.Node::createEventTypeString(Ljava/util/List;)(eventTypes));
	}-*/;
	
	/**
	 * Simulates the firing of an event.
	 * This will trigger the appropriate listeners with empty event objects.
	 * @param type The event type to simulate
	 */
	public final native void simulate(Event.Type type) /*-{
		this.simulate(type.@net.edzard.kinetic.Event.Type::toString()().toLowerCase());
	}-*/;
	
	/**
	 * Animate a transition of the node.
	 * Used internally to compose transitions.
	 * Don't use directly - use methods exposed by specialized shapes.
	 * @param target The target node (has to be the same type of node as the one on which this method is called)
	 * @param sb The composition buffer for the transition configuration
	 * @param duration The duration of the transition
	 * @param ease An easing function
	 * @param callback Will be called at the end of the transition
	 * @return An object to control the transition animation
	 */
	final Transition transitionToNode(Node target, StringBuffer sb, double duration, EasingFunction ease, Runnable callback) {
		if (this.getPosition() != target.getPosition()) sb.append("x:").append(target.getPosition().x).append(",").append("y:").append(target.getPosition().y).append(",");
		if (this.getOpacity() != target.getOpacity()) sb.append("opacity:").append(target.getOpacity()).append(",");
		if (!this.getScale().equals(target.getScale())) sb.append("scale:{x:").append(target.getScale().x).append(",").append("y:").append(target.getScale().y).append("},");
		if (this.getRotation() != target.getRotation()) sb.append("rotation:").append(target.getRotation()).append(",");
		if (!this.getOffset().equals(target.getOffset())) sb.append("centerOffset:{x:").append(target.getOffset().x).append(",").append("y:").append(target.getOffset().y).append("},");
		if (ease != null) sb.append("easing:\'").append(ease.toString()).append("\',");
		sb.append("duration:").append(duration);
		return transitionToInternal(sb.toString(), callback);
	}
	
	/**
	 * Set the transition string.
	 * Used internally to interface with Javascript.
	 * @param configStr The transition's configuration string
	 * @param callback Will be called at the end of the transition
	 * @return An object to control the transition animation
	 */
	private final native Transition transitionToInternal(String configStr, Runnable callback) /*-{
		
		eval("var config = {" + configStr + "}");
		if (callback != null) {
			config.callback = function() {callback.@java.lang.Runnable::run()();};
		}
		return this.transitionTo(config);
	}-*/;
}
