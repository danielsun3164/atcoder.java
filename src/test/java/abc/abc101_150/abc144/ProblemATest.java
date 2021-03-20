package abc.abc101_150.abc144;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("2 5", "10");
	}

	@Test
	void case2() {
		check("5 10", "-1");
	}

	@Test
	void case3() {
		check("9 9", "81");
	}
}
