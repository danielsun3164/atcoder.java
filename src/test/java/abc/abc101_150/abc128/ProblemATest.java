package abc.abc101_150.abc128;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("1 3", "3");
	}

	@Test
	void case2() {
		check("0 1", "0");
	}

	@Test
	void case3() {
		check("32 21", "58");
	}
}
