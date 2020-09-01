package abc.abc097;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("10", "9");
	}

	@Test
	void case2() {
		check("1", "1");
	}

	@Test
	void case3() {
		check("999", "961");
	}
}
