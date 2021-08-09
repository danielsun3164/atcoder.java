package abc.abc101_150.abc145;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	/** 誤差 */
	private static final double TOLERANCE = 1E-6d;

	@Test
	void case1() {
		checkResultIsAbout("3\n" + "0 0\n" + "1 0\n" + "0 1", 2.2761423749d, TOLERANCE);
	}

	@Test
	void case2() {
		checkResultIsAbout("2\n" + "-879 981\n" + "-866 890", 91.9238815543d, TOLERANCE);
	}

	@Test
	void case3() {
		checkResultIsAbout("8\n" + "-406 10\n" + "512 859\n" + "494 362\n" + "-955 -475\n" + "128 553\n" + "-986 -885\n"
				+ "763 77\n" + "449 310", 7641.9817824387d, TOLERANCE);
	}
}
