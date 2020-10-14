package abc.abc106;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("2 3 1\n" + "1 1\n" + "1 2\n" + "2 2\n" + "1 2", "3");
	}

	@Test
	void case2() {
		check("10 3 2\n" + "1 5\n" + "2 8\n" + "7 10\n" + "1 7\n" + "3 10", "1" + LF + "1");
	}

	@Test
	void case3() {
		check("10 10 10\n" + "1 6\n" + "2 9\n" + "4 5\n" + "4 7\n" + "4 7\n" + "5 8\n" + "6 6\n" + "6 7\n" + "7 9\n"
				+ "10 10\n" + "1 8\n" + "1 9\n" + "1 10\n" + "2 8\n" + "2 9\n" + "2 10\n" + "3 8\n" + "3 9\n" + "3 10\n"
				+ "1 10",
				"7" + LF + "9" + LF + "10" + LF + "6" + LF + "8" + LF + "9" + LF + "6" + LF + "7" + LF + "8" + LF
						+ "10");
	}
}
