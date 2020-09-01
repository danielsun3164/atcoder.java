package abc.abc021;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("10\n" + "2", "55");
	}

	@Test
	void case2() {
		check("10\n" + "3", "220");
	}

	@Test
	void case3() {
		check("10\n" + "4", "715");
	}

	@Test
	void case4() {
		check("400\n" + "296", "546898535");
	}

	@Test
	void case5() {
		check("100000\n" + "100000", "939733670");
	}
}
