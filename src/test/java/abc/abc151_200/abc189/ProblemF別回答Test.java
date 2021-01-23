package abc.abc151_200.abc189;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemF別回答Test extends TestBase {

	/** 誤差 */
	private static final double TOLERANCE = 1E-3d;

	@Test
	void case1() {
		checkResultIsAbout("2 2 0\n" + "", 1.5d, TOLERANCE);
	}

	@Test
	void case2() {
		checkResultIsAbout("2 2 1\n" + "1", 2.0d, TOLERANCE);
	}

	@Test
	void case3() {
		check("100 6 10\n" + "11 12 13 14 15 16 17 18 19 20", "-1");
	}

	@Test
	void case4() {
		checkResultIsAbout("100000 2 2\n" + "2997 92458", 201932.2222d, TOLERANCE);
	}
}
