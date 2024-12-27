package other.math_and_algorithm;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class Problem024Test extends TestBase {

	/** 誤差 */
	private static final double TOLERANCE = 1E-6d;

	@Test
	void case1() {
		checkResultIsAbout("2\n" + "2 50\n" + "4 100", 50.0d, TOLERANCE);
	}
}
