package abc.abc094;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("5 3 3\n" + "1 2 4", "1");
	}

	@Test
	void case2() {
		check("7 3 2\n" + "4 5 6", "0");
	}

	@Test
	void case3() {
		check("10 7 5\n" + "1 2 3 4 6 8 9", "3");
	}
}
