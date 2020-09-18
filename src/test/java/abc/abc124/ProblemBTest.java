package abc.abc124;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("4\n" + "6 5 6 8", "3");
	}

	@Test
	void case2() {
		check("5\n" + "4 5 3 5 4", "3");
	}

	@Test
	void case3() {
		check("5\n" + "9 5 6 8 4", "1");
	}
}
