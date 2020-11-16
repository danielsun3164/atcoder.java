package abc.abc182;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "2 -1 -2", "5");
	}

	@Test
	void case2() {
		check("5\n" + "-2 1 3 -1 -1", "2");
	}

	@Test
	void case3() {
		check("5\n" + "-1000 -1000 -1000 -1000 -1000", "0");
	}
}
