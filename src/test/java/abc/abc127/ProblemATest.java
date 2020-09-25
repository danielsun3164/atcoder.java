package abc.abc127;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("30 100", "100");
	}

	@Test
	void case2() {
		check("12 100", "50");
	}

	@Test
	void case3() {
		check("0 100", "0");
	}
}
