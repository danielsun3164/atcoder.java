package abc.abc101_150.abc110;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("1 5 2", "53");
	}

	@Test
	void case2() {
		check("9 9 9", "108");
	}

	@Test
	void case3() {
		check("6 6 7", "82");
	}
}
