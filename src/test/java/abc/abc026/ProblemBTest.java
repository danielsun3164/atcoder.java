package abc.abc026;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	/** 誤差 */
	private static final double TOLERANCE = 0.000001d;

	@Test
	void case1() {
		checkResultIsAbout("3\n" + "1\n" + "2\n" + "3", 18.8495559215d, TOLERANCE);
	}

	@Test
	void case2() {
		checkResultIsAbout("6\n" + "15\n" + "2\n" + "3\n" + "7\n" + "6\n" + "9", 508.938009881546d, 0.000001d);
	}
}
