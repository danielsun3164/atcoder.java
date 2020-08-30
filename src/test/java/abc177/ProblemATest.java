package abc177;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("1000 15 80", "Yes");
	}

	@Test
	void case2() {
		check("2000 20 100", "Yes");
	}

	@Test
	void case3() {
		check("10000 1 1", "No");
	}
}
