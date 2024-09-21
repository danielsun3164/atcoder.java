package other.math_and_algorithm;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class Problem025Test extends TestBase {

	/** 誤差 */
	private static final double TOLERANCE = 1E-3d;

	@Test
	void case1() {
		checkResultIsAbout("5\n" + "3 1 4 1 5\n" + "9 2 6 5 3", 21.333333333333d, TOLERANCE);
	}
}
