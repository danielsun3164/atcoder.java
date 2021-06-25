package abc.abc101_150.abc148;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "2 1 2", "1");
	}

	@Test
	void case2() {
		check("3\n" + "2 2 2", "-1");
	}

	@Test
	void case3() {
		check("10\n" + "3 1 4 1 5 9 2 6 5 3", "7");
	}

	@Test
	void case4() {
		check("1\n" + "1", "0");
	}
}
