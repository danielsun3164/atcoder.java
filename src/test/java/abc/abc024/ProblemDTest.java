package abc.abc024;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("15\n" + "35\n" + "21", "4 2");
	}

	@Test
	void case2() {
		check("126\n" + "252\n" + "210", "5 4");
	}

	@Test
	void case3() {
		check("144949225\n" + "545897619\n" + "393065978", "314159 365358");
	}
}
