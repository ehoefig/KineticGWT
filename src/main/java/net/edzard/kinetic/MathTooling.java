package net.edzard.kinetic;

import java.util.List;

/**
 * Math and Physics tooling.
 * @author Ed
 */
public class MathTooling {
	
	/** Epsilon region for matching very close points*/
	public static final double epsilon = 0.001;
	
	/**
	 * Calculate point of intersection between two line segments.
	 * This is precise, but a bit slow.
	 * Originally implemented by Marius Watz
	 * @param ls1Start First line segment, start point
	 * @param ls1End First line segment, end point
	 * @param ls2Start Second line segment, start point
	 * @param ls2End Second line segment, end point
	 * @return A vector to the point of intersection, or null if lines are parallel, 
	 * collinear, or segments not overlapping.
	 */
	public static final Vector2d intersectLineSegmentWithLineSegment(final Vector2d ls1Start, 
			final Vector2d ls1End, final Vector2d ls2Start, final Vector2d ls2End) {
		
	  double xD1,yD1,xD2,yD2,xD3,yD3;
	  double dot,deg,len1,len2;
	  double segmentLen1,segmentLen2;
	  double ua,div;//,ub;

	  // calculate differences
	  xD1=ls1End.x-ls1Start.x;
	  xD2=ls2End.x-ls2Start.x;
	  yD1=ls1End.y-ls1Start.y;
	  yD2=ls2End.y-ls2Start.y;
	  xD3=ls1Start.x-ls2Start.x;
	  yD3=ls1Start.y-ls2Start.y;  

	  // calculate the lengths of the two lines
	  len1=Math.sqrt(xD1*xD1+yD1*yD1);
	  len2=Math.sqrt(xD2*xD2+yD2*yD2);

	  // calculate angle between the two lines.
	  dot=(xD1*xD2+yD1*yD2); // dot product
	  deg=dot/(len1*len2);

	  // if abs(angle)==1 then the lines are parallell,
	  // so no intersection is possible
	  if(Math.abs(deg)==1) return null;

	  // find intersection Pt between two lines
	  Vector2d pt=new Vector2d(0,0);
	  div=yD2*xD1-xD2*yD1;
	  ua=(xD2*yD3-yD2*xD3)/div;
	  //ub=(xD1*yD3-yD1*xD3)/div;
	  pt.x=ls1Start.x+ua*xD1;
	  pt.y=ls1Start.y+ua*yD1;

	  // calculate the combined length of the two segments
	  // between Pt-p1 and Pt-p2
	  xD1=pt.x-ls1Start.x;
	  xD2=pt.x-ls1End.x;
	  yD1=pt.y-ls1Start.y;
	  yD2=pt.y-ls1End.y;
	  segmentLen1=Math.sqrt(xD1*xD1+yD1*yD1)+Math.sqrt(xD2*xD2+yD2*yD2);

	  // calculate the combined length of the two segments
	  // between Pt-p3 and Pt-p4
	  xD1=pt.x-ls2Start.x;
	  xD2=pt.x-ls2End.x;
	  yD1=pt.y-ls2Start.y;
	  yD2=pt.y-ls2End.y;
	  segmentLen2=Math.sqrt(xD1*xD1+yD1*yD1)+Math.sqrt(xD2*xD2+yD2*yD2);

	  // if the lengths of both sets of segments are the same as
	  // the lenghts of the two lines the point is actually
	  // on the line segment.

	  // if the point isnt on the line, return null
	  if(Math.abs(len1-segmentLen1)>0.01 || Math.abs(len2-segmentLen2)>0.01)
	    return null;

	  // return the valid intersection
	  return pt;
	}
	
	/**
	 * Calculate intersection of a circle and a line segment.
	 * The line segment has to start at the circle's midpopint.
	 * @param start Start point of line segment, same as circle midpoint
	 * @param end End point of line segment
	 * @param radius radius of circle
	 * @return Either a vector (point of intersection), or null (no intersection at all - the end point is within the radius of the circle).
	 */
	public static final Vector2d intersectLineSegmentStartingFromCircleMidPointWithCircle(final Vector2d start, 
			final Vector2d end, final double radius) {	
		final Vector2d dp = new Vector2d(end.x - start.x, end.y - start.y);
		final double a = dp.x * dp.x + dp.y * dp.y;
		final double mu = (Math.sqrt(4 * a * radius * radius)) / (2 * a);
		return mu <= 1? new Vector2d(start.x + mu * dp.x, start.y + mu * dp.y) : null;
	}
	
	/**
	 * Calculate intersection of a circle and a line segment.
	 * @param start Start point of line segment
	 * @param end End point of line segment
	 * @param midPoint center of circle
	 * @param radius radius of circle
	 * @return Either two vectors (line segment is intersecting circle in two places),
	 * one vector (line segment intersects in one place), no vectors (line segment does not
	 * intersect circle, but line through points does), or null (no intersection at all).
	 */
	public static final Vector2d[] intersectLineSegmentWithCircle(final Vector2d start, 
			final Vector2d end, final Vector2d midPoint, final double radius) {	
		
		final Vector2d dp = new Vector2d(end.x - start.x, end.y - start.y);
		   
		final double a = dp.x * dp.x + dp.y * dp.y;
		final double b = 2 * (dp.x * (start.x - midPoint.x) + dp.y * (start.y - midPoint.y));
		double c = midPoint.x * midPoint.x + midPoint.y * midPoint.y;
		c += start.x * start.x + start.y * start.y;
		c -= 2 * (midPoint.x * start.x + midPoint.y * start.y);
		c -= radius * radius;
		double bb4ac = b * b - 4 * a * c;
	
		// Don't intersect
		if (Math.abs(a) < epsilon || bb4ac < 0) 
		   return null;
	
		double mu1 = (-b + Math.sqrt(bb4ac)) / (2 * a);
		double mu2 = (-b - Math.sqrt(bb4ac)) / (2 * a);
	   
		// Check if intersections are on line segment
		if (mu1 > 0 && mu1 <= 1) {
			if (mu2 > 0 && mu2 <= 1) {
				// Both are on the line segment
				Vector2d[] result = new Vector2d[2];
				result[0] = new Vector2d(start.x + mu1 * dp.x, start.y + mu1 * dp.y);
				result[1] = new Vector2d(start.x + mu2 * dp.x, start.y + mu2 * dp.y);
				return result;
			} else {
				// mu1 is
				Vector2d[] result = new Vector2d[1];
				result[0] = new Vector2d(start.x + mu1 * dp.x, start.y + mu1 * dp.y);
				return result;				
			}
		} else {
			if (mu2 > 0 && mu2 <= 1) {
				// mu2 is
				Vector2d[] result = new Vector2d[1];
				result[0] = new Vector2d(start.x + mu2 * dp.x, start.y + mu2 * dp.y);
				return result;	
			} else {
				// None are
				return new Vector2d[0];
			}
		}
	}
	
	/**
	 * Checks if a point is very close to any of other points in a given list.
	 * Useful for dealing with numerical imprecision.
	 * @param points The points to check against each
	 * @param point The point that will be checked
	 * @return
	 */
	public static final boolean pointExistsWithinEpsilon(final List<Vector2d> points, 
			final Vector2d point) {
		for (Vector2d vExistent: points)
			if ((Math.abs(vExistent.x - point.x) < epsilon) && 
				(Math.abs(vExistent.y - point.y) < epsilon))
				return true;
		return false;
	}

	public static boolean isPointInCircle(Vector2d point, Vector2d circleCenter, double circleRadius) {
		return (point.distanceTo(circleCenter) < circleRadius);
	}
	

//	/**
//	 * Stores a line segment showing the collision
//	 * surface between two convex polygons
//	 * @author Ed
//	 */
//	public static class Collision {
//		
//		/** Position of first intersection */
//		private Vector2d startLine;
//		
//		/** Position of second intersection */
//		private Vector2d endLine;
//		
//		/** Calculated surface normal */
//		private Vector2d normal;
//		
//		/** Penetration depth of overlapping areas */
//		private double penetration;
//		
//		/** Indicates that there is an unusual overlap (1 or more than two points) */
//		private boolean unusual;
//		
//		/**
//		 * Parametrized Ctor.
//		 * @param start First intersection point
//		 * @param end Second intersection point
//		 */
//		public Collision(final Vector2d start, final Vector2d end) {
//			
//			// Use other constructor
//			this(start, end, false);
//			
//			// Make collision surface normal
//			normal.set(normal.y, -normal.x);
//		}
//		
//		/**
//		 * Parametrized Ctor.
//		 * @param start a position
//		 * @param end a position
//		 * @param unusual indicates if this is a normal or unusual collision
//		 */
//		public Collision(Vector2d start, Vector2d end, boolean unusual) {
//			
//			this.unusual = unusual;
//			
//			// Store collision surface line
//			this.startLine = start;
//			this.endLine = end;
//			
//			// Calculated later
//			penetration = 0;
//			
//			// Set normal
//			this.normal = new Vector2d(end);
//			normal.sub(start);
//			normal.normalize();
//		}
//
//		/**
//		 * Store a penetration depth.
//		 * @param amount The value to store
//		 */
//		public void setPenetration(final double amount) {
//			this.penetration = amount;
//		}
//
//		/**
//		 * Retrieve first intersection point.
//		 * @return a point in world coordinates
//		 */
//		public Vector2d getStartLine() {
//			return startLine;
//		}
//
//		/**
//		 * Retrieve second intersection point.
//		 * @return a point in world coordinates
//		 */
//		public Vector2d getEndLine() {
//			return endLine;
//		}
//
//		/**
//		 * Retrieve collision surface normal.
//		 * @return A unit vector in world coordinates
//		 */
//		public Vector2d getNormal() {
//			return normal;
//		}
//
//		/**
//		 * Retrieve penetration depth.
//		 * @return The depth
//		 */
//		public double getPenetration() {
//			return penetration;
//		}
//		
//		/**
//		 * Retrieve projection vector for a position.
//		 * The projection vector can be added to a sprite at the given position
//		 * to move it out of the collision area. 
//		 * @param position A sprite position (used to determine orientation of
//		 * projection vector)
//		 * @return A projection vector
//		 */
//		public Vector2d getProjectionVector(final Vector2d position) {
//			// Check for orientation
//			final double posPrj = position.x * normal.x + position.y * normal.y;
//			final double colPrj = startLine.x * normal.x + startLine.y * normal.y;
//			Vector2d result = (posPrj > colPrj)? new Vector2d(normal) : new Vector2d(-normal.x, -normal.y);
//			// Apply penetration depth
//			result.scale(penetration);
//			return result;
//		}
//		
//		/**
//		 * Moves the shapes position outside of collision area.
//		 * @param shape The shape to move
//		 */
//		public void project(final Shape shape) {
//			final Vector2d pos = shape.getPosition();
//			final Vector2d v = getProjectionVector(pos);
//			shape.setPosition(pos.x + v.x, pos.y + v.y);	
//		}
//		
//		public boolean isUnusual() {
//			return this.unusual;
//		}
//		
//	}
//	
//	/**
//	 * An error during a collision calculation needs to be reported
//	 * @author Edzard Hoefig
//	 */
//	public static class CollisionException extends RuntimeException {
//
//		/**
//		 * Ctor.
//		 * @param msg A message
//		 */
//		public CollisionException(String msg) {
//			super(msg);
//		}
//
//		/** Serialization support */
//		private static final long serialVersionUID = -7628449722702005943L;
//	}

	 	
	
	/**
	 * Calculates all line segment intersections between the bounding polygons 
	 * of shape a and b. Useful for collision detection.
	 * @param a The first shape to overlap
	 * @param b The second shape to overlap
	 * @return A list of intersection points of the bounding line segments 
	 * of the two sprites. 
	 */
	/*
	public static final List<Vector2d> getIntersections(
			final CollidingShapeSprite a, 
			final CollidingShapeSprite b) {
		
		// Test line segments of bounds against each other to determine intersections
		List<Vector2d> result = new ArrayList<Vector2d>();
	
		final List<Vector2d> aBounds = a.getBounds();
		final List<Vector2d> bBounds = a.getBounds();
		
		// Loop through all "a" line segments and test against each "b" line segment
		for (int j=0; j < aBounds.size(); ++j) {
			for (int i=0; i < bBounds.size(); ++ i) {
				
				// Check for intersection of line segments in world coordinates
				// Last point of a bounding polygon is automatically connected to first one
				final Vector2d v = intersectLineSegmentWithLineSegment(
					a.transformToWorld(aBounds.get(j)), 
					a.transformToWorld((j+1 == aBounds.size())? 
						aBounds.get(0) : aBounds.get(j+1)), 
					b.transformToWorld(bBounds.get(i)), 
					b.transformToWorld((i+1 == bBounds.size())?
						bBounds.get(0) : bBounds.get(i+1))
				);
				
				// Store intersection result
				if ((v != null) && (!pointExistsWithinEpsilon(result, v))) 
					result.add(v);
			}
		}
		
		// Finished
		return result;
	}
	*/
	
	/**
	 * Retrieve all intersections between a bounding shape polygon and a circle. 
	 * @param a The circle sprite
	 * @param b The shape sprite
	 * @return A list of intersection points
	 */
	/*
	public static final List<Vector2d> getIntersections(
			final CollidingCircleSprite a, 
			final CollidingShapeSprite b) {
		
		// The result
		List<Vector2d> result = new ArrayList<Vector2d>();
		
		// Loop through all "b" line segments and test against "a" circle
		final List<Vector2d> bounds = b.getBounds();
		for (int i=0; i < bounds.size(); ++i) {
			
			// Intersect line with circle
			Vector2d[] intersection =intersectLineSegmentWithCircle(
				   b.transformToWorld(bounds.get(i)),
				   b.transformToWorld((i+1 == bounds.size())? bounds.get(0) : bounds.get(i+1)),
				   a.position(), a.getRadius());
		   
			// Are there any intersections?
			if (intersection != null) {
				// line is intersecting
				if (intersection.length >= 1) result.add(intersection[0]); // one point in line segment
				if (intersection.length == 2) result.add(intersection[1]); // two points in line segment
			}
		}
		
		// Finished
		return result;
	}
	*/
	
	/**
	 * Retrieve nearest intersections between a line and a circle.
	 * @param line The line (only first two points are taken into account)
	 * @param circle The circle 
	 * @return the nearest intersection point
	 */
	/*
	public static final Vector2d getNearestIntersection(final Vector2d start, final Vector2d end, final Vector2d circlePos, final double radius) {
		
		// The result
		//final Vector2d start = line.getStart();
		//Vector2d end = new Vector2d(line.getEnd());
		Vector2d result = null;
			
		final Vector2d[] v = MathTooling.intersectLineSegmentWithCircle(start, end, circlePos, radius);
		if (v == null) return null;
		
		switch (v.length) {
		case 2:
			if (distance(start, v[1]) < distance(start, end)) result = v[1];
		case 1:
			if (distance(start, v[0]) < distance(start, end)) result = v[0];
		default:
			return result;
		}
	}
	*/
	
	/**
	 * Calculates the collision surface of a circle and a  shape sprite.
	 * This will only work properly if the bounding shape is convex and overlaps in not more
	 * than two points (intersections of bounding line segments)
	 * @param a Circle to collide
	 * @param b A shape to collide
	 * @return A collision data structure, or null if no collision took place
	 * @throws CollisionException If there are more than three collision points
	 */
	/*
	public static final Collision getCollisionSurface(
			final CollidingSprite a, final CollidingSprite b){
		
		// Intersect the shapes (by type)
		List<Vector2d> intersections = null;
		if (b instanceof CollidingShapeSprite) { 
			if (a instanceof CollidingCircleSprite) {
				intersections = getIntersections((CollidingCircleSprite)a,(CollidingShapeSprite)b);
			} else if (a instanceof CollidingShapeSprite) {
				intersections = getIntersections((CollidingShapeSprite)a,(CollidingShapeSprite)b);
			} else {
				// Failure
				throw new CollisionException("Cannot handle collision between " +
						a.getClass().getSimpleName() + " and shape sprite");
			}
		} else {
			// Failure
			throw new CollisionException("Cannot handle collision between " +
					a.getClass().getSimpleName() + " and " + b.getClass().getSimpleName());
		}
		 
		// Did not intersect
		// TODO: handle the case where one sprite is completely inside the other
		if (intersections.isEmpty()) return null;
		
		// Did intersect?
		final Collision collision = (intersections.size() != 2)?
			new Collision(a.position(), b.position(), true) :	// approx. with positions
			new Collision(intersections.get(0), intersections.get(1)); // yep
		
		// Calculate penetration depth (overlapping along collision normal axis)
		final Projection aPrj = a.project(collision.getNormal());
		final Projection bPrj = b.project(collision.getNormal());
		final double penetration = aPrj.min < bPrj.min? bPrj.min - aPrj.max : aPrj.min - bPrj.max;
		collision.setPenetration(-penetration); // overlapping is always negative -> invert
		
		// Finished
		return collision;
	}
	*/
	
	/**
	 * Elastic collision between two shape sprites with a given collision surface normal.
	 * Re-calculates sprite particle velocities.  
	 * @param a One sprite
	 * @param b The other sprite
	 * @param normal The collision surface normal
	 */
	/*
	public static final void elasticCollision(final PhysicalSprite a, 
			final PhysicalSprite b, final Vector2d normal) {
		
		// Get unit tangential vector for collision surface		 
		Vector2d tangent = new Vector2d(-normal.y, normal.x);

		// Calculate normal and tangential components of velocities	
		final Vector2d va = a.velocity();
		final Vector2d vb = b.velocity();
		final double van = normal.dot(va);
		final double vat = tangent.dot(va);
		final double vbn = normal.dot(vb);
		final double vbt = tangent.dot(vb);
		
		// Calculate velocities after collision
		final double m1 = a.particle().mass();
		final double m2 = b.particle().mass();
		final double van_ = (van * (m1 - m2) + 2 * m2 * vbn) / (m1 + m2);
		final double vbn_ = (vbn * (m2 - m1) + 2 * m1 * van) / (m1 + m2);

		// Set new particle velocities
		final double tx = tangent.x * (a.friction() + b.friction()) / 2;
		final double ty = tangent.y * (a.friction() + b.friction()) / 2;
		final double nx = normal.x * (a.bounce() + b.bounce()) / 2;
		final double ny = normal.y * (a.bounce() + b.bounce()) / 2;
		a.particle().setVelocity(van_ * nx + vat * tx, van_ * ny + vat * ty, 0);
		b.particle().setVelocity(vbn_ * nx + vbt * tx, vbn_ * ny + vbt * ty, 0);
	}
	*/
	
	/**
	 * Draws a vector as an arrow.
	 * @param surface The processing applet to use for drawing
	 * @param o The origin where the arrow should start
	 * @param v The vector that the arrow should represent
	 * @param colour The arrow's colour
	 */
	/*
	public static final void drawVector(final PApplet surface, final Vector2d o, final Vector2d v, final Colour colour) {
		surface.stroke(colour.opaque());
		surface.strokeWeight(1);
		surface.line(o.x, o.y, o.x + v.x, o.y + v.y);
		// TODO: Draw an arrow tip
	}
	*/
	/**
	 * Returns a random number between 0 and high.
	 * @param high the upper limit (never included)
	 * @return a random number
	 */
//	public static final double random(final double high) {
//		return (double)(Math.random() * high);
//	}
	
	/**
	 * Returns a random number between low and high.
	 * @param low the lower limit (may be included)
	 * @param high the upper limit (never included) (needs to be above low)
	 * @return a random number
	 */
//	public static final double random(final double low, final double high) {
//		double difference = high - low;
//		return low + (double)(Math.random() * difference);
//	}
}
