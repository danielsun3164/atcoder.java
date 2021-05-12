package abc.abc101_150.abc146;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "1 2\n" + "2 3", "2" + LF + "1" + LF + "2");
	}

	@Test
	void case2() {
		check("8\n" + "1 2\n" + "2 3\n" + "2 4\n" + "2 5\n" + "4 7\n" + "5 6\n" + "6 8",
				"4" + LF + "1" + LF + "2" + LF + "3" + LF + "4" + LF + "1" + LF + "1" + LF + "2");
	}

	@Test
	void case3() {
		check("6\n" + "1 2\n" + "1 3\n" + "1 4\n" + "1 5\n" + "1 6",
				"5" + LF + "1" + LF + "2" + LF + "3" + LF + "4" + LF + "5");
	}
}
