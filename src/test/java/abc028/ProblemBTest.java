package abc028;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("BEAF", "1 1 0 0 1 1");
	}

	@Test
	void case2() {
		check("DECADE", "1 0 1 2 2 0");
	}

	@Test
	void case3() {
		check("ABBCCCDDDDEEEEEFFFFFF", "1 2 3 4 5 6");
	}
}
