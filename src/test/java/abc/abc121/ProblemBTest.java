package abc.abc121;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("2 3 -10\n" + "1 2 3\n" + "3 2 1\n" + "1 2 2", "1");
	}

	@Test
	void case2() {
		check("5 2 -4\n" + "-2 5\n" + "100 41\n" + "100 40\n" + "-3 0\n" + "-6 -2\n" + "18 -13", "2");
	}

	@Test
	void case3() {
		check("3 3 0\n" + "100 -100 0\n" + "0 100 100\n" + "100 100 100\n" + "-100 100 100", "0");
	}
}
