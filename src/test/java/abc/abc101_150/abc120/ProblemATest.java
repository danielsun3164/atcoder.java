package abc.abc101_150.abc120;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("2 11 4", "4");
	}

	@Test
	void case2() {
		check("3 9 5", "3");
	}

	@Test
	void case3() {
		check("100 1 10", "0");
	}
}
