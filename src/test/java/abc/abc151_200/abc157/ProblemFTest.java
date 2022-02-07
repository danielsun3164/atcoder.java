package abc.abc151_200.abc157;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	/** 誤差 */
	private static final double TOLERANCE = 1E-6;

	@Test
	void case1() {
		checkResultIsAbout("4 3\n" + "-1 0 3\n" + "0 0 3\n" + "1 0 2\n" + "1 1 40", 2.4d, TOLERANCE);
	}

	@Test
	void case2() {
		checkResultIsAbout(
				"10 5\n" + "-879 981 26\n" + "890 -406 81\n" + "512 859 97\n" + "362 -955 25\n" + "128 553 17\n"
						+ "-885 763 2\n" + "449 310 57\n" + "-656 -204 11\n" + "-270 76 40\n" + "184 170 16",
				7411.225279d, TOLERANCE);
	}
}
