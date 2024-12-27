package other.math_and_algorithm;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class Problem033Test extends TestBase {

	/** 誤差 */
	private static final double TOLERANCE = 1E-6d;

	@Test
	void case1() {
		checkResultIsAbout("0 5\n" + "1 1\n" + "3 0", 4.123105625618d, TOLERANCE);
	}

	@Test
	void case2() {
		checkResultIsAbout("-40 -30\n" + "-50 -10\n" + "-20 -20", 15.811388300842d, TOLERANCE);
	}

	@Test
	void case3() {
		checkResultIsAbout("1000000000 1000000000\n" + "-1000000000 -1000000000\n" + "0 -1000000000",
				2236067977.499789714813d, TOLERANCE);
	}
}
