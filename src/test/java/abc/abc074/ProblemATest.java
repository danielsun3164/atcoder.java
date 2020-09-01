package abc.abc074;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "4", "5");
	}

	@Test
	void case2() {
		check("19\n" + "100", "261");
	}

	@Test
	void case3() {
		check("10\n" + "0", "100");
	}
}
