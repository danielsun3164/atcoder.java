package abc.abc128;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("6 4\n" + "-10 8 2 1 2 6", "14");
	}

	@Test
	void case2() {
		check("6 4\n" + "-6 -100 50 -2 -5 -3", "44");
	}

	@Test
	void case3() {
		check("6 3\n" + "-6 -100 50 -2 -5 -3", "0");
	}
}
