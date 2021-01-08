package abc.abc051_100.abc056;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("3 6\n" + "1 4 3", "1");
	}

	@Test
	void case2() {
		check("5 400\n" + "3 1 4 1 5", "5");
	}

	@Test
	void case3() {
		check("6 20\n" + "10 4 3 10 25 2", "3");
	}
}
