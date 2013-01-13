package net.edzard.kinetic.test;

import com.google.gwt.junit.tools.GWTTestSuite;

import junit.framework.Test;
import junit.framework.TestCase;

/**
 * @see http://mojo.codehaus.org/gwt-maven-plugin/user-guide/testing.html
 * @author maik
 *
 */
public class GwtTestSuite extends TestCase {

	public static Test suite() {
		GWTTestSuite suite = new GWTTestSuite();
		suite.addTestSuite(AnimationTestGwt.class);
		suite.addTestSuite(NodeTestGwt.class);
		suite.addTestSuite(StageTestGwt.class);
		suite.addTestSuite(EllipseTestGwt.class);
//		suite.addTestSuite(TextTestGwt.class);
		return suite;
	}
	
}
