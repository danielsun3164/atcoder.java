package abc.abc101_150.abc144;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	/** 誤差 */
	private static final double TOLERANCE = 1E-6d;

	@Test
	void case1() {
		checkResultIsAbout("4 6\n" + "1 4\n" + "2 3\n" + "1 3\n" + "1 2\n" + "3 4\n" + "2 4", 1.5d, TOLERANCE);
	}

	@Test
	void case2() {
		checkResultIsAbout("3 2\n" + "1 2\n" + "2 3", 2.0d, TOLERANCE);
	}

	@Test
	void case3() {
		checkResultIsAbout("10 33\n" + "3 7\n" + "5 10\n" + "8 9\n" + "1 10\n" + "4 6\n" + "2 5\n" + "1 7\n" + "6 10\n"
				+ "1 4\n" + "1 3\n" + "8 10\n" + "1 5\n" + "2 6\n" + "6 9\n" + "5 6\n" + "5 8\n" + "3 6\n" + "4 8\n"
				+ "2 7\n" + "2 9\n" + "6 7\n" + "1 2\n" + "5 9\n" + "6 8\n" + "9 10\n" + "3 9\n" + "7 8\n" + "4 5\n"
				+ "2 10\n" + "5 7\n" + "3 5\n" + "4 7\n" + "4 9", 3.0133333333d, TOLERANCE);
	}
}
