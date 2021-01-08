package abc.abc151_200.abc183;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	private static final double TOLERANCE = 1E-6d;

	@Test
	void case1() {
		checkResultIsAbout("1 1 7 2", 3.0d, TOLERANCE);
	}

	@Test
	void case2() {
		checkResultIsAbout("1 1 3 2", 1.6666666667d, TOLERANCE);
	}

	@Test
	void case3() {
		checkResultIsAbout("-9 99 -999 9999", -18.7058823529d, TOLERANCE);
	}
}
