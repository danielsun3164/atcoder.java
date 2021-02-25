package abc.abc101_150.abc139;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("4 10", "3");
	}

	@Test
	void case2() {
		check("8 9", "2");
	}

	@Test
	void case3() {
		check("8 8", "1");
	}
}
