package abc.abc097;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("5 2\n" + "5 3 1 4 2\n" + "1 3\n" + "5 4", "2");
	}

	@Test
	void case2() {
		check("3 2\n" + "3 2 1\n" + "1 2\n" + "2 3", "3");
	}

	@Test
	void case3() {
		check("10 8\n" + "5 3 6 8 7 10 9 1 2 4\n" + "3 1\n" + "4 1\n" + "5 9\n" + "2 5\n" + "6 5\n" + "3 5\n" + "8 9\n"
				+ "7 9", "8");
	}

	@Test
	void case4() {
		check("5 1\n" + "1 2 3 4 5\n" + "1 5", "5");
	}
}
