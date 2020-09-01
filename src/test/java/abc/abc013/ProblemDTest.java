package abc.abc013;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("5 7 1\n" + "1 4 3 4 2 3 1", "4" + LF + "2" + LF + "5" + LF + "3" + LF + "1");
	}

	@Test
	void case2() {
		check("5 7 2\n" + "1 4 3 4 2 3 1", "3" + LF + "2" + LF + "1" + LF + "5" + LF + "4");
	}

	@Test
	void case3() {
		check("10 20 300\n" + "9 1 2 5 8 1 9 3 5 6 4 5 4 6 8 3 2 7 9 6", "3" + LF + "7" + LF + "2" + LF + "4" + LF + "5"
				+ LF + "9" + LF + "6" + LF + "1" + LF + "8" + LF + "10");
	}
}
