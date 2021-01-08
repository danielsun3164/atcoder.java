package abc.abc151_200.abc187;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("5\n" + "1 2\n" + "2 3\n" + "2 4\n" + "4 5\n" + "4\n" + "1 1 1\n" + "1 4 10\n" + "2 1 100\n" + "2 2 1000",
				"11" + LF + "110" + LF + "1110" + LF + "110" + LF + "100");
	}

	@Test
	void case2() {
		check("7\n" + "2 1\n" + "2 3\n" + "4 2\n" + "4 5\n" + "6 1\n" + "3 7\n" + "7\n" + "2 2 1\n" + "1 3 2\n"
				+ "2 2 4\n" + "1 6 8\n" + "1 3 16\n" + "2 4 32\n" + "2 1 64",
				"72" + LF + "8" + LF + "13" + LF + "26" + LF + "58" + LF + "72" + LF + "5");
	}

	@Test
	void case3() {
		check("11\n" + "2 1\n" + "1 3\n" + "3 4\n" + "5 2\n" + "1 6\n" + "1 7\n" + "5 8\n" + "3 9\n" + "3 10\n"
				+ "11 4\n" + "10\n" + "2 6 688\n" + "1 10 856\n" + "1 8 680\n" + "1 8 182\n" + "2 2 452\n" + "2 4 183\n"
				+ "2 6 518\n" + "1 3 612\n" + "2 6 339\n" + "2 3 206",
				"1657" + LF + "1657" + LF + "2109" + LF + "1703" + LF + "1474" + LF + "1657" + LF + "3202" + LF + "1474"
						+ LF + "1247" + LF + "2109" + LF + "2559");
	}
}
