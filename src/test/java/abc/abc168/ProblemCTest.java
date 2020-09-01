package abc.abc168;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	/** 誤差 */
	private static final double TOLERANCE = 0.000000001d;

	@Test
	void case1() {
		checkResultIsAbout("3 4 9 0", 5.0d, TOLERANCE);
	}

	@Test
	void case2() {
		checkResultIsAbout("3 4 10 40", 4.56425719433005567605d, TOLERANCE);
	}
}
