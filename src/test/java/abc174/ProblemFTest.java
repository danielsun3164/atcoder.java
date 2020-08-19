package abc174;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("4 3\n" + "1 2 1 3\n" + "1 3\n" + "2 4\n" + "3 3", "2\n" + "3\n" + "1");
	}

	@Test
	void case2() {
		check("10 10\n" + "2 5 6 5 2 1 7 9 7 2\n" + "5 5\n" + "2 4\n" + "6 7\n" + "2 2\n" + "7 8\n" + "7 9\n" + "1 8\n"
				+ "6 9\n" + "8 10\n" + "6 8",
				"1\n" + "2\n" + "2\n" + "1\n" + "2\n" + "2\n" + "6\n" + "3\n" + "3\n" + "3");
	}
}
