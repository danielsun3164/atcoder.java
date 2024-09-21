package other.math_and_algorithm;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class Problem034別回答Test extends TestBase {

	/** 誤差 */
	private static final double TOLERANCE = 1E-9d;

	@Test
	void case1() {
		checkResultIsAbout("4\n" + "0 1\n" + "2 0\n" + "2 3\n" + "3 1", 1.4142135623730950488016887242d, TOLERANCE);
	}
}
