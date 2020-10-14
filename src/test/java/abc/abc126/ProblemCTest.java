package abc.abc126;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	/** 誤差 */
	private static final double TOLERANCE = 0.000000001d;

	@Test
	void case1() {
		checkResultIsAbout("3 10", 0.145833333333d, TOLERANCE);
	}

	@Test
	void case2() {
		checkResultIsAbout("100000 5", 0.999973749998d, TOLERANCE);
	}
}
