package net.edzard.kinetic;

import java.util.ArrayList;
import java.util.List;

/**
 * Defines a path using a variety of drawing commans.
 * Paths are used to define custom shapes. The path object uses command chaining, which enables you to specify complete paths by using combined statements.
 * For example: new Path().beginPath().moveTo(new Vector2d(200,50)).lineTo(new Vector2d(420,80)).quadraticCurveTo(new Vector2d(300, 100), new Vector2d(260, 170)).closePath();
 * @author Ed
 * @see CustomShape
 */
public class Path {
	
	/**
	 * The type of a path command
	 * @author Ed
	 */
	public enum CommandType {
		UNKNOWN, BEGIN, MOVE, CLOSE, LINE, QUADRATIC, BEZIER, ARCTO, ARC, RECT
	};
	
	/**
	 * Base class for all path commands
	 * @author Ed
	 */
	public class Command {
		public CommandType type = CommandType.UNKNOWN;
	}

	/**
	 * Command for beginning a path
	 * @author Ed
	 */
	public class BeginPathCommand extends Command {
		/**
		 * Default Ctor
		 */
		public BeginPathCommand() {
			type = CommandType.BEGIN;
		}
	}
	
	/**
	 * Command for creating a new subpath with the given point.
	 * No connection to the previous position is made.
	 * @author Ed
	 */
	public class MoveToCommand extends Command {
		
		/** A position */
		private Vector2d pos;
		
		/**
		 * Parametrized Ctor.
		 * @param pos A new position value
		 */
		public MoveToCommand(Vector2d pos) {
			type = CommandType.MOVE;
			this.pos = pos;
		}
		
		/**
		 * Retrieve the position.
		 * @return The position value
		 */
		public Vector2d getPosition() {
			return pos;
		}

		/**
		 * Assign a position value.
		 * @param pos A position value
		 */
		public void setPosition(Vector2d pos) {
			this.pos = pos;
		}

	}
	
	/**
	 * Command for marking the current subpath as closed, and starting a new subpath using the same point as the one for the end of the newly closed subpath.
	 * @author Ed
	 */
	public class ClosePathCommand extends Command {
		/**
		 * Default Ctor.
		 */
		public ClosePathCommand() {
			type = CommandType.CLOSE;
		}
	}
	
	/**
	 * Command for adding the given point to the current subpath and connecting it to the previous one by a straight line. 
	 * @author Ed
	 */
	public class LineToCommand extends Command {
		
		/** A position to line to */
		private Vector2d pos;

		/**
		 * Parametrized Ctor.
		 * @param pos A position to draw a line to
		 */
		public LineToCommand(Vector2d pos) {
			super();
			type = CommandType.LINE;
			this.pos = pos;
		}

		/**
		 * Retrieve the position.
		 * @return The position where to draw a line to
		 */
		public Vector2d getPosition() {
			return pos;
		}

		/**
		 * Assign a position.
		 * @param pos A position to draw a line to
		 */
		public void setPosition(Vector2d pos) {
			this.pos = pos;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "LineTo" + pos;
		}
	}
	
	/**
	 * Command for adding the given point to the current subpath and connecting to the previous one by a quadratic Bezier curve with one given control point.
	 * @author Ed
	 */
	public class QuadraticCurveCommand extends Command {
		
		/** The control point */
		private Vector2d cp;
		/** The position */
		private Vector2d pos;
	
		/**
		 * Parametrized Ctor.
		 * @param cp The control point
		 * @param pos The position
		 */
		public QuadraticCurveCommand(Vector2d cp, Vector2d pos) {
			super();
			type = CommandType.QUADRATIC;
			this.pos = pos;
			this.cp = cp;
		}
	
		/**
		 * Retrieve the position.
		 * @return The position where to draw a curve to
		 */
		public Vector2d getPosition() {
			return pos;
		}
	
		/**
		 * Assign a position.
		 * @param pos A position to draw a curve to
		 */
		public void setPosition(Vector2d pos) {
			this.pos = pos;
		}
		
		/**
		 * Retrieve the control point.
		 * @return The control point for the curve
		 */
		public Vector2d getControlPoint() {
			return cp;
		}
	
		/**
		 * Assign a control point.
		 * @param cp A control point for the curve
		 */
		public void setControlPoint(Vector2d cp) {
			this.cp = cp;
		}
	}
	
	/**
	 * Command for adding the given point to the current subpath and connecting to the previous one by a cubic Bezier curve with two given control points.
	 * @author Ed
	 */
	public class BezierCurveCommand extends Command {
	
		private Vector2d cp1;
		private Vector2d cp2;
		private Vector2d pos;
		
		/**
		 * Parametrized Ctor
		 * @param cp1 Control point 1
		 * @param cp2 Control point 2
		 * @param pos The position to draw a curve to
		 */
		public BezierCurveCommand(Vector2d cp1, Vector2d cp2, Vector2d pos) {
			super();
			type = CommandType.BEZIER;
			this.pos = pos;
			this.cp1 = cp1;
			this.cp2 = cp2;
		}
	
		/**
		 * Retrieve the position.
		 * @return The position where to draw a curve to
		 */
		public Vector2d getPosition() {
			return pos;
		}
	
		/**
		 * Assign a position.
		 * @param pos A position to draw a curve to
		 */
		public void setPosition(Vector2d pos) {
			this.pos = pos;
		}
		
		/**
		 * Retrieve the control point 1.
		 * @return The control point 1 for the curve
		 */
		public Vector2d getControlPoint1() {
			return cp1;
		}
	
		/**
		 * Assign a the control point 1.
		 * @param cp1 The control point 1 for the curve
		 */
		public void setControlPoint1(Vector2d cp1) {
			this.cp1 = cp1;
		}
		
		/**
		 * Retrieve the control point 2.
		 * @return The control point 2 for the curve
		 */
		public Vector2d getControlPoint2() {
			return cp2;
		}

		/**
		 * Assign a the control point 2.
		 * @param cp2 The control point 2 for the curve
		 */
		public void setControlPoint2(Vector2d cp2) {
			this.cp2 = cp2;
		}
	}
	
	/** 
	 * Command for adding an arc with the given two position points and radius to the current subpath and connecting it to the previous point by a straight line.
	 * @author Ed
	 */
	public class ArcToCommand extends Command {
		
		/** First position */
		private Vector2d pos1;
		/** Second position */
		private Vector2d pos2;
		/** Radius of arc */
		double radius;
		
		/**
		 * Parametrized Ctor.
		 * @param pos1 The first position
		 * @param pos2 The second position
		 * @param radius The arc's radius
		 */
		public ArcToCommand(Vector2d pos1, Vector2d pos2, double radius) {
			super();
			type = CommandType.ARCTO;
			this.pos1 = pos1;
			this.pos2 = pos2;
			this.radius = radius;
		}
	
		/**
		 * Retrieve the first position point.
		 * @return A position point for drawing the arc
		 */
		public Vector2d getPosition1() {
			return pos1;
		}

		/**
		 * Assign the first position point.
		 * @param pos A position point for drawing the arc
		 */
		public void setPosition1(Vector2d pos1) {
			this.pos1 = pos1;
		}

		/**
		 * Retrieve the second position point.
		 * @return A position point for drawing the arc
		 */
		public Vector2d getPosition2() {
			return pos2;
		}
	
		/**
		 * Assign the second position point.
		 * @param pos A position point for drawing the arc
		 */
		public void setPosition2(Vector2d pos2) {
			this.pos2 = pos2;
		}
		
		/**
		 * Retrieve the radius.
		 * @return The arc's radius
		 */
		public double getRadius() {
			return radius;
		}
	
		/**
		 * Assign the radius.
		 * @param radius A new radius for the arc
		 */
		public void setRadius(double radius) {
			this.radius = radius;
		}
		
	}

	/**
	 * Command for adding points to the subpath such that the arc described by the circumference of the circle described by the arguments, 
	 * starting at the given start angle and ending at the given end angle, going in the given direction (defaulting to clockwise), is added to the path, 
	 * connected to the previous point by a straight line. This sounds complicated. It's not. Try it.
	 * @author Ed
	 */
	public class ArcCommand extends Command {
		
		/** The position */
		private Vector2d pos;
		/** The arc's radius */
		private double radius;
		/** The start angle */
		private double startAngle;
		/** The end angle */
		private double endAngle;
		/** Controls direction */
		private boolean clockwise;
		
		/**
		 * Parametrized Ctor.
		 * @param pos The initial position
		 * @param radius Arc's radius
		 * @param startAngle The start angle
		 * @param endAngle The end angle
		 * @param clockwise Control direction. True is clockwise, False is anti-clockwise
		 */
		public ArcCommand(Vector2d pos, double radius, double startAngle, double endAngle, boolean clockwise) {
			super();
			type = CommandType.ARC;
			this.pos = pos;
			this.radius = radius;
			this.startAngle = startAngle;
			this.endAngle = endAngle;
			this.clockwise = clockwise;
		}

		/**
		 * Retrieve the position.
		 * @return The position for drawing the arc
		 */
		public Vector2d getPosition() {
			return pos;
		}
	
		/**
		 * Assign a position.
		 * @param pos A position for drawing the arc
		 */
		public void setPosition(Vector2d pos) {
			this.pos = pos;
		}

		/**
		 * Retrieve the radius.
		 * @return The arc's radius
		 */
		public double getRadius() {
			return radius;
		}
	
		/**
		 * Assign the radius.
		 * @param radius A new radius for the arc
		 */
		public void setRadius(double radius) {
			this.radius = radius;
		}
		
		/**
		 * Retrieve start angle.
		 * @return The start angle
		 */
		public double getStartAngle() {
			return startAngle;
		}

		/**
		 * Assign a start angle.
		 * @param startAngle The start angle
		 */
		public void setStartAngle(double startAngle) {
			this.startAngle = startAngle;
		}

		/**
		 * Retrieve end angle.
		 * @return The end angle
		 */
		public double getEndAngle() {
			return endAngle;
		}

		/**
		 * Assign an end angle.
		 * @param endAngle The end angle
		 */
		public void setEndAngle(double endAngle) {
			this.endAngle = endAngle;
		}

		/**
		 * Check if the drawing direction is clockwise.
		 * @return True, if it is clockwise. False, otherwise.
		 */
		public boolean isClockwise() {
			return clockwise;
		}

		/**
		 * Set the draweing direction
		 * @param clockwise Set to true if drawing should occur clockwise. Otherwise, set to False.
		 */
		public void setClockwise(boolean clockwise) {
			this.clockwise = clockwise;
		}		
	}
	
	/**
	 * Command for adding a new closed subpath to the path, representing the given rectangle. 
	 * @author Ed
	 */
	public class RectCommand extends Command {
	
		/** Definition of the rectangle */
		private Box2d box;

		/**
		 * Parametrized Ctor.
		 * @param box Rectangle extents
		 */
		public RectCommand(Box2d box) {
			super();
			type = CommandType.RECT;
			this.box = box;
		}

		/**
		 * Assign extents of the rectangle.
		 * @return The size definition
		 */
		public Box2d getBox() {
			return box;
		}

		/**
		 * Retrieve extents of the rectangle
		 * @param box The extents
		 */
		public void setBox(Box2d box) {
			this.box = box;
		}
	}
	
	// TODO: Ellipse?
	
	/** Holds the commands that make up this path */
	private List<Command> commands;

	/**
	 * Default Ctor.
	 */
	public Path() {
		this.commands = new ArrayList<Command>();
	}
	
	/**
	 * Begins a path.
	 * @return this (for command chaining)
	 */
	public Path beginPath() {
		commands.add(new BeginPathCommand());
		return this;
	}

	/**
	 * Clears the path.  
	 * @return this (for command chaining)
	 */
	public Path clear() {
		commands.clear();
		return this;
	}

	/**
	 * Moves the current position to a new one (without drawing a line).
	 * @param pos The position to move to
	 * @return this (for command chaining)
	 */
	public Path moveTo(Vector2d pos) {
		 commands.add(new MoveToCommand(pos));
		 return this;
	}
	
	/**
	 * Closes a path.
	 * Multiple sub-paths can be created on a single path.
	 * @return this (for command chaining)
	 */
	public Path closePath() {
		commands.add(new ClosePathCommand());
		return this;
	}
	
	/**
	 * Draws a line to a given position.
	 * @param pos The position to draw a line to
	 * @return this (for command chaining)
	 */
	public Path lineTo(Vector2d pos) {
		commands.add(new LineToCommand(pos));
		return this;
	}
	
	/**
	 * Adding the given position to the current path and connects it to the previous one by a quadratic Bezier curve with one given control point.
	 * @param pos The new position to add to the path
	 * @param cp The single control point for the bezier curve
	 * @return this (for command chaining)
	 */
	public Path quadraticCurveTo(Vector2d pos, Vector2d cp) {
		commands.add(new QuadraticCurveCommand(pos, cp));
		return this;
	}
	
	/**
	 * Adding the given position to the current path and connects it to the previous one by a quadratic Bezier curve with two given control point.
	 * @param pos The new position to add to the path
	 * @param cp1 The first control point
	 * @param cp2 The second control point
	 * @return this (for command chaining)
	 */
	public Path bezierCurveTo(Vector2d pos, Vector2d cp1, Vector2d cp2) {
		commands.add(new BezierCurveCommand(pos, cp1, cp2));
		return this;
	}
	
	/**
	 * Adds an arc with the given two position points and radius to the current path and connects it to the previous position by a straight line.
	 * @param pos1 First position point for the arc
	 * @param pos2 Second position point for the arc
	 * @param radius The arc's radius
	 * @return this (for command chaining)
	 */
	public Path arcTo(Vector2d pos1, Vector2d pos2, double radius) {
		commands.add(new ArcToCommand(pos1, pos2, radius));
		return this;
	}
	
	/**
	 * Adds an arc with the given position to the path such that the circumference of the circle described by the arguments, 
	 * starting at the given start angle and ending at the given end angle, going in the given direction (defaulting to clockwise), 
	 * is added to the path, connected to the previous position by a straight line. This sounds complicated. It's not. Try it.
	 * @param pos Postion for the arc
	 * @param radius Radius of the arc
	 * @param startAngle Start angle of the arc
	 * @param endAngle End angle for the arc
	 * @param clockwise Direction for drawing of the arc. True means clockwise. False means anti-clockwise.
	 * @return this (for command chaining)
	 */
	public Path arc(Vector2d pos, double radius, double startAngle, double endAngle, boolean clockwise) {
		commands.add(new ArcCommand(pos, radius, startAngle, endAngle, clockwise));
		return this;
	}

	/**
	 * Adds a new closed subpath to the path, representing a given rectangle.
	 * @param box The rectangle to add
	 * @return this (for command chaining)
	 */
	public Path rect(Box2d box) {
		commands.add(new RectCommand(box));
		return this;
	}

	/**
	 * Retrieve the commands that make up this path.
	 * @return The current list of path commands
	 */
	public List<Command> getCommands() {
		return commands;
	}
	
}