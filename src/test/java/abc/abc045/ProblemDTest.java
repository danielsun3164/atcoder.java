package abc.abc045;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("4 5 8\n" + "1 1\n" + "1 4\n" + "1 5\n" + "2 3\n" + "3 1\n" + "3 2\n" + "3 4\n" + "4 4",
				"0" + LF + "0" + LF + "0" + LF + "2" + LF + "4" + LF + "0" + LF + "0" + LF + "0" + LF + "0" + LF + "0");
	}

	@Test
	void case2() {
		check("10 10 20\n" + "1 1\n" + "1 4\n" + "1 9\n" + "2 5\n" + "3 10\n" + "4 2\n" + "4 7\n" + "5 9\n" + "6 4\n"
				+ "6 6\n" + "6 7\n" + "7 1\n" + "7 3\n" + "7 7\n" + "8 1\n" + "8 5\n" + "8 10\n" + "9 2\n" + "10 4\n"
				+ "10 9",
				"4" + LF + "26" + LF + "22" + LF + "10" + LF + "2" + LF + "0" + LF + "0" + LF + "0" + LF + "0" + LF
						+ "0");
	}
}
