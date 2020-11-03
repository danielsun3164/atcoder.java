package abc.abc035;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("2 2 5\n" + "1 3\n" + "1 2 2\n" + "2 1 1", "6");
	}

	@Test
	void case2() {
		check("2 2 3\n" + "1 3\n" + "1 2 2\n" + "2 1 1", "3");
	}

	@Test
	void case3() {
		check("8 15 120\n" + "1 2 6 16 1 3 11 9\n" + "1 8 1\n" + "7 3 14\n" + "8 2 13\n" + "3 5 4\n" + "5 7 5\n"
				+ "6 4 1\n" + "6 8 17\n" + "7 8 5\n" + "1 4 2\n" + "4 7 1\n" + "6 1 3\n" + "3 1 10\n" + "2 6 5\n"
				+ "2 4 12\n" + "5 1 30", "1488");
	}
}
