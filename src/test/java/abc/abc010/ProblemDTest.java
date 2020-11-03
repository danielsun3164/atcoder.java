package abc.abc010;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("4 2 3\n" + "2 3\n" + "0 1\n" + "1 2\n" + "1 3", "1");
	}

	@Test
	void case2() {
		check("4 1 4\n" + "3\n" + "0 1\n" + "0 2\n" + "1 3\n" + "2 3", "1");
	}

	@Test
	void case3() {
		check("10 3 11\n" + "7 8 9\n" + "0 1\n" + "0 2\n" + "0 3\n" + "0 4\n" + "1 5\n" + "2 5\n" + "5 6\n" + "6 7\n"
				+ "6 8\n" + "3 9\n" + "4 9", "2");
	}

	@Test
	void case4() {
		check("6 2 6\n" + "4 5\n" + "0 1\n" + "0 2\n" + "1 3\n" + "2 3\n" + "3 4\n" + "3 5", "2");
	}

	@Test
	void case5() {
		check("4 3 3\n" + "1 2 3\n" + "1 2\n" + "1 3\n" + "2 3", "0");
	}
}
