package abc.abc101_150.abc144;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemD別回答Test extends TestBase {

	/** 誤差 */
	private static final double TOLERANCE = 1E-6d;

	@Test
	void case1() {
		check("2 2 4", 45.0d);
	}

	@Test
	void case2() {
		checkResultIsAbout("12 21 10", 89.7834636934d, TOLERANCE);
	}

	@Test
	void case3() {
		checkResultIsAbout("3 1 8", 4.2363947991d, TOLERANCE);
	}
}
