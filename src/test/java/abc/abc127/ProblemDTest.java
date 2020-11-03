package abc.abc127;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("3 2\n" + "5 1 4\n" + "2 3\n" + "1 5", "14");
	}

	@Test
	void case2() {
		check("10 3\n" + "1 8 5 7 100 4 52 33 13 5\n" + "3 10\n" + "4 30\n" + "1 4", "338");
	}

	@Test
	void case3() {
		check("3 2\n" + "100 100 100\n" + "3 99\n" + "3 99", "300");
	}

	@Test
	void case4() {
		check("11 3\n" + "1 1 1 1 1 1 1 1 1 1 1\n" + "3 1000000000\n" + "4 1000000000\n" + "3 1000000000",
				"10000000001");
	}
}
