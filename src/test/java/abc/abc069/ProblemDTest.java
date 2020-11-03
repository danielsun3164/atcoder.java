package abc.abc069;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("2 2\n" + "3\n" + "2 1 1", "1 1" + LF + "3 2");
	}

	@Test
	void case2() {
		check("3 5\n" + "5\n" + "1 2 3 4 5", "1 2 2 3 3" + LF + "4 4 4 4 3" + LF + "5 5 5 5 5");
	}

	@Test
	void case3() {
		check("1 1\n" + "1\n" + "1", "1");
	}

	@Test
	void case4() {
		check("3 5\n" + "5\n" + "1 1 1 1 11", "1 2 3 4 5" + LF + "5 5 5 5 5" + LF + "5 5 5 5 5");
	}
}
