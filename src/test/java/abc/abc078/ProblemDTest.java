package abc.abc078;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("3 100 100\n" + "10 1000 100", "900");
	}

	@Test
	void case2() {
		check("3 100 1000\n" + "10 100 100", "900");
	}

	@Test
	void case3() {
		check("5 1 1\n" + "1 1 1 1 1", "0");
	}

	@Test
	void case4() {
		check("1 1 1\n" + "1000000000", "999999999");
	}
}
