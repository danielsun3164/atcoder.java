package abc.abc151_200.abc154;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	/** 誤差 */
	private static final double TOLERANCE = 1E-6d;

	@Test
	void case1() {
		checkResultIsAbout("5 3\n" + "1 2 2 4 5", 7.0d, TOLERANCE);
	}

	@Test
	void case2() {
		checkResultIsAbout("4 1\n" + "6 6 6 6", 3.5d, TOLERANCE);
	}

	@Test
	void case3() {
		checkResultIsAbout("10 4\n" + "17 13 13 12 15 20 10 13 17 11", 32.0d, TOLERANCE);
	}
}
