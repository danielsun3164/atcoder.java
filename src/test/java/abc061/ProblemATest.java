package abc061;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("1 3 2", "Yes");
	}

	@Test
	void case2() {
		check("6 5 4", "No");
	}

	@Test
	void case3() {
		check("2 2 2", "Yes");
	}
}
