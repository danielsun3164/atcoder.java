package abc.abc101_150.abc130;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("2 2\n" + "1 3\n" + "3 1", "3");
	}

	@Test
	void case2() {
		check("2 2\n" + "1 1\n" + "1 1", "6");
	}

	@Test
	void case3() {
		check("4 4\n" + "3 4 5 6\n" + "3 4 5 6", "16");
	}

	@Test
	void case4() {
		check("10 9\n" + "9 6 5 7 5 9 8 5 6 7\n" + "8 6 8 5 5 7 9 9 7", "191");
	}

	@Test
	void case5() {
		check("20 20\n" + "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1\n" + "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1",
				"846527861");
	}
}
