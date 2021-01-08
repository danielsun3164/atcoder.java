package abc.abc151_200.abc184;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	/** 誤差 */
	private static final double TOLERANCE = 1E-6d;

	@Test
	void case1() {
		checkResultIsAbout("99 99 99", 1.0d, TOLERANCE);
	}

	@Test
	void case2() {
		checkResultIsAbout("98 99 99", 1.331081081d, TOLERANCE);
	}

	@Test
	void case3() {
		checkResultIsAbout("0 0 1", 99.0d, TOLERANCE);
	}

	@Test
	void case4() {
		checkResultIsAbout("31 41 59", 91.835008202d, TOLERANCE);
	}
}
