package abc.abc002;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("5 3\n" + "1 2\n" + "2 3\n" + "1 3", "3");
	}

	@Test
	void case2() {
		check("5 3\n" + "1 2\n" + "2 3\n" + "3 4", "2");
	}

	@Test
	void case3() {
		check("7 9\n" + "1 2\n" + "1 3\n" + "2 3\n" + "4 5\n" + "4 6\n" + "4 7\n" + "5 6\n" + "5 7\n" + "6 7", "4");
	}

	@Test
	void case4() {
		check("12 0", "1");
	}
}
