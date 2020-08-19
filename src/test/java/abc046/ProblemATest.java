package abc046;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("3 1 4", "3");
	}

	@Test
	void case2() {
		check("3 3 33", "2");
	}
}
