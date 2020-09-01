package abc.abc027;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("1 1 2", "2");
	}

	@Test
	void case2() {
		check("4 3 4", "3");
	}

	@Test
	void case3() {
		check("5 5 5", "5");
	}
}
