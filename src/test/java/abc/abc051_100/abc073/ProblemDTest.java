package abc.abc051_100.abc073;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("3 3 3\n" + "1 2 3\n" + "1 2 1\n" + "2 3 1\n" + "3 1 4", "2");
	}

	@Test
	void case2() {
		check("3 3 2\n" + "1 3\n" + "2 3 2\n" + "1 3 6\n" + "1 2 2", "4");
	}

	@Test
	void case3() {
		check("4 6 3\n" + "2 3 4\n" + "1 2 4\n" + "2 3 3\n" + "4 3 1\n" + "1 4 1\n" + "4 2 2\n" + "3 1 6", "3");
	}
}
