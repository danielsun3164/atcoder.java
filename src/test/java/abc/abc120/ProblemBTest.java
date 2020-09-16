package abc.abc120;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("8 12 2", "2");
	}

	@Test
	void case2() {
		check("100 50 4", "5");
	}

	@Test
	void case3() {
		check("1 1 1", "1");
	}
}
