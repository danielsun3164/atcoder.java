package abc.abc101_150.abc139;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	/** 誤差 */
	private static final double TOLERANCE = 1E-10d;

	@Test
	void case1() {
		checkResultIsAbout("3\n" + "0 10\n" + "5 -5\n" + "-5 -5", 10.0d, TOLERANCE);
	}

	@Test
	void case2() {
		checkResultIsAbout("5\n" + "1 1\n" + "1 0\n" + "0 1\n" + "-1 0\n" + "0 -1",
				2.828427124746190097603377448419396157139343750753d, TOLERANCE);
	}

	@Test
	void case3() {
		checkResultIsAbout("5\n" + "1 1\n" + "2 2\n" + "3 3\n" + "4 4\n" + "5 5",
				21.213203435596425732025330863145471178545078130654d, TOLERANCE);
	}

	@Test
	void case4() {
		checkResultIsAbout("3\n" + "0 0\n" + "0 1\n" + "1 0", 1.414213562373095048801688724209698078569671875376d,
				TOLERANCE);
	}

	@Test
	void case5() {
		checkResultIsAbout("1\n" + "90447 91000", 128303.0d, TOLERANCE);
	}

	@Test
	void case6() {
		checkResultIsAbout("2\n" + "96000 -72000\n" + "-72000 54000", 120000.0d, TOLERANCE);
	}

	@Test
	void case7() {
		checkResultIsAbout("10\n" + "1 2\n" + "3 4\n" + "5 6\n" + "7 8\n" + "9 10\n" + "11 12\n" + "13 14\n" + "15 16\n"
				+ "17 18\n" + "19 20", 148.660687473185055226120082139313966514489855137208d, TOLERANCE);
	}
}
