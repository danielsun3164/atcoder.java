package abc.abc122;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("3", "61");
	}

	@Test
	void case2() {
		check("4", "230");
	}

	@Test
	void case3() {
		check("100", "388130742");
	}
}
