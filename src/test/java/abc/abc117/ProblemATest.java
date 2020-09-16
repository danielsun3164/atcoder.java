package abc.abc117;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	/** 誤差 */
	private static final double TOLERANCE = 0.001d;

	@Test
	void case1() {
		checkResultIsAbout("8 3", 2.6666666667d, TOLERANCE);
	}

	@Test
	void case2() {
		checkResultIsAbout("99 1", 99.0d, TOLERANCE);
	}

	@Test
	void case3() {
		checkResultIsAbout("1 100", 0.01d, TOLERANCE);
	}
}
