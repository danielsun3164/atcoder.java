package abc.abc101_150.abc130;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("3 5", "0");
	}

	@Test
	void case2() {
		check("7 5", "10");
	}

	@Test
	void case3() {
		check("6 6", "10");
	}
}
