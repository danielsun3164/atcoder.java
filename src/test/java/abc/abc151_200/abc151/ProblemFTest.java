package abc.abc151_200.abc151;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	/** 誤差 */
	private static final double TOLERANCE = 1E-6d;

	@Test
	void case1() {
		checkResultIsAbout("2\n" + "0 0\n" + "1 0", 0.5d, TOLERANCE);
	}

	@Test
	void case2() {
		checkResultIsAbout("3\n" + "0 0\n" + "0 1\n" + "1 0", 0.707106781186497524d, TOLERANCE);
	}

	@Test
	void case3() {
		checkResultIsAbout("10\n" + "10 9\n" + "5 9\n" + "2 0\n" + "0 0\n" + "2 7\n" + "3 3\n" + "2 5\n" + "10 0\n"
				+ "3 7\n" + "1 9", 6.726812023536805158d, TOLERANCE);
	}
}
