package abc.abc095;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("oxo", "900");
	}

	@Test
	void case2() {
		check("ooo", "1000");
	}

	@Test
	void case3() {
		check("xxx", "700");
	}
}
