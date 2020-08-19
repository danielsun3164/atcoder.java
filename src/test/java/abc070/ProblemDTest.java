package abc070;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("5\n" + "1 2 1\n" + "1 3 1\n" + "2 4 1\n" + "3 5 1\n" + "3 1\n" + "2 4\n" + "2 3\n" + "4 5",
				"3" + LF + "2" + LF + "4");
	}

	@Test
	void case2() {
		check("7\n" + "1 2 1\n" + "1 3 3\n" + "1 4 5\n" + "1 5 7\n" + "1 6 9\n" + "1 7 11\n" + "3 2\n" + "1 3\n"
				+ "4 5\n" + "6 7", "5" + LF + "14" + LF + "22");
	}

	@Test
	void case3() {
		check("10\n" + "1 2 1000000000\n" + "2 3 1000000000\n" + "3 4 1000000000\n" + "4 5 1000000000\n"
				+ "5 6 1000000000\n" + "6 7 1000000000\n" + "7 8 1000000000\n" + "8 9 1000000000\n"
				+ "9 10 1000000000\n" + "1 1\n" + "9 10", "17000000000");
	}
}
