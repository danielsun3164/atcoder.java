package abc.abc014;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("5\n" + "1 2\n" + "1 3\n" + "1 4\n" + "4 5\n" + "3\n" + "2 3\n" + "2 5\n" + "2 4",
				"3" + LF + "4" + LF + "3");
	}

	@Test
	void case2() {
		check("6\n" + "1 2\n" + "2 3\n" + "3 4\n" + "4 5\n" + "5 6\n" + "4\n" + "1 3\n" + "1 4\n" + "1 5\n" + "1 6",
				"3" + LF + "4" + LF + "5" + LF + "6");
	}

	@Test
	void case3() {
		check("7\n" + "3 1\n" + "2 1\n" + "2 4\n" + "2 5\n" + "3 6\n" + "3 7\n" + "5\n" + "4 5\n" + "1 6\n" + "5 6\n"
				+ "4 7\n" + "5 3", "3" + LF + "3" + LF + "5" + LF + "5" + LF + "4");
	}
}
