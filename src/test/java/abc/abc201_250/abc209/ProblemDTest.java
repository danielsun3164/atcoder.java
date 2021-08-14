package abc.abc201_250.abc209;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("4 1\n" + "1 2\n" + "2 3\n" + "2 4\n" + "1 2", "Road");
	}

	@Test
	void case2() {
		check("5 2\n" + "1 2\n" + "2 3\n" + "3 4\n" + "4 5\n" + "1 3\n" + "1 5", "Town" + LF + "Town");
	}

	@Test
	void case3() {
		check("9 9\n" + "2 3\n" + "5 6\n" + "4 8\n" + "8 9\n" + "4 5\n" + "3 4\n" + "1 9\n" + "3 7\n" + "7 9\n"
				+ "2 5\n" + "2 6\n" + "4 6\n" + "2 4\n" + "5 8\n" + "7 8\n" + "3 6\n" + "5 6",
				"Town" + LF + "Road" + LF + "Town" + LF + "Town" + LF + "Town" + LF + "Town" + LF + "Road" + LF + "Road"
						+ LF + "Road");
	}
}
