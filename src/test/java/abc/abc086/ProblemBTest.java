package abc.abc086;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("1 21", "Yes");
	}

	@Test
	void case2() {
		check("100 100", "No");
	}

	@Test
	void case3() {
		check("12 10", "No");
	}
}
