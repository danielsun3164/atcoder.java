package abc.abc116;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("5 3\n" + "1 9\n" + "1 7\n" + "2 6\n" + "2 5\n" + "3 1", "26");
	}

	@Test
	void case2() {
		check("7 4\n" + "1 1\n" + "2 1\n" + "3 1\n" + "4 6\n" + "4 5\n" + "4 5\n" + "4 5", "25");
	}

	@Test
	void case3() {
		check("6 5\n" + "5 1000000000\n" + "2 990000000\n" + "3 980000000\n" + "6 970000000\n" + "6 960000000\n"
				+ "4 950000000", "4900000016");
	}
}
