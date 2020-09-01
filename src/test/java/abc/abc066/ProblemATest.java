package abc.abc066;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("700 600 780", "1300");
	}

	@Test
	void case2() {
		check("10000 10000 10000", "20000");
	}
}
