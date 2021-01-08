package abc.abc101_150.abc118;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("3 4\n" + "2 1 3\n" + "3 1 2 3\n" + "2 3 2", "1");
	}

	@Test
	void case2() {
		check("5 5\n" + "4 2 3 4 5\n" + "4 1 3 4 5\n" + "4 1 2 4 5\n" + "4 1 2 3 5\n" + "4 1 2 3 4", "0");
	}

	@Test
	void case3() {
		check("1 30\n" + "3 5 10 30", "3");
	}
}
