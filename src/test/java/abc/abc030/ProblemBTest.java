package abc.abc030;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	/** 誤差 */
	private static final double TORELANCE = 0.0001d;

	@Test
	void case1() {
		checkResultIsAbout("15 0", 90d, TORELANCE);
	}

	@Test
	void case2() {
		checkResultIsAbout("3 17", 3.5d, TORELANCE);
	}

	@Test
	void case3() {
		checkResultIsAbout("0 0", 0d, TORELANCE);
	}

	@Test
	void case4() {
		checkResultIsAbout("6 0", 180d, TORELANCE);
	}

	@Test
	void case5() {
		checkResultIsAbout("23 59", 5.5d, TORELANCE);
	}
}
