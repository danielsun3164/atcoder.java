package abc.abc128;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("5\n" + "0 2 5 1 0", "3");
	}

	@Test
	void case2() {
		check("6\n" + "0 10 -7 -4 -13 0", "0");
	}

	@Test
	void case3() {
		check("11\n" + "0 -4 0 -99 31 14 -15 -39 43 18 0", "59");
	}
}
