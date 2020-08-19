package abc001;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("15\n" + "10", "5");
	}

	@Test
	void case2() {
		check("0\n" + "0", "0");
	}

	@Test
	void case3() {
		check("5\n" + "20", "-15");
	}
}
