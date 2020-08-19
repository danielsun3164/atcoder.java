package past201912;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemHTest extends TestBase {

	@Test
	void case1() {
		check("4\n" + "5 3 3 5\n" + "6\n" + "1 2 1\n" + "2 2\n" + "2 2\n" + "3 100\n" + "3 1\n" + "1 1 3", "9");
	}

	@Test
	void case2() {
		check("10\n" + "241 310 105 738 405 490 158 92 68 20\n" + "20\n" + "2 252\n" + "1 4 36\n" + "2 69\n"
				+ "1 5 406\n" + "3 252\n" + "1 3 8\n" + "1 10 10\n" + "3 11\n" + "1 4 703\n" + "3 1\n" + "2 350\n"
				+ "3 10\n" + "2 62\n" + "2 3\n" + "2 274\n" + "1 2 1\n" + "3 126\n" + "1 4 702\n" + "3 6\n" + "2 174",
				"390");
	}

	@Test
	void case3() {
		check("2\n" + "3 4\n" + "3\n" + "1 2 9\n" + "2 4\n" + "3 4", "0");
	}
}
