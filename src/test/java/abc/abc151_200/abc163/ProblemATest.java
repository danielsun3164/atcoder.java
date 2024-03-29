package abc.abc151_200.abc163;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	/** 誤差 */
	private static final double TOLERANCE = 1E-2d;

	@Test
	void case1() {
		checkResultIsAbout("1", 6.283185307179586232d, TOLERANCE);
	}

	@Test
	void case2() {
		checkResultIsAbout("73", 458.67252742410977361942d, TOLERANCE);
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC163/A", TOLERANCE);
	}
}
