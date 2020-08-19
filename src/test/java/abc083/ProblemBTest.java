package abc083;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("20 2 5", "84");
	}

	@Test
	void case2() {
		check("10 1 2", "13");
	}

	@Test
	void case3() {
		check("100 4 16", "4554");
	}
}
