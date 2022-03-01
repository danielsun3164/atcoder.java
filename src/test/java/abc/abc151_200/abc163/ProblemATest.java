package abc.abc151_200.abc163;

import org.junit.jupiter.api.Test;

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
}
