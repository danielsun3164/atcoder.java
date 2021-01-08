package abc.abc001_050.abc028;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	/** 誤差 */
	private static final double TOLERANCE = 0.000000001d;

	@Test
	void case1() {
		checkResultIsAbout("3 2", 0.48148148148148148148d, TOLERANCE);
	}

	@Test
	void case2() {
		checkResultIsAbout("3 1", 0.25925925925925925926d, TOLERANCE);
	}

	@Test
	void case3() {
		checkResultIsAbout("765 573", 0.00147697396984624371d, TOLERANCE);
	}
}
