package abc.abc102;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("5\n" + "3 2 4 1 2", "2");

	}

	@Test
	void case2() {
		check("10\n" + "10 71 84 33 6 47 23 25 52 64", "36");
	}

	@Test
	void case3() {
		check("7\n" + "1 2 3 1000000000 4 5 6", "999999994");
	}
}
