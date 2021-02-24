package abc.abc151_200.abc192;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("3 2 1 3\n" + "1 2 2 3\n" + "2 3 3 4", "7");
	}

	@Test
	void case2() {
		check("3 2 3 1\n" + "1 2 2 3\n" + "2 3 3 4", "5");
	}

	@Test
	void case3() {
		check("3 0 3 1", "-1");
	}

	@Test
	void case4() {
		check("9 14 6 7\n" + "3 1 4 1\n" + "5 9 2 6\n" + "5 3 5 8\n" + "9 7 9 3\n" + "2 3 8 4\n" + "6 2 6 4\n"
				+ "3 8 3 2\n" + "7 9 5 2\n" + "8 4 1 9\n" + "7 1 6 9\n" + "3 9 9 3\n" + "7 5 1 5\n" + "8 2 9 7\n"
				+ "4 9 4 4", "26");
	}
}
