package abc.abc086;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("3 4", "Even");
	}

	@Test
	void case2() {
		check("1 21", "Odd");
	}

	@Test
	void case3() {
		check("10000 10000", "Even");
	}
}
