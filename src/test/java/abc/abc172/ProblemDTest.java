package abc.abc172;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("4", "23");
	}

	@Test
	void case2() {
		check("100", "26879");
	}

	@Test
	void case3() {
		check("10000000", "838627288460105");
	}
}
