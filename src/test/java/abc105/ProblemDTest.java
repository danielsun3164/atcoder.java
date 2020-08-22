package abc105;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("3 2\n" + "4 1 5", "3");
	}

	@Test
	void case2() {
		check("13 17\n" + "29 7 5 7 9 51 7 13 8 55 42 9 81", "6");
	}

	@Test
	void case3() {
		check("10 400000000\n"
				+ "1000000000 1000000000 1000000000 1000000000 1000000000 1000000000 1000000000 1000000000 1000000000 1000000000",
				"25");
	}
}
