package abc.abc098;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("3 1", "4");
	}

	@Test
	void case2() {
		check("4 -2", "6");
	}

	@Test
	void case3() {
		check("0 0", "0");
	}
}
