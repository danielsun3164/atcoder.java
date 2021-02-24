package abc.abc101_150.abc138;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	/** 誤差 */
	private static final double TOLERANCE = 10E-5d;

	@Test
	void case1() {
		checkResultIsAbout("2\n" + "10 30", 7.5d, TOLERANCE);
	}

	@Test
	void case2() {
		checkResultIsAbout("3\n" + "200 200 200", 66.66666666666667d, TOLERANCE);
	}

	@Test
	void case3() {
		check("1\n" + "1000", 1000.0d);
	}
}
