package abc075;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("5 7 5", "7");
	}

	@Test
	void case2() {
		check("1 1 7", "7");
	}

	@Test
	void case3() {
		check("-100 100 100", "-100");
	}
}
