package abc.abc085;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("1 10\n" + "3 5", "3");
	}

	@Test
	void case2() {
		check("2 10\n" + "3 5\n" + "2 6", "2");
	}

	@Test
	void case3() {
		check("4 1000000000\n" + "1 1\n" + "1 10000000\n" + "1 30000000\n" + "1 99999999", "860000004");
	}

	@Test
	void case4() {
		check("5 500\n" + "35 44\n" + "28 83\n" + "46 62\n" + "31 79\n" + "40 43", "9");
	}
}
