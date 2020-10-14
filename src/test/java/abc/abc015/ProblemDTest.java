package abc.abc015;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("10\n" + "3 2\n" + "4 20\n" + "3 40\n" + "6 100", "140");
	}

	@Test
	void case2() {
		check("10\n" + "5 4\n" + "9 10\n" + "3 7\n" + "3 1\n" + "2 6\n" + "4 5", "18");
	}

	@Test
	void case3() {
		check("22\n" + "5 3\n" + "5 40\n" + "8 50\n" + "3 60\n" + "4 70\n" + "6 80", "210");
	}
}
