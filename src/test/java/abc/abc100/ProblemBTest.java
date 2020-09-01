package abc.abc100;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("0 5", "5");
	}

	@Test
	void case2() {
		check("1 11", "1100");
	}

	@Test
	void case3() {
		check("2 85", "850000");
	}
}
