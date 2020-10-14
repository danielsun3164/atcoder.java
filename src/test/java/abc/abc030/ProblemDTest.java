package abc.abc030;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("6 4\n" + "5\n" + "2 3 1 2 6 5", "3");
	}

	@Test
	void case2() {
		check("4 1\n" + "100000000000000000000\n" + "2 3 4 1", "1");
	}

	@Test
	void case3() {
		check("8 1\n" + "1\n" + "2 3 4 5 3 2 4 5", "2");
	}
}
