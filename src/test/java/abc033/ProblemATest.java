package abc033;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("2222", "SAME");
	}

	@Test
	void case2() {
		check("1221", "DIFFERENT");
	}

	@Test
	void case3() {
		check("0000", "SAME");
	}
}
