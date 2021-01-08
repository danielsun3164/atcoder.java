package abc.abc051_100.abc090;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("5 2", "7");
	}

	@Test
	void case2() {
		check("10 0", "100");
	}

	@Test
	void case3() {
		check("31415 9265", "287927211");
	}
}
