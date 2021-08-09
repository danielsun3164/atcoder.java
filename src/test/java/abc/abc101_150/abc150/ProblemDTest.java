package abc.abc101_150.abc150;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("2 50\n" + "6 10", "2");
	}

	@Test
	void case2() {
		check("3 100\n" + "14 22 40", "0");
	}

	@Test
	void case3() {
		check("5 1000000000\n" + "6 6 2 6 2", "166666667");
	}

	@Test
	void case4() {
		check("2 1000000000\n" + "6 12", "0");
	}
}
