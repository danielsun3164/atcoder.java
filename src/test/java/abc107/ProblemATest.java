package abc107;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("4 2", "3");
	}

	@Test
	void case2() {
		check("1 1", "1");
	}

	@Test
	void case3() {
		check("15 11", "5");
	}
}
