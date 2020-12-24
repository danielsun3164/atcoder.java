package abc.abc101_150.abc102;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("3", "6");
	}

	@Test
	void case2() {
		check("10", "10");
	}

	@Test
	void case3() {
		check("999999999", "1999999998");
	}

	@Test
	void case4() {
		check("1000000000", "1000000000");
	}
}
