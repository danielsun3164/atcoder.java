package abc080;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("7 17 120", "119");
	}

	@Test
	void case2() {
		check("5 20 100", "100");
	}

	@Test
	void case3() {
		check("6 18 100", "100");
	}
}
