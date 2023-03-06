package other.past201912_open;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemKTest extends TestBase {

	@Test
	void case1() {
		check("7\n" + "-1\n" + "1\n" + "1\n" + "2\n" + "2\n" + "3\n" + "3\n" + "6\n" + "7 1\n" + "4 1\n" + "2 3\n"
				+ "5 1\n" + "5 2\n" + "2 5", "Yes" + LF + "Yes" + LF + "No" + LF + "Yes" + LF + "Yes" + LF + "No");
	}

	@Test
	void case2() {
		check("20\n" + "4\n" + "11\n" + "12\n" + "-1\n" + "1\n" + "13\n" + "13\n" + "4\n" + "6\n" + "20\n" + "1\n"
				+ "1\n" + "20\n" + "10\n" + "8\n" + "8\n" + "20\n" + "10\n" + "18\n" + "1\n" + "20\n" + "18 14\n"
				+ "11 3\n" + "2 13\n" + "13 11\n" + "10 15\n" + "9 5\n" + "17 11\n" + "18 10\n" + "1 16\n" + "9 4\n"
				+ "19 6\n" + "5 10\n" + "17 8\n" + "15 8\n" + "5 16\n" + "6 20\n" + "3 19\n" + "10 12\n" + "5 13\n"
				+ "18 1",
				"No" + LF + "No" + LF + "No" + LF + "No" + LF + "No" + LF + "No" + LF + "No" + LF + "Yes" + LF + "No"
						+ LF + "Yes" + LF + "No" + LF + "No" + LF + "No" + LF + "Yes" + LF + "No" + LF + "Yes" + LF
						+ "No" + LF + "No" + LF + "No" + LF + "Yes");
	}
}
