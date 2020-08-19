package abc012;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("1 2", "2 1");
	}

	@Test
	void case2() {
		check("5 5", "5 5");
	}
}
