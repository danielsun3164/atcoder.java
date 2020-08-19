package abc072;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("100 17", "83");
	}

	@Test
	void case2() {
		check("48 58", "0");
	}

	@Test
	void case3() {
		check("1000000000 1000000000", "0");
	}
}
