package abc.abc170;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("3 8", "Yes");
	}

	@Test
	void case2() {
		check("2 100", "No");
	}

	@Test
	void case3() {
		check("1 2", "Yes");
	}
}
