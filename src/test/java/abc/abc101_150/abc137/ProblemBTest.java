package abc.abc101_150.abc137;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("3 7", "5 6 7 8 9");
	}

	@Test
	void case2() {
		check("4 0", "-3 -2 -1 0 1 2 3");
	}

	@Test
	void case3() {
		check("1 100", "100");
	}
}
