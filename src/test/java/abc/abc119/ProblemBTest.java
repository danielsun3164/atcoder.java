package abc.abc119;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	/** 誤差 */
	private static final double TOLERANCE = 0.00001d;

	@Test
	void case1() {
		checkResultIsAbout("2\n" + "10000 JPY\n" + "0.10000000 BTC", 48000.0d, TOLERANCE);
	}

	@Test
	void case2() {
		checkResultIsAbout("3\n" + "100000000 JPY\n" + "100.00000000 BTC\n" + "0.00000001 BTC", 138000000.0038d,
				TOLERANCE);
	}
}
