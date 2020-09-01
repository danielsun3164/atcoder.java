package abc.abc008;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("6 4\n" + "3\n" + "2 4\n" + "3 1\n" + "4 3", "19");
	}

	@Test
	void case2() {
		check("3 3\n" + "3\n" + "1 1\n" + "2 3\n" + "3 2", "9");
	}

	@Test
	void case3() {
		check("15 10\n" + "8\n" + "7 10\n" + "12 8\n" + "4 4\n" + "5 7\n" + "9 9\n" + "1 6\n" + "6 5\n" + "3 2", "112");
	}
}
