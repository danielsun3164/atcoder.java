package abc.abc036;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("12 36", "3");
	}

	@Test
	void case2() {
		check("12 100", "9");
	}
}
