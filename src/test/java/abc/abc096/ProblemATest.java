package abc.abc096;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("5 5", "5");
	}

	@Test
	void case2() {
		check("2 1", "1");
	}

	@Test
	void case3() {
		check("11 30", "11");
	}
}
